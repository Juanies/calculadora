package  controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import programa.*;
import vista.*;

import javax.swing.*;

import static programa.Usuario.cogerfecha;


public class  LoginControlador implements ActionListener {
    private final LoginForm login;
    private Calculadora calculadora;

    public LoginControlador(LoginForm view) {
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
                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
        }
    }

    public void setLogin() throws IOException, ClassNotFoundException {
        boolean res = Usuario.iniciarSesion(login.getUsuario(), login.getPassword());

        if (res){
            Ventanas ventana = new Ventanas();

            calculadora = ventana.loginaCalculadora(res, login);
            Ficheros.usuarioActual();

            Usuario user = Usuario.buscarUsuarioPorNombre(login.getUsuario());
            user.setFechaInicioSesion(login.getUsuario());

            Ficheros.setUsuarioActual(login.getUsuario());

            login.esInicioValido(res);

            new CalculadoraControlador(calculadora);
        }else{
            JOptionPane.showMessageDialog(null, "Error al iniciar sesion");

        }

    }

}