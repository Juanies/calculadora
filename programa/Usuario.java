package programa;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import programa.Ficheros.*;
public class Usuario {
    private String nombre;
    private int id = 0;
    private String rol;
    private String contrasena;

    // Iniciar sesion



    public Usuario(String nombre, String contrasena, String rol) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = rol;
        id++;
    }

    //TODO: Hacer el inicio de sesion
    public static boolean iniciarSesion(String nombre, String contraseña) throws IOException {
        File fichero = Ficheros.getFicherousuarios();
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(fichero));
        boolean resultado = false;





        return resultado;
    }



    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", rol='" + rol + '\'' +
                '}';
    }


}
