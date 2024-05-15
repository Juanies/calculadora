package  controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import programa.Usuario;
import programa.Ventanas;
import vista.*;
public class  CrearUsuarioControlador implements ActionListener {
    private final nuevosUsuarios nuevosusuarios;

    public CrearUsuarioControlador(LoginForm view, nuevosUsuarios nuevosusuarios) {
        this.nuevosusuarios = nuevosusuarios;
        view.loginButton.addActionListener(this);
    }

    public CrearUsuarioControlador(nuevosUsuarios login) {
        this.nuevosusuarios = login;
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
        Ventanas ventana = new Ventanas();

        calculadora = ventana.loginaCalculadora(res, login);

        Usuario user = Usuario.buscarUsuarioPorNombre(login.getUsuario());
        calculadora.setUser(user.getNombre());
        calculadora.setRol(user.getRol());
        login.esInicioValido(res);
        new CalculadoraControlador(calculadora);
    }

}