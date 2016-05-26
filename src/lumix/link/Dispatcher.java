/*
Classe Dispatcher per la chiusura del programma
alla pressione del tasto 'esc'
*/
package lumix.link;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

public class Dispatcher implements KeyEventDispatcher {
    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
        } 
        return false;
    }
}
