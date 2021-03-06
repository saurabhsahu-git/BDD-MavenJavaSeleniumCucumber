package Cucumber_Selenium.Cucumber_Selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesData {
	
	public static String readProperties(String key) throws IOException
	{
		Properties prop=null;
		String value=null;
		FileInputStream fis = new FileInputStream("./config/Config.properties");
		prop= new Properties();
		prop.load(fis);
		value=prop.getProperty(key);
		fis.close();
		return value;
	}
}
