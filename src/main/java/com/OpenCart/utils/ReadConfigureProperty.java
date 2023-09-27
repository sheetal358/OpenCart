package com.OpenCart.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigureProperty {
	/*
	 * Setting the file path of properties file
	 * returning value from property file
	 */
	public static String fileProperties(String propertiesData)  //browser url
	{
		String returnData = null;
		String searchData = propertiesData;
		try {
			String filelocation = System.getProperty("user.dir") + "\\src\\main\\resources\\Properties\\Configure.properties";
			File file = new File(filelocation);
			FileInputStream fileinput = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fileinput);
			returnData = prop.getProperty(searchData);
			System.out.println(returnData);
			}catch(Exception e)
			{
			System.out.println("not present");
			}
		return returnData;		
	}
}
