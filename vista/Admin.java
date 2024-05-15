package vista;

import programa.Ficheros;
import programa.Usuario;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Admin extends JFrame {
    public JButton verUsuarios;

    public JButton nuevoUsuario;

    public Admin() throws IOException, ClassNotFoundException {
        setTitle("Tabla de Usuarios");
        setSize(700, 430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        Usuario usuario = Ficheros.usuarioActual();

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

        panel.add(nuevoUsuario);

        panel.add(verUsuarios);
        panel.add(x);
        add(panel);

        setVisible(true);
    }
}

