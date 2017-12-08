1. This project is a sample for creating SOAP web services from XSD
     1) The purpose is for creating a MOCK SOAP in a fast way
         (Usually you do have sample response data files already)
     2) Need to create business module for no-mock ws

2. Steps:
     1) Put XSD into /src/main/resources/xsd/
     2) Add operations MessageConverterService.java
     3) Implemente MessageConverterServiceImpl.java
        Put response XML files are src/main/resources. 
        (Use SOAPUI to create templeate)  
     4) Implement all methods in SoapMashallUnMashall.java for unmarshalling sample response   
     4) Specify endpoints in application.properties
     5) Run SoapServerApplication.java as Spring Boots App

3. Confirm WSDL
     http://localhost:50000/InterbankMessageConverter/MessageConverterService?wsdl
     The sample request messages are src/test/resources/
