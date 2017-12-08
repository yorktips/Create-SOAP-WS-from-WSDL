/**
 * 
 */
package com.york.messageconverter.webservices.client.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.SerializationUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.york.messageconverter.webservices.BundleValidateResponse;
import com.york.messageconverter.webservices.ConvertibleInterbankMessage;
import com.york.messageconverter.webservices.MessageGenerateResponse;
import com.york.messageconverter.webservices.MessageParseRequest;
import com.york.messageconverter.webservices.MessageParseResponse;
import com.york.messageconverter.webservices.client.MessageConverterClient;
import com.york.messageconverter.webservices.client.MessageConverterClientImpl;

/**
 * @author YChen
 *
 */
public class MessageConverterClientImplTest {

	private MessageConverterClient messageConverterClient;

	private MessageParseRequest arg0;

	private static ConvertibleInterbankMessage convertibleInterbankMessage;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		messageConverterClient = new MessageConverterClientImpl();
		arg0 = new MessageParseRequest();

		ClassLoader classLoader = getClass().getClassLoader();
		try {
			String source = IOUtils.toString(classLoader.getResourceAsStream("masterRecord.txt"));
			arg0.setSource(source);
		} catch (IOException e) {
			e.printStackTrace();
			arg0.setSource("source1234");
		}

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.gtc.messageconverter.webservices.client.MessageConverterClientImpl#parse(com.gtc.messageconverter.webservices.MessageParseRequest)}.
	 */
	@Test
	public void testParse() {

		MessageParseResponse messageParseResponse = null;
		try {
			messageParseResponse = messageConverterClient.parse(arg0);
			Assert.assertNotNull(messageParseResponse);
			ConvertibleInterbankMessage[] convertibleInterbankMessages;
			convertibleInterbankMessages = messageParseResponse.getParsedMessages();
			convertibleInterbankMessage = (ConvertibleInterbankMessage) SerializationUtils
					.clone(convertibleInterbankMessages[0]);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Test method for
	 * {@link com.gtc.messageconverter.webservices.client.MessageConverterClientImpl#validate(com.gtc.messageconverter.webservices.ConvertibleInterbankMessage[])}.
	 */
	@Test
	public void testValidate() {
		try {
			ConvertibleInterbankMessage[] convertibleInterbankMessages = new ConvertibleInterbankMessage[1];
			convertibleInterbankMessages[0] = convertibleInterbankMessage;
			if (convertibleInterbankMessages[0] != null) {
				MessageGenerateResponse messageGenerateResponse = messageConverterClient
						.generate(convertibleInterbankMessages);

				Assert.assertNotNull(messageGenerateResponse);
			} else {
				System.out.println("ignore validate unit test");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Test method for
	 * {@link com.gtc.messageconverter.webservices.client.MessageConverterClientImpl#generate(com.gtc.messageconverter.webservices.ConvertibleInterbankMessage[])}.
	 */
	@Test
	public void testGenerate() {
		try {
			ConvertibleInterbankMessage[] convertibleInterbankMessages = new ConvertibleInterbankMessage[1];
			convertibleInterbankMessages[0] = convertibleInterbankMessage;

			if (convertibleInterbankMessages[0] != null) {

				BundleValidateResponse bundleValidateResponse = messageConverterClient
						.validate(convertibleInterbankMessages);

				Assert.assertNotNull(bundleValidateResponse);
			} else {
				System.out.println("ignore generate unit test");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
