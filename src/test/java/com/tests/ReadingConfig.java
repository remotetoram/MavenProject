package com.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadingConfig {

	public static void main(String[] args) throws IOException {
		
		Properties Config=new Properties();
		
		System.out.println(System.getProperty("user.dir"));
		
		FileInputStream ConfigFile=new  FileInputStream("G:\\Meven Project\\MevenProject\\Resources\\Config.properties");
		
		Config.load(ConfigFile);
		
	    
	    System.out.println(Config.getProperty("browser"));
	    System.out.println(Config.getProperty("testsiteurl"));
	
	
	}

}
