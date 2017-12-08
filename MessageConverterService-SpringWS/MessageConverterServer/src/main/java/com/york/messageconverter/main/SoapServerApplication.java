package com.york.messageconverter.main;

import javax.xml.ws.Endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.york.messageconverter.webservices.MessageConverterServiceImpl;

@SpringBootApplication
public class SoapServerApplication implements CommandLineRunner {

	@Value("${service.endpoint}")
	private String serviceEndpoint;
	
	@Override
	public void run(String... args) throws Exception {
		
		//http://localhost:50000/InterbankMessageConverter/MessageConverterServiceImpl		
		Endpoint.publish(serviceEndpoint, new MessageConverterServiceImpl());
	}

	public static void main(String[] args) {
		SpringApplication.run(SoapServerApplication.class, args);
	}
}
