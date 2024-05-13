package vista;

import controlador.LoginControlador;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.net.URL;


public class LoginForm extends JFrame {

    public JButton loginButton;
    private JTextField usuarioField;
    private JPasswordField contrasenaField;
    private JLabel inicioIncorrecto;

    public LoginForm() {


        setTitle("Login Form");
        setSize(    700, 430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Establecer el layout a null para posicionamiento absoluto

        JPanel frame = new JPanel();
        frame.setBackground(Color.BLACK);
        frame.setBounds(350, 0, 350, 430);
        frame.setLayout(null);

        ImageIcon imageIcon = new ImageIcon("OIP.jpg");

        JLabel label = new JLabel(imageIcon);
        label.setBounds(15, 100, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        label.setHorizontalTextPosition(label.CENTER);
        frame.add(label);

        JLabel titulo = new JLabel("Tu calculadora");
        titulo.setBounds(70, 20, 200, 25);
        titulo.setFont(new Font("Arial", Font.PLAIN, 30));
        titulo.setForeground(Color.ORANGE);
        frame.add(titulo);


        add(frame);


        JLabel textPanel = new JLabel("Inicia Sesión");
        textPanel.setBounds(135, 10, 100, 25);
        textPanel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(textPanel);

        JLabel usuarioLabel = new JLabel("Username:");
        usuarioLabel.setBounds(67, 90, 80, 25);
        add(usuarioLabel);

        usuarioField = new JTextField(20);
        usuarioField.setBounds(67, 120, 220, 25);
        add(usuarioField);

        JLabel contrasenaLabel = new JLabel("Password:");
        contrasenaLabel.setBounds(67, 170, 80, 25);
        add(contrasenaLabel);

        contrasenaField = new JPasswordField(20);
        contrasenaField.setBounds(67, 200, 220, 25);
        add(contrasenaField);

        inicioIncorrecto = new JLabel("");
        inicioIncorrecto.setBounds(180, 100, 160, 25);
        add(inicioIncorrecto);

        loginButton = new JButton("Login");
        loginButton.setBounds(67, 300, 220, 25);
        loginButton.setBackground(Color.ORANGE);
        loginButton.setForeground(Color.BLACK);
        add(loginButton);

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public String getUsuario() {
        return usuarioField.getText();
    }

    public String getPassword() {
        return new String(contrasenaField.getPassword());
    }

    public void esInicioValido(boolean resultado) {
        if (resultado) {
            inicioIncorrecto.setText("Inicio válido");
        } else {
            inicioIncorrecto.setText("Inicio inválido");
        }
    }
}
