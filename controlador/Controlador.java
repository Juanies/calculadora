package  controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import programa.Usuario;
import programa.Ventanas;
import vista.*;
public class Controlador implements ActionListener {
    private LoginForm login;

    public Controlador(LoginForm view) {
        this.login = view;
        view.loginButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        switch (e.getActionCommand()){
            case "Login":
                try {
                    setLogin();
                    break;
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
        }
    }

    public void setLogin() throws IOException, ClassNotFoundException {

        System.out.println("Iniciando Sesion");
        Boolean res = Usuario.iniciarSesion(login.getUsuario(), login.getPassword());
        Ventanas.loginaCalculadora(res, login);
        login.esInicioValido(res);
    }

}