package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;

public class Servidor extends Thread {

    public static void main(String args[]) {
        ServerSocket sfd = null;

        try {
            sfd = new ServerSocket(7000);
            System.out.println("Servidor iniciado en puerto 7000");
        } catch (IOException ioe) {
            System.out.println("Comunicación rechazada." + ioe);
            System.exit(1);
        }

        while (true) {
            Socket nsfd = null;
            try {
                nsfd = sfd.accept();
                System.out.println("Conexion aceptada de: " + nsfd.getInetAddress());

                DataInputStream entrada = new DataInputStream(nsfd.getInputStream());

                String comando = entrada.readUTF();

                if (comando.equals("BACKUP")) {
                    String fecha = LocalDate.now().toString();
                    String nombreArchivo = "backups/[" + fecha + "].dat";

                    new File("backups").mkdirs();

                    DataOutputStream escritor = new DataOutputStream(
                            new FileOutputStream(new File(nombreArchivo)));

                    int unByte;
                    while ((unByte = entrada.read()) != -1) {
                        escritor.write(unByte);
                    }

                    escritor.close();
                    System.out.println("Respaldo guardado en: " + nombreArchivo);

                } else if (comando.equals("LOG")) {
                    String lineaLog = entrada.readUTF();

                    new File("logs").mkdirs();

                    String fecha = LocalDate.now().toString();
                    String nombreLog = "logs/" + fecha + ".log";

                    FileWriter escritor = new FileWriter(nombreLog, true);
                    escritor.write(lineaLog + "\n");
                    escritor.close();

                    System.out.println("Log añadido a: " + nombreLog);

                } else {
                    System.out.println("Comando desconocido recibido: " + comando);
                }

                entrada.close();
                nsfd.close();

            } catch (IOException ioe) {
                System.out.println("Error: " + ioe);
                if (nsfd != null) {
                    try {
                        nsfd.close();
                    } catch (IOException ex) {}
                }
            }
        }
    }
}