package programa;

import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Ficheros {


    public static File getFicherousuarios(){
        return new File("F:\\1DAM\\Nueva carpeta\\calculadora\\datos\\usuarios.dat");
    }

    public static File getFicheroUsuarioActual(){
        return new File("F:\\1DAM\\Nueva carpeta\\calculadora\\datos\\usuarioActual.dat");
    }

    public static int ultimaIdUsuario() throws IOException, ClassNotFoundException {
        ArrayList<Usuario> usuarios = leerDatos(getFicherousuarios());
        return usuarios.get(usuarios.size() -1).getId();
    }

    public static void primerUsuario() throws IOException {
        ObjectOutputStream x = new ObjectOutputStream(new FileOutputStream(getFicherousuarios()));
        x.writeObject(new Usuario("Paco", "123", "Admin"));
        x.close();
    }

    public static ArrayList<Usuario> leerDatos(File file) throws IOException, ClassNotFoundException {
        ArrayList<Usuario> datos = new ArrayList<>();

        if (file.exists()) {
            FileInputStream fin = new FileInputStream(file);
            ObjectInputStream ofin = new ObjectInputStream(fin);
                while (fin.available() > 0) {
                    Usuario equipo = (Usuario) ofin.readObject();
                    datos.add(equipo);
                }
        }
        return datos;
    }


    public static ArrayList<Usuario> leerDatos2() throws IOException, ClassNotFoundException {
        ArrayList<Usuario> datos = new ArrayList<>();
        File file = getFicherousuarios();

        if (file.exists()) {
            FileInputStream fin = new FileInputStream(file);
            ObjectInputStream ofin = new ObjectInputStream(fin);
            while (fin.available() > 0) {
                Usuario equipo = (Usuario) ofin.readObject();
                datos.add(equipo);
                System.out.println(equipo);
            }
        }
        return datos;
    }


    public static void insertarDatos(ArrayList<Usuario> nuevosDatos, File fichero) throws IOException, ClassNotFoundException {
        ArrayList<Usuario> datos = leerDatos(fichero);

        datos.addAll(nuevosDatos);

        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(fichero));

        for(int con2 = 0; con2 < datos.size(); con2++){
            oout.writeObject(datos.get(con2));
        }

        oout.close();

    }

    public static void insertarSoloUnDato(Object nuevosDato, File fichero) throws IOException, ClassNotFoundException {
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(fichero));

        oout.writeObject(nuevosDato);

        oout.close();
    }
}
