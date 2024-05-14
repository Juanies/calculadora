
package programa;

import controlador.CalculadoraControlador;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;


    public class Teclado {
        public char letra;
        public int code;

        public Teclado(CalculadoraControlador ob) {
            KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
            manager.addKeyEventPostProcessor(new KeyEventPostProcessor() {
                @Override
                public boolean postProcessKeyEvent(KeyEvent e) {
                    if (e.getID() == KeyEvent.KEY_PRESSED) {
                        letra = e.getKeyChar();
                        code = e.getKeyCode();
                        try {
                            comprobarLetra(ob);
                        } catch (IOException | ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }

                    }
                    return true;
                }
            });
        }

        public void comprobarLetra(CalculadoraControlador ob) throws IOException, ClassNotFoundException {
            ArrayList<Character> simbolos = new ArrayList<>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9', '/', '+', '-', '*', '='));


            if (code == 8){
                ob.borrarUnNumero();
            }else if (simbolos.contains(letra)){
                ob.actualizarLinea(String.valueOf(letra));
            }else if (code == KeyEvent.VK_ENTER) {
                ob.equal();
            }

        }


    }




