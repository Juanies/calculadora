package programa;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Administrador extends Usuario{
    public Administrador(String nombre, String contrasena, String rol) {
        super(nombre, contrasena, rol);
    }

    public static boolean crearNuevoUsuario(String nombre, String contrasena, String rol) throws IOException, ClassNotFoundException {
        Object usuario = new Object();
        boolean res = false;
        ArrayList<Usuario> usuarios = Ficheros.leerDatos(Ficheros.getFicherousuarios());


        if (!Usuario.NombreUsuarioRepetido(usuarios, nombre)){
            usuario = new Administrador(nombre, contrasena, rol);
            usuarios.add((Usuario) usuario);
            res = true;
        }else{
            JOptionPane.showMessageDialog(null, "Nombre de usuario ya Existe");
        }


        Ficheros.insertarDatos(usuarios, Ficheros.getFicherousuarios());


        return res;
    }
}
