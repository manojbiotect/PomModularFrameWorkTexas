package commonLips.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
	public static Properties readPropeties(String filename) throws Exception {
		
		filename = filename.trim(); //trim wide space from filename
		//read file from InputStream read file..outputstream is write file
		InputStream filereader = new FileInputStream(filename);
		
		Properties property = new Properties();
		
		property.load(filereader);
		
		return property;
	}
	
	

}

