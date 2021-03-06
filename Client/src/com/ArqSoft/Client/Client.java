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
        
        Scanner s = new Scanner(System.in);
        
        
        System.out.println("Ingrese nombre de usuario");
        userName = s.nextLine();
        System.out.println("Ingrese contraseña");
        password = s.nextLine();
        
        Client.LogIn(userName, password);
        
        System.out.println("Ingrese comando");
        String commando = s.nextLine();
        SendCommand(1,  Integer.parseInt(commando));
        
      
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
        String uri ="http://localhost:8080/ClientSource/webresources/commands/create/" + commandId +"/" + roomId;
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
 
       }catch(Exception e){}
    
    
    }
    
}
