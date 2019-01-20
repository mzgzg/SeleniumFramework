package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

	public static Properties userData = loadProperties(System.getProperty("user.dir")+
			"\\src\\main\\java\\properties\\userdata.properties");

	public static Properties loadProperties(String path) {
		Properties propertiy = new Properties();
		try 
		{
			FileInputStream inStream = new FileInputStream(path);
			propertiy.load(inStream);
		} catch (FileNotFoundException e) {
			System.out.println("Error occure : "+e.getMessage());
		} catch (IOException e) {
			System.out.println("Error occure : "+e.getMessage());
		}
		return propertiy;
	}
}
