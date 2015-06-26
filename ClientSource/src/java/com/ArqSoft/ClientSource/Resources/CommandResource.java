/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ArqSoft.ClientSource.Resources;

import com.ArqSoft.DTOs.QueueCommand;
import java.io.Serializable;
import javax.annotation.Resource;
import javax.faces.bean.RequestScoped;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    @Resource(mappedName = "jms/commandsQueue")
    private static Queue commandsQueue;
    @Resource(mappedName = "jms/commandsQueueFactory")
    private static ConnectionFactory commandsQueueFactory;
    

    /*@EJB
    private ICommandBeanRemote commandBean;*/
    
    //@EJB
    //private CommandMapper commandMapper;
    
    
    @GET
    @Produces("application/json")
    public /*List<Command>*/void get(int room) {
       // List<Command> commands = this.commandBean.getCommandList(room);
       /*ACA SE TENDRIAN USAR DTOS*/
       // List<Command> dtos = new LinkedList<>();
       /* for (Command comm : commands) {
            dtos.add(this.commandMapper.toDTO(auto));
        }*/        
       // return commands;
    }
    
    @POST
    @Produces("application/json")
    @Consumes("application/x-www-form-urlencoded")
    public void set(@FormParam("idCommand") int idCommand, @FormParam("idRoom") int idRoom) {
    //public void set(int idCommand){
        //this.commandBean.sendCommand(idRoom, idCommand);
       /*ACA SE TENDRIAN USAR DTOS*/
       // List<Command> dtos = new LinkedList<>();
       /* for (Command comm : commands) {
            dtos.add(this.commandMapper.toDTO(auto));
        }*/    
        try{       
        QueueCommand command = new QueueCommand();
        command.setCommandId(idCommand);
       // command.setRoomId(idRoom);
        sendJMSMessageToCommandsQueue(command);
        }catch(JMSException e){
                }
        
      }
    
    private static Message createJMSMessageForjmsCommandsQueue(Session session, Object messageData) throws JMSException {
        ObjectMessage om =  session.createObjectMessage();
        om.setObject((Serializable) messageData);
        return om;
    }

    private static void sendJMSMessageToCommandsQueue(Object messageData) throws JMSException {
        Connection connection = null;
        Session session = null;
        try {
            connection = commandsQueueFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(commandsQueue);
            messageProducer.send(createJMSMessageForjmsCommandsQueue(session, messageData));
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e) {
                    //Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);
                }
            }
            if (connection != null) {
                connection.close();
            }
        }
        }
    }