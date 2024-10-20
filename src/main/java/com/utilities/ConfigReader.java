package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	public Properties getProperty() throws IOException {

		prop = new Properties();
		FileInputStream file = new FileInputStream("./src/test/resources/config/config.properties");
		prop.load(file);
		return prop;
	}
}
