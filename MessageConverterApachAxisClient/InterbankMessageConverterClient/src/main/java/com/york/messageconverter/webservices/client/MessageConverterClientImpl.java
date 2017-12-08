package com.york.messageconverter.webservices.client;

import java.io.IOException;
import javax.annotation.PreDestroy;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import com.york.messageconverter.webservices.BundleValidateResponse;
import com.york.messageconverter.webservices.ConvertibleInterbankMessage;
import com.york.messageconverter.webservices.MessageConverterDelegate;
import com.york.messageconverter.webservices.MessageConverterDelegateProxy;
import com.york.messageconverter.webservices.MessageGenerateResponse;
import com.york.messageconverter.webservices.MessageParseRequest;
import com.york.messageconverter.webservices.MessageParseResponse;
 
/**
 * Bean file that implements the MessageConverterClient business interface.
 * Class uses following EJB 3.0 annotations: - @Stateless - specifies that the
 * EJB is of type stateless session - @TransactionAttribute - specifies that the
 * EJB never runs in a transaction - @ExcludeDefaultInterceptors - specifies any
 * configured default interceptors should not be invoked for this class
 */
// @Stateless
// @TransactionAttribute(NEVER)
// @ExcludeDefaultInterceptors
public class MessageConverterClientImpl implements MessageConverterClient {

	final static Logger logger = Logger.getLogger(MessageConverterClientImpl.class);

	private MessageConverterDelegate messageConverterDelegate;

	public MessageConverterClientImpl() {
		this.messageConverterDelegate = new MessageConverterDelegateProxy();
	}

	public MessageConverterClientImpl(MessageConverterDelegate messageConverterDelegate) {
		this.messageConverterDelegate = messageConverterDelegate;
	}

	/**
	 * parse operation
	 * 
	 * @param arg0
	 *            MessageParseRequest.
	 * @return MessageParseResponse.
	 * @exception RemoteException
	 *                On SOAP.
	 * @see RemoteException
	 */
	public MessageParseResponse parse(MessageParseRequest arg0) throws java.rmi.RemoteException {
		logger.debug("invoke:parse");

		if (arg0 == null) {
			logger.info("parse:arg0==null");
			return null;
		}

		logger.debug(arg0);
		logger.debug("source=" + arg0.getSource());

		MessageParseResponse response = messageConverterDelegate.parse(arg0);
		logger.debug("response=" + response);

		if (logger.isDebugEnabled()) {
			if (response != null) {
				ConvertibleInterbankMessage[] monvertibleInterbankMessage = response.getParsedMessages();
				for (ConvertibleInterbankMessage msg : monvertibleInterbankMessage) {
					logger.info(msg.getMasterRecord().toString());
				}
			}
		}

		logger.debug("invoke:parse:success");

		return response;
	}

	/**
	 * validate operation
	 * 
	 * @param arg0
	 *            ConvertibleInterbankMessage[].
	 * @return BundleValidateResponse.
	 * @exception RemoteException
	 *                On SOAP.
	 * @see RemoteException
	 */
	public BundleValidateResponse validate(ConvertibleInterbankMessage[] arg0) throws java.rmi.RemoteException {

		logger.debug("invoke:validate");

		if (arg0 == null) {
			logger.info("validate:arg0==null");
			return null;
		}

		logger.debug(arg0);

		if (logger.isDebugEnabled()) {
			int idx = 0;
			for (ConvertibleInterbankMessage msg : arg0) {
				logger.debug("arg0[" + idx + "]=" + arg0[idx].toString());
			}
		}

		BundleValidateResponse response = messageConverterDelegate.validate(arg0);
		logger.debug("response=" + response.toString());

		logger.debug("invoke:validate:success");

		return response;
	}

	/**
	 * generate operation
	 * 
	 * @param arg0
	 *            ConvertibleInterbankMessage[].
	 * @return MessageGenerateResponse.
	 * @exception RemoteException
	 *                On SOAP.
	 * @see RemoteException
	 */
	public MessageGenerateResponse generate(ConvertibleInterbankMessage[] arg0) throws java.rmi.RemoteException {

		logger.debug("invoke:generate");

		if (arg0 == null) {
			logger.info("generate:arg0==null");
			return null;
		}

		logger.debug(arg0);

		if (logger.isDebugEnabled()) {
			int idx = 0;
			for (ConvertibleInterbankMessage msg : arg0) {
				logger.debug("arg0[" + idx + "]=" + arg0[idx].toString());
			}
		}

		MessageGenerateResponse response = messageConverterDelegate.generate(arg0);
		logger.debug("response=" + response.toString());

		logger.debug("invoke:generate:success");

		return response;

	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("Invoking method: preDestroy()");
	}

	/**
	 * This is the main method which makes use of parse/validate/generate method.
	 * This is only for test/debug purpose.
	 * 
	 * @param args
	 *            Unused.
	 * @return Nothing.
	 * @exception Nothing.
	 * @see
	 */
//	public static void main(String[] args) {
//
//		MessageConverterClient messageConverterClient = new MessageConverterClientImpl();
//
//		MessageParseRequest arg0 = new MessageParseRequest();
//
//		try {
//			ClassLoader classLoader = messageConverterClient.getClass().getClassLoader();
//			try {
//				String source = IOUtils.toString(classLoader.getResourceAsStream("masterRecord.txt"));
//				arg0.setSource(source);
//			} catch (IOException e) {
//				e.printStackTrace();
//				arg0.setSource("source1234");
//			}
//
//			// test parse operator
//			MessageParseResponse messageParseResponse = messageConverterClient.parse(arg0);
//
//			if (messageParseResponse != null) {
//				ConvertibleInterbankMessage[] convertibleInterbankMessages = messageParseResponse.getParsedMessages();
//
//				if (convertibleInterbankMessages != null) {
//					// test validate operator
//					BundleValidateResponse bundleValidateResponse = messageConverterClient
//							.validate(convertibleInterbankMessages);
//
//					if (bundleValidateResponse != null) {
//						System.out.println(bundleValidateResponse.toString());
//					} else {
//						System.out.println("validate return null bundleValidateResponse");
//					}
//
//					// test generate operator
//					MessageGenerateResponse messageGenerateResponse = messageConverterClient
//							.generate(convertibleInterbankMessages);
//
//					if (messageGenerateResponse != null) {
//						System.out.println(messageGenerateResponse.toString());
//					} else {
//						System.out.println("generate return null messageGenerateResponse");
//					}
//
//				}
//
//			} else {
//				logger.debug("invoke:parse: messageParseResponse is null");
//			}
//
//			System.out.println("END");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}
