package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import programa.*;
import vista.*;

import javax.swing.*;

public class CalculadoraControlador implements ActionListener {

    private Calculadora calc;
    public String linea = "";
    public CalculadoraControlador(Calculadora calculadora) throws IOException, ClassNotFoundException {
        this.calc = calculadora;
        calculadora.setUser(Ficheros.getUsuarioActual().getNombre());
        calculadora.setRol(Ficheros.getUsuarioActual().getRol());

        for(JButton boton : calculadora.botones){
            boton.addActionListener(this);
        }

        calculadora.changeUser.addActionListener(this);
        teclado(this);
    }

    public  void teclado(CalculadoraControlador x) {
        Teclado x2 = new Teclado(x);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
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
                try {
                    equal();
                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                break ;
            default:
                actualizarLinea(e.getActionCommand());
                break;
        }
    }

    public static void cambiarUsuario(Calculadora calculadora){
        Ventanas ventana = new Ventanas();
        new LoginControlador(ventana.CalculadoraALogin(calculadora));
    }

    public void equal() throws IOException, ClassNotFoundException {
        try{

            if(linea.equals("777") && Ficheros.getUsuarioActual().getRol().equals("Admin")){
                Ventanas ventana = new Ventanas();
                try {

                    Admin admin = ventana.CalculadoraAadmin(calc);
                    new AdminControlador(admin);

                } catch (IOException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else if(linea.equals("777") && !Ficheros.getUsuarioActual().getRol().equals("Admin")) {
                JOptionPane.showMessageDialog(null, "Contraseña o Rol Incorrecto");
            }
            else{

                String res = String.valueOf(Calculos.calcular(linea));
                calc.setRes(res);
                linea = res;

            }
        }catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Contraseña o Rol Incorrecto");
        }

    }

    public void setLinea(String linea) {
        this.linea += linea;
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

