package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	
	/**
	 * this method is used to load the properties from config.properties file.
	 * @return it returns properties prop object.
	 */
	
	public Properties initProp() {
		prop=new Properties(); // create object of properties class
		//we have to interact with config.properties which is file, so we use file input stream class.
		try {
			FileInputStream ip=new FileInputStream("./src/test/resources/config/config.properties");//give path of config.properties.
			prop.load(ip); //load the properties for using them.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
