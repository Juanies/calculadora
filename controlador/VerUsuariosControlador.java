package  controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import programa.Ventanas;
import vista.*;


public class VerUsuariosControlador implements ActionListener {
    private final Usuarios vista;

    public VerUsuariosControlador(Usuarios vista) {
        this.vista = vista;
        vista.volver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        switch (e.getActionCommand()){
            case "Volver":
                try {

                    Ventanas x = new Ventanas();
                    Admin admin = new Admin();
                    x.administraNuevoObjeto(vista, admin);
                    new AdminControlador(admin);

                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                break;
        }
    }
}