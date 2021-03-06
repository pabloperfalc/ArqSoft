/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuetest;

import com.ArqSoft.DTOs.QueueCommand;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

/**
 *
 * @author pabloperfalc
 */
public class Main {
    @Resource(mappedName = "jms/commandsQueue")
    private static Queue commandsQueue;
    @Resource(mappedName = "jms/commandsQueueFactory")
    private static ConnectionFactory commandsQueueFactory;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JMSException {
        // TODO code application logic here
/*System.out.print("Enter something:");
String input = System.console().readLine();
System.out.print(input);
 input = System.console().readLine();*/
        
        
        /*QueueCommand command = new QueueCommand();
        command.setCommandId(123);
        command.setRoomId(567);
        sendJMSMessageToCommandsQueue(command);*/
        listenSocket();
    }

    private static Message createJMSMessageForjmsCommandsQueue(Session session, Object messageData) throws JMSException {
        // TODO create and populate message to send
        ObjectMessage om =  session.createObjectMessage();
        om.setObject((Serializable) messageData);
        //TextMessage tm = session.createTextMessage();
        //tm.setText(messageData.toString());
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
    
    
public static void listenSocket(){
//Create socket connection
   try{
     Socket socket = new Socket("localhost", 5555);
     PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
     out.println("test");
     //in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
   } catch (UnknownHostException e) {
     System.out.println("Unknown host: kq6py");
     System.exit(1);
   } catch  (IOException e) {
     System.out.println("No I/O");
     System.exit(1);
   }
}
    
}
