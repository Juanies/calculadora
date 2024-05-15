package vista;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Calculadora extends JFrame {
    public JFrame frame;
    public JPanel buttonPanel;
    public JLabel display;
    public JLabel user;
    public JLabel rol;
    public JButton changeUser;
    public ArrayList<JButton> botones;




    public Calculadora() {
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

        display = new JLabel();
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setPreferredSize(new Dimension(100, 20));
        display.setLayout(null);
        display.setBounds(100, 100, 20, 20);
        mainPanel.add(display);


        botones = new ArrayList<>();

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10));
        String[] buttonLabels = {
                "1/x", "x\u00B2", "CE", "\u21E6",
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                ".", "0", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            botones.add(button);
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

    public void setRes(String res){ display.setText(res); }

    public String getRes(){
        return display.getText();
    }

}
