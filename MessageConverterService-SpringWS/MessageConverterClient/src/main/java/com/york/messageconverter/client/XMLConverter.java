package com.york.messageconverter.client;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.io.StringReader;
import java.io.StringWriter;

public class XMLConverter {

    /**
     * Serialize object to XML string
     * @param object object
     * @param <T> type
     * @return
     */
    public static <T> String marshal(T object,QName qName ) {
        try {
            StringWriter stringWriter = new StringWriter();
            JAXBContext jc = JAXBContext.newInstance(object.getClass());
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            m.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);//Without <?xml version="1.0" encoding="UTF-8" standalone="yes"?> 
            //QName qName = new QName(object.getClass().getCanonicalName(), object.getClass().getSimpleName());
            JAXBElement<T> root = new JAXBElement(qName, object.getClass(), object);

            m.marshal(root, stringWriter);
            return stringWriter.toString();
        } catch (Exception e) {
            // log the exception
        }
        return null;
    }
    

    /**
     * Deserialize XML string back to object
     * @param content XML content
     * @param clasz class
     * @param <T> type
     * @return
     */
    public static <T> T unMarshal(final String content, final Class<T> clasz) {
        try {
            JAXBContext jc = JAXBContext.newInstance(clasz);
            Unmarshaller u = jc.createUnmarshaller();
            return u.unmarshal(new StreamSource(new StringReader(content)), clasz).getValue();
        } catch (Exception e) {
            // log the exception
        }
        return null;
    }
    
    /**
     * Marshals object graph into XML.
     *
     * @param obj the object graph
     * @param sourceClass the input class
     * @return XML as string
     * @see XmlConverter
     */
    public static String marshalToXml(Object obj, Class sourceClass) {
        Jaxb2Marshaller jaxb2 = new Jaxb2Marshaller();
        jaxb2.setContextPath(sourceClass.getPackage().getName());

        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);

        jaxb2.marshal(obj, result);

        return writer.toString();
    }
    
    /**
     * Unmarshals XML into object graph.
     *
     * @param xml the input string
     * @param targetClass the target class
     * @return object graph
     * @see XmlConverter
     */
    @SuppressWarnings("unchecked")
    public static <T> T unmarshalFromXml(String xml, Class<T> targetClass) {
        Jaxb2Marshaller jaxb2 = new Jaxb2Marshaller();
        jaxb2.setContextPath(targetClass.getPackage().getName());

        return (T) jaxb2.unmarshal(new StreamSource(new StringReader(xml)));
    }   
    
}
