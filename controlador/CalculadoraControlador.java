package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;

import programa.Calculos;
import programa.Usuario;
import programa.Ventanas;
import vista.*;

import javax.sound.sampled.Line;
import javax.swing.*;

public class CalculadoraControlador implements ActionListener {

    private  Calculadora calc;
    public String linea = "";
    public CalculadoraControlador(Calculadora calculadora) {
        this.calc = calculadora;

        for(JButton boton : calculadora.botones){
            boton.addActionListener(this);
        }

        calculadora.changeUser.addActionListener(this);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "1":
                actualizarLinea("1");
                break;
            case "2":
                actualizarLinea("2");
                break;
            case "3":
                actualizarLinea("3");
                break;
            case "4":
                actualizarLinea("4");
                break;
            case "5":
                actualizarLinea("5");
                break;
            case "6":
                actualizarLinea("6");
                break;
            case "7":
                actualizarLinea("7");
                break;
            case "8":
                actualizarLinea("8");
                break;
            case "9":
                actualizarLinea("9");
                break;
            case "+":
                actualizarLinea("+");
                break;
                case "/":
                    actualizarLinea("/");
                break;
                case "*":
                    actualizarLinea("*");
                break;
                case "-":
                    actualizarLinea("-");
                break;
            case "x\u00B2":
                potencia();
                break;
            case "\u21E6":
                borrarUnNumero();
                break;
            case "1/x":
                didivir1();
                break;
            case "CE":
                resetear();
                break;
            case "Cambiar usuario":
                cambiarUsuario(calc);
                break;
            case "=":
                calc.setRes(String.valueOf(Calculos.calcular(linea)));;
                break;
        }
    }

    public static void cambiarUsuario(Calculadora calculadora){
        Ventanas ventana = new Ventanas();
        new LoginControlador(ventana.CalculadoraALogin(calculadora));

    }

    public void didivir1(){
        double resultado = Calculos.Dividir1(Double.parseDouble(linea));
        calc.setRes(String.valueOf(resultado));
    }

    public void actualizarLinea(String numero){
        linea += numero;
        calc.setRes(linea.trim());
    }

    public void potencia(){
        double numero = Double.parseDouble(linea);
        calc.setRes(String.valueOf(Calculos.Potencia(numero)));
    }

    public void borrarUnNumero(){
        linea = linea.substring(0, linea.length() - 1);
        calc.setRes(linea.trim());
    }

    public void resetear(){
        linea = " ";
        calc.setRes(linea);
    }

}