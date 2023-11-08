package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This Class contains reusable methods to read data from properties file
 * @author Deepika Bharade
 *
 */
public class PropertiesUtility 
{
	private Properties property;
	/**
	 * This Method is used to Initialize properties file
	 * @param filepath
	 */
	public void propertiesInitialization(String filepath)
	{
		FileInputStream fis=null;
		try 
		{
			 fis= new FileInputStream(filepath);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		 property= new Properties();
		
		try
		{
			property.load(fis);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * This Method is used to Fetch data from Properties file
	 * @param key
	 * @return
	 */
	public String readFromProperties(String key) 
	{
		return property.getProperty(key);
	}
		
}

