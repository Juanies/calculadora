package programa;

import vista.Admin;
import vista.LoginForm;
import vista.Calculadora;

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

}
