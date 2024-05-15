package controlador;

import vista.Admin;
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

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "Ver usuarios":
                try {
                    new Usuarios();
                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                break;
            case "Nuevo usuario":
                System.out.println("b");
                break;
        }
    }
}
