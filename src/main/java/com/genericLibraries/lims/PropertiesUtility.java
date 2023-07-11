package com.genericLibraries.lims;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
/**
 * This class is use for getting the key and values from the properties file
 * @author Datta
 *
 */
public class PropertiesUtility {
	
/**
 * This mehthod is used to get the values from the properties file
 * @param path
 * @param key
 * @return String value 
 * @throws Throwable
 */
	public String getDataFromProperties(String path, String key) throws Throwable {
		FileInputStream fis = new FileInputStream("" + path + "");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;

	}
	
}
