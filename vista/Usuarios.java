package vista;

import programa.Ficheros;
import programa.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Usuarios extends JFrame {

    public JButton volver;

    public Usuarios() throws IOException, ClassNotFoundException {
        setTitle("Tabla de Usuarios");
        setSize(700, 430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayList<Usuario> usuarios = Ficheros.leerDatos(Ficheros.getFicherousuarios());

        String[] columnNames = {"ID", "Nombre", "Rol", "Creacion", "Inicio sesion"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Usuario usuario : usuarios) {
            Object[] rowData = {usuario.getId(), usuario.getNombre(), usuario.getRol(), usuario.getFechaCreacion(), usuario.getFechaInicioSesion()};
            System.out.println(usuario.getFechaInicioSesion());
            model.addRow(rowData);
        }

        volver = new JButton("Volver");
        volver.setBounds(67, 300, 220, 25);
        volver.setBackground(Color.ORANGE);
        volver.setForeground(Color.BLACK);
        add(volver);

        JTable table = new JTable(model);
        table.isCellEditable(-2, -2);


        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}

