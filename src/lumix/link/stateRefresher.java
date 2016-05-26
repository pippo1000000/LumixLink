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

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10000);
                Request.getState();
                System.out.println("Requesting state!");
            } catch (InterruptedException ex) {
                Logger.getLogger(stateRefresher.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(stateRefresher.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
