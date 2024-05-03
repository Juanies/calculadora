package programa;

public class Usuario {
    private String nombre;
    private int id;
    private String rol;
    private String contrasena;

    // Iniciar sesion

    public Usuario(String nombre, String contrasena, int id, String rol) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.id = id;
        this.rol = rol;
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
