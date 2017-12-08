package com.york.messageconverter.utils;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

public class XMLConverter {

    /**
     * Serialize object to XML string
     * @param object object
     * @param <T> type
     * @return
     */
    public static <T> String marshal(T object) {
        try {
            StringWriter stringWriter = new StringWriter();
            JAXBContext jc = JAXBContext.newInstance(object.getClass());
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            QName qName = new QName(object.getClass().getCanonicalName(), object.getClass().getSimpleName());
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
    

}
