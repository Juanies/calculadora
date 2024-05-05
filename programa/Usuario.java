package programa;

import java.io.*;
import java.util.ArrayList;

import programa.Ficheros.*;
public class Usuario implements Serializable {
    private static final long serialVersionUID = -6083946477523703971L;
    static int contador; // Contador estático para generar IDs únicos

    static {
        try {
            contador = Ficheros.ultimaIdUsuario();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private int id;                   // ID único para cada usuario
    private String nombre;
    private String rol;
    private String contrasena;

    public Usuario(String nombre, String contrasena, String rol) {
        this.id = ++contador;          // Incrementar contador y asignar como ID único
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = rol;
    }
    //TODO: Hacer el inicio de sesion
    public static boolean iniciarSesion(String nombre, String contraseña) throws IOException, ClassNotFoundException {
        File fichero = Ficheros.getFicherousuarios();
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(fichero));
        boolean resultado = false;
        ArrayList<Usuario> datos = Ficheros.leerDatos(Ficheros.getFicherousuarios());

        for(Usuario dato : datos){
            if (dato.getNombre().equals(nombre) && dato.getContrasena().equals(contraseña)){
                resultado = true;
                Ficheros.insertarSoloUnDato(dato, Ficheros.getFicheroUsuarioActual());
            }
        }

        return resultado;
    }

    public static boolean NombreUsuarioRepetido(ArrayList<Usuario> usuarios, String nombreUsuario){
        boolean res = false;
        for(Usuario dato : usuarios){
            if (nombreUsuario.equals(dato.getNombre())){
                res = true;
            }
        }
        return res;
    }

    public static Usuario buscarUsuarioPorNombre(String nombre) throws IOException, ClassNotFoundException {
        ArrayList<Usuario> usuarios = Ficheros.leerDatos(Ficheros.getFicherousuarios());
        Usuario resultado = null;
        for(Usuario dato : usuarios){
            if (dato.getNombre().equals(nombre)){
                resultado = dato;
            }
        }
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

    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                ", rol='" + rol + '\'' +
                '}';
    }


}
