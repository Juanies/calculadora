package vista;

import programa.Ficheros;
import programa.Usuario;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Admin extends JFrame {
    public JButton verUsuarios;
    public JButton volver;

    public JButton nuevoUsuario;

    public Admin() throws IOException, ClassNotFoundException {
        setTitle("Tabla de Usuarios");
        setSize(700, 430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        Usuario usuario = Ficheros.getUsuarioActual();

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setBounds(0, 0, 700, 430);
        panel.setLayout(null);

        JLabel x = new JLabel(usuario.getNombre());
        x.setForeground(Color.ORANGE);
        x.setBounds(350, -60, 200, 200);

        verUsuarios = new JButton("Ver usuarios");
        verUsuarios.setBackground(Color.ORANGE);
        verUsuarios.setBounds(280, 80, 140, 40);

        nuevoUsuario = new JButton("Nuevo usuario");
        nuevoUsuario.setBackground(Color.ORANGE);
        nuevoUsuario.setBounds(280, 120, 140, 40);

        volver = new JButton("Volver");
        volver.setBackground(Color.ORANGE);
        volver.setBounds(280, 160, 140, 40);

        panel.add(volver);

        panel.add(nuevoUsuario);

        panel.add(verUsuarios);
        panel.add(x);
        add(panel);

        setVisible(true);
    }
}

