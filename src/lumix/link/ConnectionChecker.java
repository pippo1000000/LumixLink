/*
Classe ConnectionChecker per il controllo della presenza
della connessione con la fotocamera
*/
package lumix.link;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionChecker implements Runnable {
    private final UDPServer s;
    private boolean againOnline=false;
    boolean toto = true;
    
    public ConnectionChecker(UDPServer s) {
        this.s = s;
    }
    
    @Override
    public void run() {
        toto=true;
        while(toto) {      
            if(!this.isReachable("192.168.54.1", 80, 1000)) {
                this.againOnline = true;
            }
            else if (this.againOnline) {
                s.stop();
                Request.recMode(); 
                Request.startStream();
                new Thread(s).start();
                this.againOnline = false;
                GUI.appendMessage("Connessione al dispositivo ristabilita");
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ConnectionChecker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void stop(){
        toto = false;
    }
    
    static boolean isReachable(String addr, int openPort, int timeOutMillis) {
        // Any Open port on other machine
        // openPort =  22 - ssh, 80 or 443 - webserver, 25 - mailserver etc.
        try {
            try (Socket soc = new Socket()) {
                soc.connect(new InetSocketAddress(addr, openPort), timeOutMillis);
                }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }  
}
