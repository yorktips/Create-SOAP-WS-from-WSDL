package com.york.messageconverter.utils;

import java.nio.file.Files;
import java.nio.file.Paths;

public class SOAPUtils {
	/**
	 * Convert a xml file into a content string
	 * 
	 * @param file
	 *            SOAP XML file name, relative path is from class/resources path
	 * @return String.
	 * @exception FileIOException
	 * @see
	 */
	public String file2String(final String file) {
		try {
			String content = new String(
					Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource(file).toURI())));
			return content;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
}
