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
    public Usuarios() throws IOException, ClassNotFoundException {
        setTitle("Tabla de Usuarios");
        setSize(700, 430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ArrayList<Usuario> usuarios = Ficheros.leerDatos(Ficheros.getFicherousuarios());

        String[] columnNames = {"ID", "Nombre", "Rol", "Acción"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Usuario usuario : usuarios) {
            Object[] rowData = {usuario.getId(), usuario.getNombre(), usuario.getRol(), "Eliminar"};
            model.addRow(rowData);
        }

        JTable table = new JTable(model);
        table.isCellEditable(-2, -2);


        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}

