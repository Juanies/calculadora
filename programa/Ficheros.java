package programa;

import java.io.*;
import java.util.ArrayList;

public class Ficheros {

    public static File getFicherousuarios(){
        return new File("usuarios.dat");
    }

    public static ArrayList<Object> leerObjectoFichero() throws IOException, ClassNotFoundException {

        ObjectInputStream  oi = new ObjectInputStream(new FileInputStream(getFicherousuarios()));
        ArrayList<Object> res = new ArrayList<>();

        while (oi.available() > 0){
            Object ob = oi.readObject();
            res.add(ob);
        }

        oi.close();
        return res;

    }


    public static boolean insertarObjetosFichero(File fichero, ArrayList<Object> objetosInsertar)  {

        Boolean res = true;



       try {

           ArrayList<Object> objetos = leerObjectoFichero();


           for(Object datos : objetosInsertar){
               objetos.add(datos);
           }

           ObjectOutputStream Oout = new ObjectOutputStream(new FileOutputStream(getFicherousuarios()));

           for(Object datos : objetos){
               Oout.writeObject(datos);
           }

           Oout.close();

       }catch (Exception e){

           res = false;
           e.printStackTrace();
       }
        return res;
    }

}
