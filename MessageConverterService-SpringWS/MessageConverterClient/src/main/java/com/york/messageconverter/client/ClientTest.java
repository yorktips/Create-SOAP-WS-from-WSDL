package com.york.messageconverter.client;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.york.messageconverter.webservices.MessageParseRequest;
import com.york.messageconverter.webservices.MessageParseResponse;
import com.york.messageconverter.webservices.ObjectFactory;
import com.york.messageconverter.webservices.Parse;

import java.io.StringReader;
import javax.xml.bind.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.SOAPException;
import javax.xml.transform.stream.StreamResult;

public class ClientTest {

	private static final String endpoint = "http://localhost:50000/InterbankMessageConverter/MessageConverterService";
	private final WebServiceTemplate webServiceTemplate2 = new WebServiceTemplate();

	ObjectFactory objectFactory = new ObjectFactory();

	public static void main(String[] args) {
		ClientTest t = new ClientTest();
		t.parser();
	}

	Jaxb2Marshaller jaxb2Marshaller() {
		try {
			Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
			jaxb2Marshaller.setContextPath("com.york.messageconverter.webservices");
			return jaxb2Marshaller;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebServiceTemplate webServiceTemplate() {
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
		webServiceTemplate.setMarshaller(jaxb2Marshaller());
		webServiceTemplate.setUnmarshaller(jaxb2Marshaller());
		webServiceTemplate.setDefaultUri(endpoint);

		return webServiceTemplate;
	}

	private static Document convertStringToDocument(String xmlStr) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(xmlStr)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	void parser() {
		WebServiceTemplate webServiceTemplate = webServiceTemplate();
		Parse parse = objectFactory.createParse();
		MessageParseRequest messageParseRequest = objectFactory.createMessageParseRequest();
		messageParseRequest.setSource("value123");
		parse.setArg0(messageParseRequest);

		// way 1
		String msg = "<ns2:parse xmlns:ns2=\"http://webservices.messageconverter.york.com/\">\r\n"
				+ "<!--Optional:-->\r\n" + "<arg0>\r\n" + "<!--Optional:-->\r\n" + "<source>123</source>\r\n"
				+ "</arg0>\r\n" + "</ns2:parse>\r\n";

		StringSource source = new StringSource(msg);
		StringResult result = new StringResult();

		webServiceTemplate.sendSourceAndReceiveToResult(endpoint, source, result);
		System.out.println(new String(result.getWriter().toString()));

		// Way 2
		ObjectFactory factory = new ObjectFactory();
		JAXBElement<Parse> pe = factory.createParse(parse);

		try {

			String ret2 = new String("");
			StreamResult result2 = new StreamResult(ret2);
			Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
			marshaller.setContextPath("com.york.messageconverter.webservices");
			marshaller.marshal(pe, result);
			System.out.println("parse:request=" + result.toString());
			
			Object obj = webServiceTemplate.marshalSendAndReceive(endpoint, pe);
			
			JAXBElement<MessageParseResponse> response = (JAXBElement<MessageParseResponse>) obj;
			marshaller.marshal(response, result);
			System.out.println("parse:response=" + result.toString());

			System.out.println("");
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("end");

	}

}
