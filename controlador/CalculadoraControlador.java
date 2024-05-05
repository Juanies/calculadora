package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;

import programa.Calculos;
import programa.Usuario;
import programa.Ventanas;
import vista.*;

import javax.swing.*;

public class CalculadoraControlador implements ActionListener {

    private  Calculadora calc;

    public CalculadoraControlador(Calculadora calculadora) {
        this.calc = calculadora;

        for(JButton boton : calculadora.botones){
            boton.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "1":
                System.out.println("1");
                break;
            case "2":
                System.out.println("2");
                break;
        }
    }
}