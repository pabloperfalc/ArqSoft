/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 *
 * @author cauito
 */
public class Client {

    private static String userName;
    private static String password;
    public static void main(String[] args){
        
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese nombre de usuario");
        userName = s.nextLine();
        System.out.println("Ingrese contraseña");
        password = s.nextLine();
        
        try{
        String uri ="http://localhost:8080/ClientSource/webresources/userSession/test";
        URL url = new URL(uri);
        HttpURLConnection connection =(HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        
       
        
       String res = connection.getContent().toString();
        JAXBContext jc = JAXBContext.newInstance(String.class);
        
        //InputStream result = connection.getInputStream();
        String o = res;
        //System.out.println(res);
        


        
        
    }   catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
}
