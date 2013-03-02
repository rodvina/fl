package com.ksg.formslibrary.jms;

import javax.jms.Destination;
import javax.jms.JMSException;

public interface SynchronousJMS {

	String send(String message, Destination destination) throws JMSException;
}
