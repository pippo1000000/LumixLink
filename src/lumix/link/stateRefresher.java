/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lumix.link;

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
                GUI.appendMessage("Aggiornamento dello stato del dispositivo. Risposta: " + Request.getState());
                Thread.sleep(10000);
                GUI.doit();
            } catch (InterruptedException ex) {
                System.out.println("Connessione assente");
            }           
        }
    }
    
    public void stop(){
        toto=false;
    }
    
}
