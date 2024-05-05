package programa;

import vista.LoginForm;
import vista.calculadora;

import javax.swing.*;

public class Ventanas {

    public calculadora loginaCalculadora(Boolean cambiar, LoginForm login){
        calculadora calc = null;
        if (cambiar){
            login.dispose();
            calc = new calculadora();
        }
        return  calc;
    }

}
