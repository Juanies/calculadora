import controlador.Controlador;
import programa.Ficheros;
import programa.Usuario;
import vista.*;

import java.io.IOException;
import java.util.ArrayList;

public class maintemporal {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
         LoginForm login = new LoginForm();
         new Controlador(login);
    }
}
