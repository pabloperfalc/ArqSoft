/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ArqSoft.Workers.sb;

import com.ArqSoft.DTOs.Command;
import com.ArqSoft.Persistence.PersistenceSb;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author cauito
 */
@Stateless
@LocalBean
public class CommandBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

  
    public List<Command> getCommandList(int room) {
        List<Command> lista = new ArrayList<>();
        try {
            InitialContext ctx = new InitialContext();
            PersistenceSb per = (PersistenceSb) ctx.lookup("java:global/ArqSoft/Persistence/PersistenceSb");
            //lista = per.getCommandList(room);
        } catch (NamingException ex) {
           // Logger.getLogger(ProyectoSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }


    public void sendCommand(int idRoom, int idCommand) {
        
            
    }
    
    
}
