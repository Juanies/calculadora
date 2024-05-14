package programa;

import vista.Calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class Teclado {
    char letra;
    public Teclado(Object vista) {
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventPostProcessor(new KeyEventPostProcessor() {
            @Override
            public boolean postProcessKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED) {
                    letra = e.getKeyChar();
                }
                return false;
            }
        });


    }


}
