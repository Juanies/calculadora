package vista;


import javax.swing.*;
import java.awt.*;

public class calculadora extends JFrame {
    private JFrame frame;
    private JPanel buttonPanel;
    private JTextField display;

    public calculadora() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);


        display = new JTextField();
        display.setEditable(true); // PONER FALSE PARA QUE NO SE PUEDA EDITAR
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setPreferredSize(new Dimension(300, 80));
        display.setFont(new Font("Arial", Font.PLAIN, 24));

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 7, 10, 10));

        String[] buttonLabels = {
                "1/x", "x\u00B2", "CE", "\u21E6",
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                ".", "0", "=", "+"
        };


        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            buttonPanel.add(button);
            buttonPanel.setFont(new Font("Arial", Font.PLAIN, 24));


        }

        frame.add(display, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}