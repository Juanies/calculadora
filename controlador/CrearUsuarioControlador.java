package  controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import programa.Administrador;
import programa.Ventanas;
import vista.*;
public class  CrearUsuarioControlador implements ActionListener {
    private final NuevosUsuarios nuevosusuarios;

    public CrearUsuarioControlador(NuevosUsuarios vista) {
        this.nuevosusuarios = vista;

        vista.crearUsuario.addActionListener(this);
        vista.usuario.addActionListener(this);
        vista.contraseña.addActionListener(this);
        vista.rol.addActionListener(this);
        vista.volver.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e){
        switch (e.getActionCommand()){
            case "Register":
                try {

                    System.out.println("x");
                    Administrador.crearNuevoUsuario(nuevosusuarios.getUsuario(), nuevosusuarios.getContraseña(), nuevosusuarios.getRol());
                    break;

                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            case "Volver":

                Ventanas x = new Ventanas();
                System.out.println("x");

                try {
                    x.CrearUsuarioAAdmin(nuevosusuarios);
                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
        }
    }



}