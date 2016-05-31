/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lumix.link;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author cristy gutzu
 */
public class Request {
    public static URL url;
    public static HttpURLConnection connection; 

  
    
    public static String recMode(){
        try {
            Request.url = new URL("http://192.168.54.1/cam.cgi?mode=camcmd&value=recmode");
            Request.connection = (HttpURLConnection) url.openConnection();
            String responseMessage = connection.getResponseMessage();
            return responseMessage;
        } catch (IOException ex) {
            return "Impossibile raggiungere il dispositivo";
        }
    }
    
    public static String startStream(){
        try {
            Request.url = new URL("http://192.168.54.1/cam.cgi?mode=startstream&value=49199");
            Request.connection = (HttpURLConnection) url.openConnection();
            String responseMessage = connection.getResponseMessage();
            return responseMessage;
        } catch (IOException ex) {
            return "Impossibile raggiungere il dispositivo";
        }
    }
    
    public static String getState(){
        try {
            Request.url = new URL("http://192.168.54.1/cam.cgi?mode=getstate");
            Request.connection = (HttpURLConnection) url.openConnection();
            String responseMessage = connection.getResponseMessage();
            return responseMessage;
        } catch (IOException ex) {
            return "Impossibile raggiungere il dispositivo";
        }
    }
    
    public static String stopStream(){
        try {
            Request.url = new URL("http://192.168.54.1/cam.cgi?mode=stopstream");
            Request.connection = (HttpURLConnection) url.openConnection();
            String responseMessage = connection.getResponseMessage();
            return responseMessage;
        } catch (IOException ex) {
            return "Impossibile raggiungere il dispositivo";
        }
    }
    
    public static String capture(){
        try {
            Request.url = new URL("http://192.168.54.1/cam.cgi?mode=camcmd&value=capture");
            Request.connection = (HttpURLConnection) url.openConnection();
            String responseMessage = connection.getResponseMessage();
            return responseMessage;
        } catch (IOException ex) {
            return "Impossibile raggiungere il dispositivo";
        }
    }

    static String getInfo(){
        try {
            Request.url = new URL("http://192.168.54.1/cam.cgi?mode=getinfo&type=capability");
            Request.connection = (HttpURLConnection) url.openConnection();
            String responseMessage = connection.getResponseMessage();
            return responseMessage;
        } catch (IOException ex) {
            return "Impossibile raggiungere il dispositivo";
        }
    }
}
