/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lumix.link;
import java.net.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.*;
import java.util.Arrays;
/**
 *
 * @author filip
 */
public class UDPServer extends JPanel implements Runnable {
 
	DatagramSocket theSocket = null;
	int serverPort = 49199;
        private InetAddress myip;
        
    BufferedImage image;
    BufferedImage bufferedImage = null;
    
    public Dimension getPreferredSize() {
             return new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
    }
    public void paint(Graphics g) {

        if ( bufferedImage != null ){
            g.drawImage(bufferedImage, 0, 0, getWidth(), (getWidth()*9/16), this);
        }
    }
    private void initSocket(){
          if (theSocket != null && !theSocket.isClosed())theSocket.close();
        try {
			myip = InetAddress.getLocalHost();
                        theSocket = new DatagramSocket(serverPort);
			System.out.println("Socket UDP all'indirizzo IP " + myip.getHostAddress() +" nella porta " + serverPort + " creato");
		} catch (SocketException ExceSocket)
		{
			System.out.println("Errore nella creazione del Socket : "+ ExceSocket.getMessage());
		}
                catch(UnknownHostException e) {
			System.out.println("Impossibile trovare l'indirizzo IP");
		}
                
    }
	public UDPServer()
	{
		this.initSocket();
	}
        
        private boolean toto;

    @Override
    public void run() {
        this.initSocket();
        DatagramPacket theRecievedPacket;
        byte[] outBuffer;
        byte[] inBuffer; 
        byte[] soi;
        int offset=132;
        inBuffer = new byte[30000];
       
            
        toto = true;
        while( toto ){
        try {   
           
            theRecievedPacket = new DatagramPacket(inBuffer, inBuffer.length, myip, serverPort);
            theSocket.receive(theRecievedPacket);
            outBuffer = theRecievedPacket.getData();
            for (int i = 130; i < 320; i += 1){
                if(outBuffer[i]==-1 && outBuffer[i+1]==-40){
                offset = i; 
                }
            }
            byte [] newBuffer = Arrays.copyOfRange( outBuffer, offset, theRecievedPacket.getLength() );
            bufferedImage = ImageIO.read( new ByteArrayInputStream( newBuffer ) );
            repaint();
        }   catch (IOException ExceIO){
            System.out.println("Error with client request : "+ExceIO.getMessage());
            }
        }
        theSocket.close();
        
    
    }
    
    public void stop(){
        toto = false;
    }
}
