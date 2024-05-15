package programa;

import java.io.IOException;
import java.lang.foreign.PaddingLayout;
import java.util.ArrayList;

public class Administrador extends Usuario{
    public Administrador(String nombre, String contrasena, String rol) {
        super(nombre, contrasena, rol);
    }

    public static boolean crearNuevoUsuario(String nombre, String contrasena, String rol) throws IOException, ClassNotFoundException {
        Object usuario = new Object();
        boolean res = false;
        ArrayList<Usuario> usuarios = Ficheros.leerDatos(Ficheros.getFicherousuarios());

        usuario = new Administrador(nombre, contrasena, rol);
        usuarios.add((Usuario) usuario);
        res = true;

        Ficheros.insertarDatos(usuarios, Ficheros.getFicherousuarios());


        return res;
    }
}
