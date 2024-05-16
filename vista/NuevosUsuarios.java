package vista;

import javax.swing.*;
import java.awt.*;

public class NuevosUsuarios extends JFrame {
    public JButton volver;
    public JButton crearUsuario;
    public JLabel titulo;
    public JLabel usuarioLabel;
    public JLabel contraseñaLabrl;
    public JTextField usuario;
    public JTextField contraseña;
    public JComboBox rol;

    public NuevosUsuarios() {
        setTitle("Crear usuario");
        setSize(400, 430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        titulo = new JLabel("Crea un usuario");
        titulo.setBounds(140, 20, 140, 40);
        add(titulo);

        JLabel usuarioLabel = new JLabel("Username:");
        usuarioLabel.setBounds(67, 80, 80, 25);
        add(usuarioLabel);

        usuario = new JTextField(20);
        usuario.setBounds(67, 110, 220, 25);
        add(usuario);

        JLabel contrasenaLabel = new JLabel("Password:");
        contrasenaLabel.setBounds(67, 160, 80, 25);
        add(contrasenaLabel);

        contraseña = new JPasswordField(20);
        contraseña.setBounds(67, 190, 220, 25);
        add(contraseña);


        crearUsuario = new JButton("Register");
        crearUsuario.setBounds(67, 280, 220, 25);
        crearUsuario.setBackground(Color.ORANGE);
        crearUsuario.setForeground(Color.BLACK);
        add(crearUsuario);

        volver = new JButton("Volver");
        volver.setBounds(67, 320, 220, 25);
        add(volver);

        String[] choices = {"Usuario", "Admin"};
        rol = new JComboBox<>(choices);
        rol.setBounds(67, 220, 220, 25);
        add(rol);


        setVisible(true);
    }

    public String getUsuario() {
        return usuario.getText();
    }

    public void setUsuario(JTextField usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña.getText();
    }

    public void setContraseña(JTextField contraseña) {
        this.contraseña = contraseña;
    }

    public String getRol() {
        return (String) rol.getSelectedItem();
    }

    public void setRol(JComboBox rol) {
        this.rol = rol;
    }
}
