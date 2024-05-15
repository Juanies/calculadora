import controlador.CalculadoraControlador;
import controlador.CrearUsuarioControlador;
import controlador.LoginControlador;
import programa.Ficheros;
import programa.Teclado;
import vista.*;

import java.io.IOException;

public class maintemporal {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        nuevosUsuarios x = new nuevosUsuarios();
        new CrearUsuarioControlador(x);

    }
} 
