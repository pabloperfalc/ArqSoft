/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.Scanner;

/**
 *
 * @author cauito
 */
public class Client {

    private static String userName;
    private static String password;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese nombre de usuario");
        userName = s.nextLine();
        System.out.println("Ingrese contraseña");
        password = s.nextLine();
        
        
    }
    
}
