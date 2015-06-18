/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientSource.Resources;

import Workers.sb.CommandBean;
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

    //@EJB
    //private CommandBean commandBean;
    
    //@EJB
    //private CommandMapper commandMapper;
    
    
    /*@GET
    @Produces("application/json")
    public List<AutoDTO> get() {
        List<Command> autos = this.commandBean.obtenerAutos();
        List<AutoDTO> dtos = new LinkedList<AutoDTO>();
        for (Command auto : autos) {
            dtos.add(this.commandMapper.toDTO(auto));
        }
        
        return dtos;
    }*/
    @GET
    @Produces("application/json")
    public String get(){
        
        return "ANDUVOOOOO";
    }
    }
