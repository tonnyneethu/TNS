package com.searchutility;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ConfigDataprovider {
	
	Properties pro;
	
	public ConfigDataprovider()
	{
		File src = new File("./Config/url.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			pro =new Properties();
			pro.load(fis);
		}  catch (Exception e) {
			
			System.out.println("Unable to Upload Congfig File" +e.getMessage());
		}
		
	}
	
	public String getBrowser()
	{
		return pro.getProperty("Browser");
		
	}
	
	public String getDataURL()
	{
		return pro.getProperty("QaURL");
		
	}

}
