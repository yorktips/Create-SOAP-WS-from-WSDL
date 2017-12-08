package com.york.messageconverter.server;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.StringWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.io.IOUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPMessage;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.w3c.dom.Document;

import com.york.messageconverter.utils.SOAPUtils;
import com.york.messageconverter.webservices.BundleValidateResponse;
import com.york.messageconverter.webservices.GenerateResponse;
import com.york.messageconverter.webservices.MessageGenerateResponse;
import com.york.messageconverter.webservices.MessageParseRequest;
import com.york.messageconverter.webservices.MessageParseResponse;
import com.york.messageconverter.webservices.ParseResponse;
import com.york.messageconverter.webservices.ValidateResponse;

public class SoapMashallUnMashall {

	public static void main(String[] args) {
		SOAPUtils util= new SOAPUtils();
		
		String file = "parseResponse.xml";// "masterRecord.txt";
		String msg = util.file2String(file);
		MessageParseResponse response = SoapMashallUnMashall.unMashallMessageParseResponse(msg);

		System.out.print(response.toString());
	}

	
	/**
	 * Un-Mashall SOAP XML response file to SOAP MessageParseResponse object
	 * 
	 * @param msg
	 *            SOAP response message - including envelop
	 * @return MessageParseResponse.
	 * @exception RemoteException
	 *                On SOAP.
	 * @see RemoteException
	 */
	public static MessageParseResponse unMashallMessageParseResponse(final String msg) {
		System.out.println(msg);
		try {
			SOAPMessage message = MessageFactory.newInstance().createMessage(null,
					new ByteArrayInputStream(msg.getBytes()));
			Unmarshaller unmarshaller = JAXBContext.newInstance(ParseResponse.class).createUnmarshaller();
			SOAPBody body = message.getSOAPBody();
			if (body != null) {
				Document doc = body.extractContentAsDocument();
				if (doc != null) {
					JAXBElement<ParseResponse> je = unmarshaller.unmarshal(doc, ParseResponse.class);
					ParseResponse parseResponse = je.getValue();
					MessageParseResponse response = parseResponse.getReturn();

					// String ret=XMLConverter.marshal(response);
					// System.out.println(ret);
					return response;
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Un-Mashall SOAP XML response file to SOAP BundleValidateResponse object
	 * 
	 * @param msg
	 *            SOAP response message - including envelop
	 * @return BundleValidateResponse.
	 * @exception RemoteException
	 *                On SOAP.
	 * @see RemoteException
	 */
	public static BundleValidateResponse unMashallBundleValidateResponse(String msg) {
		System.out.println(msg);
		try {
			SOAPMessage message = MessageFactory.newInstance().createMessage(null,
					new ByteArrayInputStream(msg.getBytes()));
			Unmarshaller unmarshaller = JAXBContext.newInstance(ValidateResponse.class).createUnmarshaller();
			SOAPBody body = message.getSOAPBody();
			if (body != null) {
				Document doc = body.extractContentAsDocument();
				if (doc != null) {
					JAXBElement<ValidateResponse> je = unmarshaller.unmarshal(doc, ValidateResponse.class);
					ValidateResponse validateResponse = je.getValue();
					BundleValidateResponse response = validateResponse.getReturn();
					return response;
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Un-Mashall SOAP XML response file to SOAP MessageGenerateResponse object
	 * 
	 * @param msg
	 *            SOAP response message - including envelop
	 * @return MessageGenerateResponse.
	 * @exception RemoteException
	 *                On SOAP.
	 * @see RemoteException
	 */
	public static MessageGenerateResponse unMashallMessageGenerateResponse(final String msg) {
		System.out.println(msg);
		try {
			SOAPMessage message = MessageFactory.newInstance().createMessage(null,
					new ByteArrayInputStream(msg.getBytes()));
			Unmarshaller unmarshaller = JAXBContext.newInstance(GenerateResponse.class).createUnmarshaller();
			SOAPBody body = message.getSOAPBody();
			if (body != null) {
				Document doc = body.extractContentAsDocument();
				if (doc != null) {
					JAXBElement<GenerateResponse> je = unmarshaller.unmarshal(doc, GenerateResponse.class);
					GenerateResponse generateResponse = je.getValue();
					MessageGenerateResponse response = generateResponse.getReturn();
					return response;
				}
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



}
