package programa;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Usuario implements Serializable {
    @Serial
    private static final long serialVersionUID = -6083946477523703971L;
    static int contador;

    static {
        try {
            contador = Ficheros.ultimaIdUsuario();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private int id;
    private String nombre;
    private String rol;
    private String contrasena;
    private String fechaInicioSesion;
    private String fechaCreacion = cogerfecha();

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaInicioSesion() {
        return fechaInicioSesion;
    }

    public void setFechaInicioSesion(String nombre) throws IOException, ClassNotFoundException {
        this.fechaInicioSesion = fechaInicioSesion;

        ArrayList<Usuario> usuarios = Ficheros.leerDatos(Ficheros.getFicherousuarios());

        for(Usuario usuario : usuarios){
            if (usuario.getNombre().equals(nombre)){
                usuario.fechaInicioSesion = cogerfecha();
            }
        }

        Ficheros.insertarDatos(usuarios, Ficheros.getFicherousuarios());
    }


    public Usuario(String nombre, String contrasena, String rol) {
        this.id = ++contador;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public static String cogerfecha() {
        Date fechaActual = new Date();

        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fechaActual);

        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int anio = calendario.get(Calendar.YEAR);

        return hora + ":" + minutos + " " + dia + "-" + mes + "-" + anio;
    }

    public static boolean iniciarSesion(String nombre, String contraseña) throws IOException, ClassNotFoundException {

        boolean resultado = false;

        File fichero = Ficheros.getFicherousuarios();
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(fichero));

        ArrayList<Usuario> datos = Ficheros.leerDatos(Ficheros.getFicherousuarios());

        for(Usuario dato : datos){
            if (dato.getNombre().equals(nombre) && dato.getContrasena().equals(contraseña)){
                resultado = true;
                Ficheros.insertarDato(dato, Ficheros.getFicheroUsuarioActual());
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
