package com.york.messageconverter.webservices.client;

import com.york.messageconverter.webservices.BundleValidateResponse;
import com.york.messageconverter.webservices.ConvertibleInterbankMessage;
import com.york.messageconverter.webservices.MessageGenerateResponse;
import com.york.messageconverter.webservices.MessageParseRequest;
import com.york.messageconverter.webservices.MessageParseResponse;
 
/**
 * Business  interface for the MessageConverterClient stateless session EJB.
 */

public interface MessageConverterClient {
	
	MessageParseResponse parse(MessageParseRequest arg0) throws java.rmi.RemoteException;
	BundleValidateResponse validate(ConvertibleInterbankMessage[] arg0) throws java.rmi.RemoteException;
	MessageGenerateResponse generate(ConvertibleInterbankMessage[] arg0) throws java.rmi.RemoteException;
	
}
