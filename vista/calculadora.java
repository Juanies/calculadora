package vista;

import javax.swing.*;
import java.awt.*;

public class calculadora extends JFrame {
    private JFrame frame;
    private JPanel buttonPanel;
    private JTextField display;
    private JLabel user;
    private JLabel rol;

    public calculadora() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        // Crear panel para user y rol
        JPanel topPanel = new JPanel(new BorderLayout());

        user = new JLabel("");
        user.setHorizontalAlignment(SwingConstants.LEFT); // Alineación a la izquierda
        topPanel.add(user, BorderLayout.WEST); // Añadir user a la izquierda

        rol = new JLabel("");
        rol.setHorizontalAlignment(SwingConstants.RIGHT); // Alineación a la derecha
        topPanel.add(rol, BorderLayout.EAST); // Añadir rol a la derecha

        // Configurar display (parte superior)
        display = new JTextField();
        display.setEditable(true);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setPreferredSize(new Dimension(300, 80));
        display.setFont(new Font("Arial", Font.PLAIN, 24));

        // Configurar panel de botones (parte central)
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10)); // Ajustar el diseño

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                ".", "0", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            buttonPanel.add(button);
        }

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(display, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public void setUser(String usuario) {
        user.setText("Usuario : " + usuario + " ");
    }

    public void setRol(String role) {
        rol.setText("Rol : " + role + " ");
    }


}
