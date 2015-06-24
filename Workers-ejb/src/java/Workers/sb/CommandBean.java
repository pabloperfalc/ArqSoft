/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workers.sb;

import Entities.Command;
import com.ArqSoft.persistencia.IRemotePersistence;
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
        List<Command> lista = new ArrayList<>();
        try {
            InitialContext ctx = new InitialContext();
            IRemotePersistence per = (IRemotePersistence) ctx.lookup("java:global/ArqSoft/Persistence/PersistenceSB");
            lista = per.getCommandList(room);
        } catch (NamingException ex) {
           // Logger.getLogger(ProyectoSB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public void setCommand(int idRoom, int idCommand) {
        
            
    }
    
    
}
