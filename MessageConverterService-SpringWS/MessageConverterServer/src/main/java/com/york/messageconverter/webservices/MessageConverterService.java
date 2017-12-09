package com.york.messageconverter.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;  
import com.york.messageconverter.webservices.*;

@WebService
@SOAPBinding(style = Style.DOCUMENT)  
public interface MessageConverterService {
	@WebMethod(operationName = "parse")
    public MessageParseResponse parse(MessageParseRequest arg0) throws java.rmi.RemoteException;

	@WebMethod(operationName = "validate")
	public BundleValidateResponse validate(ConvertibleInterbankMessage[] arg0) throws java.rmi.RemoteException;

	@WebMethod(operationName = "generate")
	public MessageGenerateResponse generate(ConvertibleInterbankMessage[] arg0) throws java.rmi.RemoteException;
}

