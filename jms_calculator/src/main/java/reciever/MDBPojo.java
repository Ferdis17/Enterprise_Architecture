package reciever;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import sender.Calculator;

public class MDBPojo implements MessageListener {

    public void onMessage(Message message){
    	ObjectMessage objmessage = (ObjectMessage)message;
    	try {
			Calculator calculator = (Calculator)objmessage.getObject();
			System.out.println("MDBPojo receives message with  : " + calculator.getFirstNumber()+" and " +calculator.getSecondNumber());
			System.out.println("plus " + calculator.getPlus());
			System.out.println("Multiplicity: " + calculator.getMuliply());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

