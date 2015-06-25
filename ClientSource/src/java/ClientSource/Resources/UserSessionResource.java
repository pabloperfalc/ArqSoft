/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientSource.Resources;

import com.ArqSoft.DTOs.User;
import com.ArqSoft.Login.LoginSb;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * REST Web Service
 *
 * @author cauito
 */
@Path("userSession")
@RequestScoped
public class UserSessionResource {
    @Context
    private UriInfo context;
    @EJB
    private LoginSb login;   

   

    @POST
    @Path("iniciarSesion")
    @Consumes("application/json")
    @Produces("application/json")
    public String IniciarSesion(User u)  {         
        return login.Login(u);
    }
    
    @GET
    @Path("test")
    @Consumes("application/json")
    @Produces("application/json")
    public String test()  {         
        return "ANDUVO WEB SERVICE";
    }   
}
