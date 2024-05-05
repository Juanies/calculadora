package vista;

import javax.swing.*;
import java.awt.*;

public class calculadora extends JFrame {
    private JFrame frame;
    private JPanel buttonPanel;
    private JTextField display;
    private JLabel user;
    private JLabel rol;
    private JButton changeUser;


    public calculadora() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel userInfoPanel = new JPanel(new BorderLayout());

        user = new JLabel("Usuario");
        userInfoPanel.add(user, BorderLayout.WEST);

        rol = new JLabel("Rol");
        userInfoPanel.add(rol, BorderLayout.CENTER);

        changeUser = new JButton("Cambiar usuario");
        userInfoPanel.add(changeUser, BorderLayout.EAST);


        mainPanel.add(userInfoPanel, BorderLayout.NORTH);

        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.PLAIN, 24));

        mainPanel.add(display, BorderLayout.CENTER);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
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

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    public void setUser(String usuario) {
        user.setText(usuario);
    }

    public void setRol(String role) {
        rol.setText(" - "+ role);
    }


}
