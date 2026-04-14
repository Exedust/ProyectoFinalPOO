package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.util.Arrays;

public class Servidor {

    public static void main(String args[]) {
        ServerSocket sfd = null;
        try {
            sfd = new ServerSocket(7000);
            System.out.println("Servidor iniciado correctamente en puerto 7000");
        } catch (IOException ioe) {
            System.out.println("Error al iniciar el servidor: " + ioe.getMessage());
            System.exit(1);
        }

        while (true) {
            Socket nsfd = null;
            DataInputStream entrada = null;
            DataOutputStream salida = null;

            try {
                nsfd = sfd.accept();
                System.out.println("Conexión aceptada desde: " + nsfd.getInetAddress());

                entrada = new DataInputStream(nsfd.getInputStream());
                salida = new DataOutputStream(nsfd.getOutputStream());

                String comando = entrada.readUTF();

                switch (comando) {
                    case "BACKUP":
                        guardarBackup(entrada);
                        break;

                    case "LOG":
                        guardarLog(entrada);
                        break;

                    case "RESTORE":
                        enviarUltimoRespaldo(salida);
                        break;

                    default:
                        System.out.println("Comando desconocido recibido: " + comando);
                        break;
                }

            } catch (IOException ioe) {
                System.out.println("Error durante la conexión: " + ioe.getMessage());
            } finally {
                try {
                    if (entrada != null) entrada.close();
                    if (salida != null) salida.close();
                    if (nsfd != null) nsfd.close();
                } catch (IOException ex) {
                }
            }
        }
    }

    private static void guardarBackup(DataInputStream entrada) throws IOException {
        String fecha = LocalDate.now().toString();
        String nombreArchivo = "backups/[" + fecha + "].dat";
        new File("backups").mkdirs();

        try (DataOutputStream escritor = new DataOutputStream(new FileOutputStream(nombreArchivo))) {
            int unByte;
            while ((unByte = entrada.read()) != -1) {
                escritor.write(unByte);
            }
        }
        System.out.println("Respaldo guardado correctamente en: " + nombreArchivo);
    }

    private static void guardarLog(DataInputStream entrada) throws IOException {
        String lineaLog = entrada.readUTF();
        new File("logs").mkdirs();
        String fecha = LocalDate.now().toString();
        String nombreLog = "logs/" + fecha + ".log";

        try (FileWriter escritor = new FileWriter(nombreLog, true)) {
            escritor.write(lineaLog + "\n");
        }
        System.out.println("Log añadido a: " + nombreLog);
    }

    private static void enviarUltimoRespaldo(DataOutputStream salida) throws IOException {
        File carpetaBackups = new File("backups");

        if (!carpetaBackups.exists() || !carpetaBackups.isDirectory()) {
            System.out.println("No existe la carpeta de backups.");
            return;
        }

        File[] archivos = carpetaBackups.listFiles((dir, name) -> name.endsWith(".dat"));

        if (archivos == null || archivos.length == 0) {
            System.out.println("No hay respaldos disponibles para enviar.");
            return;
        }

        Arrays.sort(archivos, (a, b) -> Long.compare(b.lastModified(), a.lastModified()));

        File ultimoRespaldo = archivos[0];

        System.out.println("Enviando el respaldo más reciente: " + ultimoRespaldo.getName());

        try (FileInputStream fis = new FileInputStream(ultimoRespaldo)) {
            int unByte;
            while ((unByte = fis.read()) != -1) {
                salida.write(unByte);
            }
        }

        System.out.println("Respaldo enviado correctamente al cliente.");
    }
}