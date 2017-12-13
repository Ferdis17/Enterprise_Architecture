package sender;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;


public class JMSSender {
    private JmsTemplate jmsTemplate;

    public void send(final Calculator calculator) {
        jmsTemplate.send(new MessageCreator() {
              public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(calculator);
              }
        });
        System.out.println("Sending message with person object : " + calculator.getFirstNumber()+" "+calculator.getSecondNumber());
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

}
