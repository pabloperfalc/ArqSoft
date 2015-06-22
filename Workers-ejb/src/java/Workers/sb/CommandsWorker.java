/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Workers.sb;

import DTOs.QueueCommand;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author pabloperfalc
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/commandsQueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class CommandsWorker implements MessageListener {
    
    public CommandsWorker() {
    }
    
    @Override
    public void onMessage(Message message) {
        
        try {
            ObjectMessage objMsg = (ObjectMessage) message;
            
            if (objMsg.isBodyAssignableTo(QueueCommand.class)) {

                    int command = ((QueueCommand)objMsg.getObject()).getRoomId();
                    System.out.println(command);
                    
            }
            else {
                throw new IllegalArgumentException("Message must be of type TextMessage");
            }
        } catch (JMSException ex) {
            Logger.getLogger(CommandsWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
