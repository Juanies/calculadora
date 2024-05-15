package programa;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Registro implements Serializable {
    private static final long serialVersionUID = 1L; // Ensure consistent serialization

    public String nombreUsuario;
    public String fecha;

    public Registro(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.fecha = cogerfecha();
    }

    public static File ficheroRegistro() {
        return new File("datos/iniciosSesion.dat");
    }

    public static ArrayList<Registro> leerRegistro() throws IOException, ClassNotFoundException {
        ArrayList<Registro> datos = new ArrayList<>();

        if (ficheroRegistro().length() > 0) {
            try (ObjectInputStream ofin = new ObjectInputStream(new FileInputStream(ficheroRegistro()))) {
                while (ofin.available() > 0) {
                    try {
                        Registro registro = (Registro) ofin.readObject();
                        datos.add(registro);
                    } catch (EOFException e) {
                        break; // End of file reached
                    }
                }
            }
        }
        return datos;
    }

    public static void escribirRegistro(Registro registro) throws IOException, ClassNotFoundException {
        ArrayList<Registro> registros = leerRegistro();
        registros.add(registro);

        try (ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(ficheroRegistro()))) {
            for (Registro reg : registros) {
                oout.writeObject(reg);
            }
        }
    }

    private static String cogerfecha() {
        Date fechaActual = new Date();

        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fechaActual);

        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int anio = calendario.get(Calendar.YEAR);

        return hora + ":" + minutos + " " + dia + "-" + mes + "-" + anio;
    }

    // Getters and setters if needed
}
