/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ArqSoft.Room;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.in;
import static java.lang.System.out;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author pabloperfalc
 */
public class Room {
    static BufferedReader in;
    static ServerSocket server = null;
    static Socket client = null;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        listenSocket();
        
        while(true){
            try{
              String line = in.readLine();
              //Send data back to client
              out.println(line);
            } catch (IOException e) {
              System.out.println("Read failed");
              System.exit(-1);
            }
        }
    }
    
    
public static void listenSocket(){

    try{
       server = new ServerSocket(5555); 
    } catch (IOException e) {
      System.out.println("Could not listen on port 5555");
      System.exit(-1);
    }

//listenSocketSocketserver.acceptSocket
  try{
    client = server.accept();
  } catch (IOException e) {
    System.out.println("Accept failed: 5555");
    System.exit(-1);
  }
    
//listenSocketBufferedReaderclientPrintWriter
  try{
   in = new BufferedReader(new InputStreamReader(
                           client.getInputStream()));
    //out = new PrintWriter(client.getOutputStream(), true);
   } catch (IOException e) {
     System.out.println("Read failed");
     System.exit(-1);
   }
 }

//listenSocket
    
    
}
