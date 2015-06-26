/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ArqSoft.Client;

import com.ArqSoft.DTOs.QueueCommand;
import com.ArqSoft.DTOs.User;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

/**
 *
 * @author cauito
 */
public class Client {

    private static String userName;
    private static String password;
    
    private static BufferedReader br;
    public static void main(String[] args){
        
        SendCommand(1, 2);
        
        Scanner s = new Scanner(System.in);
        
        
        System.out.println("Ingrese nombre de usuario");
        userName = s.nextLine();
        System.out.println("Ingrese contraseña");
        password = s.nextLine();
        
        Client.LogIn(userName, password);
        
      
}
    
    private static void LogIn(String userName, String password){
        
        User userAux = new User(userName, password);
     try{
        String uri ="http://localhost:8080/ClientSource/webresources/userSession/test";
        URL url = new URL(uri);
        HttpURLConnection connection =(HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Accept", "application/json");
        
      
       
        String res = "";
        String line;
       
        br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
         while ((line = br.readLine()) != null) {
            res += line;
         }
      
       
        System.out.println(res);  
        //PONER LAS DISTINTAS EXCEPTIONS
       }catch(Exception e){}
    
    
    }
    
    private static void SendCommand(int roomId, int commandId){
        
        QueueCommand command = new QueueCommand();
        command.setCommandId((commandId));
        command.setRoomId(roomId);
     try{
        String uri ="http://localhost:8080/ClientSource/webresources/commands/";
        URL url = new URL(uri);
        HttpURLConnection connection =(HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Accept", "application/json");
      
        String query = "idCommand="+URLEncoder.encode("1","UTF-8"); 
            query += "&";
            query += "idRoom="+URLEncoder.encode("2","UTF-8") ;
        
        
        ((HttpURLConnection)connection).setRequestMethod("POST");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        connection.setRequestProperty("Content-Length", ""+ query.length());
 
        // Create I/O streams
        DataOutputStream outStream = new DataOutputStream(connection.getOutputStream());
        DataInputStream inStream = new DataInputStream(connection.getInputStream());
 
        // Send request
        outStream.writeBytes(query);
        outStream.flush();
        outStream.close();
 
       }catch(Exception e){}
    
    
    }
    
}
