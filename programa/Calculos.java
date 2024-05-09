package programa;

public class Calculos {

    public static double calcular(String numero){
        String regex = "[/*+-]";
        char simbolo = ' ';
        char[] caracter = numero.toCharArray();
        for(int con = 0; con < numero.length(); con++){
            if (!Character.isDigit(caracter[con]) && caracter[con] != ' '){
                simbolo = caracter[con];
            }
        }
        double resultado = 0;
        String[] numeros = numero.split("[/*+-]");
        double numero1 = Double.parseDouble(numeros[0]);
        double numero2 = Double.parseDouble(numeros[1]);
        switch (simbolo) {
            case '+':
                resultado = Sumar(numero1, numero2);
                break;
            case '-':
                resultado = Restar(numero1 , numero2);
                break;
            case '*':
                resultado = Multiplicar(numero1, numero2);
                break;
            case '/':
                if (numero2 != 0) {
                    resultado = Dividir(numero1, numero2);
                } else {
                    System.out.println("No se puede dividir por cero.");
                }
                break;

    }
        return resultado;
    }

    public static double Sumar(double  num1, double  num2){
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

    public static double Potencia(double num1){
        return Math.pow(num1 ,2);
    }

    public static double Dividir1(double  num2){
        return 1 / num2;
    }


}

