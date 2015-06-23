/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientSource.Resources;

import Entities.Command;
import Workers.sb.ICommandBeanRemote;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author cauito
 */
@Path("commands")
@RequestScoped
public class CommandResource {
    @Context
    private UriInfo context;

    @EJB
    private ICommandBeanRemote commandBean;
    
    //@EJB
    //private CommandMapper commandMapper;
    
    
    @GET
    @Produces("application/json")
    public List<Command> get(int room) {
        List<Command> commands = this.commandBean.getCommandList(room);
       /*ACA SE TENDRIAN USAR DTOS*/
        List<Command> dtos = new LinkedList<Command>();
       /* for (Command comm : commands) {
            dtos.add(this.commandMapper.toDTO(auto));
        }*/
        
        return dtos;
    }
    /*@GET
    @Produces("application/json")
    public String get(){
        
        return "ANDUVOOOOO";
    }*/
    }
    