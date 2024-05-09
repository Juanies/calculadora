package programa;

import vista.LoginForm;
import vista.Calculadora;

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

}
