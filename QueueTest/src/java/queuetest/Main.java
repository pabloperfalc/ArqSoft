/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuetest;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

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
        sendJMSMessageToCommandsQueue("test");
    }

    private static Message createJMSMessageForjmsCommandsQueue(Session session, Object messageData) throws JMSException {
        // TODO create and populate message to send
        TextMessage tm = session.createTextMessage();
        tm.setText(messageData.toString());
        return tm;
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
