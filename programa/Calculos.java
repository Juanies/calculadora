package programa;

public class Calculos {

    public static void calcular(String numero){
        String regex = "[/*\\-+]";
        String[] numeros = numero.split(regex);

    }

    public static double  Sumar(double  num1, double  num2){
        return num1 + num2;
    }

    public static double  Restar(double  num1, double  num2){
        return num1 - num2;
    }
    public static double  Dividir(double  num1, double  num2){
        return num1 / num2;
    }
    public static double  Multiplicar(double  num1, double  num2){
        return num1 * num2;
    }

    public static double Potencia(double  num1, double  num2){
        return num1 * num2;
    }

    public static double Dividir1(double  num2){
        return 1 / num2;
    }


}
