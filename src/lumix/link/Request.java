/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lumix.link;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author cristy gutzu
 */
public class Request {
    public static URL url;
    public static HttpURLConnection connection; 

  
    
    public static String recMode() throws MalformedURLException, IOException{
        Request.url = new URL("http://192.168.54.1/cam.cgi?mode=camcmd&value=recmode");
        Request.connection = (HttpURLConnection) url.openConnection();
        String responseCode = connection.getResponseCode() + "";
        return responseCode;
    }
    
    public static void startStream() throws MalformedURLException, IOException{
        Request.url = new URL("http://192.168.54.1/cam.cgi?mode=startstream&value=49199");
        Request.connection = (HttpURLConnection) url.openConnection();
        int responseCode = connection.getResponseCode();
        System.out.println(responseCode);
    }
    
    public static void getState() throws MalformedURLException, IOException{
        Request.url = new URL("http://192.168.54.1/cam.cgi?mode=getstate");
        Request.connection = (HttpURLConnection) url.openConnection();
        int responseCode = connection.getResponseCode();
        System.out.println(responseCode);
    }
    
    public static String capture() throws MalformedURLException, IOException{
        Request.url = new URL("192.168.54.1/cam.cgi?mode=camcmd&value=capture");
        Request.connection = (HttpURLConnection) url.openConnection();
        String responseCode = "" + connection.getResponseCode();
        return "ciaoooo";
    }
}
