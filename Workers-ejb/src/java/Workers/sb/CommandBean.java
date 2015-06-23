/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workers.sb;

import Entities.Command;
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
public class CommandBean implements ICommandBeanRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Command> getCommandList(int room) {
        List<Command> lista = new ArrayList<Command>();
        try {
            InitialContext ctx = new InitialContext();
            //PersistenciaRemote per = (PersistenciaRemote) ctx.lookup("java:global/WorkFromHome/Persistencia-ejb/PersistenciaSB");
            //lista = per.getCommandList();
        } catch (NamingException ex) {
           // Logger.getLogger(ProyectoSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    
}
