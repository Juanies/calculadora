package programa;

public class Administrador extends Usuario{
    public Administrador(String nombre, String contrasena, String rol) {
        super(nombre, contrasena, rol);
    }

    public static boolean crearNuevoUsuario(String nombre, String contrasena, String rol){
        Object usuario = new Object();
        boolean res = false;
        if (rol.equals("Administrador")){
            usuario = new Administrador(nombre, contrasena, rol);
            res = true;
        }else if (rol.equals("Usuario")){
            usuario = new Usuario(nombre, contrasena, rol);
            res = true;
        }
        return res;
    }



}
