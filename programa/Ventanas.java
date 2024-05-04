package programa;

import vista.LoginForm;

import javax.swing.*;

public class Ventanas {

    public static void loginaCalculadora(Boolean cambiar, LoginForm login){
        if (cambiar){
            login.dispose();
            new vista.calculadora();
        }
    }

}
