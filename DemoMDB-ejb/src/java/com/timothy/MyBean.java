package com.timothy;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/myMsgDest"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class MyBean implements MessageListener {
    
    public MyBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        TextMessage txtMsg = (TextMessage)message;
        try {
            System.out.println(txtMsg.getText());
        } catch (JMSException ex) {
            Logger.getLogger(MyBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
