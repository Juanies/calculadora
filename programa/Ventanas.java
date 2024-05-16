package programa;

import controlador.AdminControlador;
import controlador.CrearUsuarioControlador;
import vista.Admin;
import vista.Calculadora;
import vista.LoginForm;
import vista.NuevosUsuarios;

import javax.swing.*;
import java.io.IOException;

public class Ventanas {

    public Calculadora loginaCalculadora(Boolean cambiar, LoginForm login){
        Calculadora calc = null;
        if (cambiar){
            login.dispose();
            calc = new Calculadora();
        }
        return  calc;
    }

    public LoginForm CalculadoraALogin( Calculadora calculadora){
        LoginForm login = null;
        calculadora.dispose();
        login = new LoginForm();
        return  login;
    }

    public Admin CalculadoraAadmin(Calculadora calculadora) throws IOException, ClassNotFoundException {
        Admin admin = null;
        calculadora.dispose();
        admin = new Admin();
        return  admin;
    }

    public Admin CrearUsuarioAAdmin(NuevosUsuarios nuevousuarios) throws IOException, ClassNotFoundException {
        Admin admin = null;
        nuevousuarios.dispose();
        admin = new Admin();
        new AdminControlador(admin);
        return  admin;
    }


    public <T> T administraNuevoObjeto(JFrame viejaVista, T nuevaVista) throws IOException, ClassNotFoundException {
        T nuevoObjeto = null;
         viejaVista.dispose();


        nuevoObjeto = nuevaVista;

        return nuevoObjeto;
    }

    public NuevosUsuarios AdminaNuevoUsuario(Admin vista) throws IOException, ClassNotFoundException {
        NuevosUsuarios nuevosusuarios = null;
        vista.dispose();
        nuevosusuarios = new NuevosUsuarios();
        new CrearUsuarioControlador(nuevosusuarios);
        return  nuevosusuarios;
    }

}
