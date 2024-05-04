import programa.Ficheros;
import programa.Usuario;
import vista.*;

import java.io.IOException;
import java.util.ArrayList;

public class maintemporal {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

         new calculadora();

        ArrayList<Usuario> x = new ArrayList<>();
        x.add(new Usuario("4", "123", "Usuario"));
        x.add(new Usuario("4", "123", "Usuario"));

        x.add(new Usuario("JODER", "123", "Usuario"));

        Ficheros.insertarDatos(x);
        Ficheros.leerDatos2();
    }
}
