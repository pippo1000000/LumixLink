/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lumix.link;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chnedev
 */
public class stateRefresher implements Runnable {
    boolean toto = true;
    
    @Override
    public void run() {
        toto=true;
        while(toto){
            try {
                Thread.sleep(10000);
                GUI.appendMessage("Aggiornamento dello stato del dispositivo. Risposta: " + Request.getState());
            } catch (InterruptedException ex) {
                Logger.getLogger(stateRefresher.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(stateRefresher.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public void stop(){
        toto=false;
    }
    
}
