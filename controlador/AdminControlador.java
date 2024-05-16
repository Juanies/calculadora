package controlador;

import programa.Ventanas;
import vista.Admin;
import vista.Calculadora;
import vista.Usuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AdminControlador implements ActionListener {

    private final Admin admin;

    public AdminControlador(Admin vista){
        this.admin = vista;

        vista.verUsuarios.addActionListener(this);
        vista.nuevoUsuario.addActionListener(this);
        vista.volver.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Ver usuarios":
                try {
                    Ventanas x = new Ventanas();
                    Usuarios usuario = new Usuarios();
                    x.administraNuevoObjeto(admin, usuario);
                    new VerUsuariosControlador(usuario);

                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            case "Nuevo usuario":
                Ventanas ventana = new Ventanas();
                try {
                    ventana.AdminaNuevoUsuario(admin);

                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            case "Volver":
                Ventanas x = new Ventanas();
                Calculadora calculadora = new Calculadora();

                try {
                    x.administraNuevoObjeto(admin, calculadora);
                    new CalculadoraControlador(calculadora);

                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                break;
        }
    }
}
