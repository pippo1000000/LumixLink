/*
Classe ConnectionChecker per il controllo della presenza
della connessione con la fotocamera
*/
package lumix.link;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionChecker implements Runnable {
    private UDPServer s;
    private boolean againOnline=false;
    
    public ConnectionChecker(UDPServer s) {
        this.s = s;
    }
    
    @Override
    public void run() {
        while(true) {      
        try {
            if(!this.isReachable("192.168.54.1", 80, 2000)) {
                s.stop();
                this.againOnline = true;
                System.out.println("Offline!");
            }
            else if (this.againOnline) {
                Request.recMode(); 
                Request.startStream();
                new Thread(s).start();
                this.againOnline = false;
                System.out.println("Online Again!");
            }              
        } catch (UnknownHostException ex) {
                s.stop();
                Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                s.stop();
                Logger.getLogger(UDPServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
