package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Commomactions {
	
	public Properties ReadConfiguration() throws IOException{
		FileInputStream file= new FileInputStream(new File("Config.properties"));
		Properties pro1=new Properties();
		pro1.load(file);
		return pro1;
		}

//	*public void readProperty(){
//		FileInputStream file = new FileInputStream(new File("Config.properties"));
//		Properties pro = new Propertiesfile();
//	}
}
