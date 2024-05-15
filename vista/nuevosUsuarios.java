package vista;

import javax.swing.*;
import java.awt.*;

public class nuevosUsuarios extends JFrame {
    public JButton volver;
    public JButton crearUsuario;
    public JLabel titulo;
    public JLabel usuarioLabel;
    public JLabel contraseñaLabrl;
    public JTextField usuario;
    public JTextField contraseña;
    public JComboBox rol;

    public nuevosUsuarios() {
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


        crearUsuario = new JButton("Login");
        crearUsuario.setBounds(67, 280, 220, 25);
        crearUsuario.setBackground(Color.ORANGE);
        crearUsuario.setForeground(Color.BLACK);
        add(crearUsuario);

        String[] choices = {"Usuario", "Admin"};
        JComboBox<String> choiceBox = new JComboBox<>(choices);
        choiceBox.setBounds(67, 220, 220, 25);
        add(choiceBox);


        setVisible(true);

    }

}
