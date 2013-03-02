package com.ksg.formslibrary.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.SessionCallback;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Component;

@Component
public class SynchronousJMSImpl implements SynchronousJMS {

	@Autowired
    private JmsTemplate jmsTemplate;
	
	public SynchronousJMSImpl() {
	}

	public String send(String request, Destination destination) throws JMSException {
		return send(request, destination, 5000);
	}

	private String send(String request, Destination destination, int timeout) throws JMSException {
    	Message msg = jmsTemplate.execute(new ProducerConsumer(request, destination, timeout), true );
    	return ((TextMessage)msg).getText();
	}

	//inner class
	private static final class ProducerConsumer implements SessionCallback<Message> {
        private final String request;
        private final Destination destination;
        private final int timeout;
        
        public ProducerConsumer(final String request, final Destination destination, final int timeout) {
            this.timeout = timeout;
        	this.request = request;
            this.destination = destination;
        }

        public Message doInJms(final Session session) throws JMSException {
            MessageConsumer consumer = null;
            MessageProducer producer = null;
            try {
                final Destination replyTopic = session.createTemporaryTopic();
                // Create the consumer first!
                consumer = session.createConsumer(replyTopic);
                
                final TextMessage textMessage = session.createTextMessage(request);
                textMessage.setJMSReplyTo(replyTopic);
                // Send the request second!
                producer = session.createProducer(destination);
                producer.send(textMessage);
                // Block on receiving the response with a timeout
                Message msg = consumer.receive(timeout);
                if (msg == null) {
                	throw new JMSException("Timed out after waiting " + timeout + " ms.");
                } else {
                	return msg;
                }
            }
            finally {
                // Don't forget to close your resources
                JmsUtils.closeMessageConsumer(consumer);
                JmsUtils.closeMessageProducer(producer);
            }
        }
    }
}
