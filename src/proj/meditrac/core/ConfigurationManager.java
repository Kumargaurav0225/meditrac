package proj.meditrac.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import proj.meditrac.core.enums.Configuration;

/*
 * Singleton class
 */
public class ConfigurationManager {

	private ConfigurationManager(){};
	
	private static ConfigurationManager instance = new ConfigurationManager();;
	
	private static FileInputStream fs;
	
	private static Properties props;
	
	private static final String PROP_PREFIX = "meditrac.";
	
	static {
		try {
			fs = new FileInputStream("meditrac.properties");
			props = new Properties();
			props.load(fs);
		} catch(FileNotFoundException ex){
			System.out.println("Meditrac properties file not found. Using defaults.");
		} catch(IOException ex){
			System.out.println("EXC -> " + ex.getMessage());
		} finally {
			if(fs != null){
				try {
					fs.close();
				} catch(IOException ex){
					System.out.println("EXC -> " + ex.getMessage());
				}
			}
		}
	}
	
	public static ConfigurationManager getInstance(){
		return instance;
	}
	
	public String getProperty(Configuration c){
		if(props != null)
			return props.getProperty(PROP_PREFIX + c.getPropName(),c.getDefault());
		else
			return c.getDefault();
	}
	
}
