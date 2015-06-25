/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ArqSoft.Login;

import com.ArqSoft.DTOs.User;
import com.ArqSoft.Persistence.PersistenceSb;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author cauito
 */
@Stateless
public class LoginSb {

    public String Login(User u)
    {
        try {
            InitialContext ctx = new InitialContext();
            PersistenceSb per = (PersistenceSb) ctx.lookup("java:global/WorkFromHome/Persistence/PersistenceSb");    
            User ret = per.SearchByName(u.getUserName());
            if(ret == null)
            {
                return "Nombre de usuario invalido";
            }
            if(!ret.getPassword().equals(u.getPassword()))
            {
                return "Contrasenia invalida";
            }            
            //return per.ObtenerToken(u.getNombre());            
        } catch (NamingException ex) {
            //Logger.getLogger(LoginSB.class.getName()).log(Level.SEVERE, null, ex);
            return "nada";
        }
        return "Usuario conectado exitosamente";
    }
       
}
