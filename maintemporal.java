import controlador.LoginControlador;
import vista.*;

import java.io.IOException;

public class maintemporal {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
         LoginForm login = new LoginForm();

         new LoginControlador(login);
    }
}
