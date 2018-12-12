package com.rest.clarify.cases.stepdefination;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class MainTestCase {

	public static String getValue(String key){
		String value = null;
		Properties prop = new Properties();
		String propertyFilename = "test.properties";
		// Reading property file
		InputStream input = new Object() {
		}.getClass().getClassLoader().getResourceAsStream(propertyFilename);

		if (input != null) {
			try {
				prop.load(input);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Enumeration<?> e = prop.propertyNames();
			if (!e.equals(null)) {
				while (e.hasMoreElements()) {
					String keyName = (String) e.nextElement();
					if (key.equals(keyName)) {
						value = prop.getProperty(keyName);
						break;
					}
				}
			}
		} else {
			System.out.println("property file ' " + propertyFilename + " ' is not found in classpath");
		}
		return value;
	}

}
