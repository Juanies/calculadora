import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame {

    private JTextField usuarioField;
    private JPasswordField contrasenaField;
    private JLabel inicioIncorrecto;

    public LoginForm() {
        setTitle("Login Form");
        setSize(400, 230);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Establecer el layout a null para posicionamiento absoluto

        JLabel textPanel = new JLabel("Inicia Sesión");
        textPanel.setBounds(150, 10, 100, 25);
        textPanel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(textPanel);

        JLabel usuarioLabel = new JLabel("Username:");
        usuarioLabel.setBounds(90, 40, 80, 25);
        add(usuarioLabel);

        usuarioField = new JTextField(20);
        usuarioField.setBounds(180, 40, 160, 25);
        add(usuarioField);

        JLabel contrasenaLabel = new JLabel("Password:");
        contrasenaLabel.setBounds(90, 70, 80, 25);
        add(contrasenaLabel);

        contrasenaField = new JPasswordField(20);
        contrasenaField.setBounds(180, 70, 160, 25);
        add(contrasenaField);

        inicioIncorrecto = new JLabel("");
        inicioIncorrecto.setBounds(180, 100, 160, 25);
        add(inicioIncorrecto);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(180, 130, 90, 25);
        add(loginButton);

        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true);

        esInicioInvalido(false);

    }

    public String getUsuario() {
        return usuarioField.getText();
    }

    public String getPassword() {
        return new String(contrasenaField.getPassword());
    }

    public void esInicioInvalido(boolean resultado) {
        if (resultado) {
            inicioIncorrecto.setText("Inicio inválido");
        } else {
            inicioIncorrecto.setText("Inicio válido");
        }

    }
}
