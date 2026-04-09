package logico;

import java.io.*;

public class GestorArchivos {

    private static final String ARCHIVO = "altice.dat";

    public static boolean guardar(Altice altice) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            
            oos.writeObject(altice);

            System.out.println("Datos guardados correctamente en " + ARCHIVO);
            return true;

        } catch (IOException e) {
            System.out.println("Error al guardar los datos.");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean cargar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            
            Altice alticeCargada = (Altice) ois.readObject();
            
            Altice.setInstance(alticeCargada);

            System.out.println("Datos cargados correctamente desde " + ARCHIVO);
            return true;

        } catch (IOException e) {
            System.out.println("No se encontró archivo de respaldo. Se iniciará con datos vacíos.");
            return false;
        } catch (ClassNotFoundException e) {
            System.out.println("Error al leer los datos (clase no encontrada).");
            e.printStackTrace();
            return false;
        }
    }
}