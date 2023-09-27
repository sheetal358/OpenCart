package com.OpenCart.screenshot;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.OpenCart.base.Browser;

public class Screenshot extends Browser{
	public static String screenShot(int i) throws Exception {
		String filePath = null;
		try {
		//Converting WebDriver object to takeScreenshoot
		TakesScreenshot scrShot =((TakesScreenshot)driver); 
		/*Calling the getScreenshotAs() method to 
		 *create an image file
		 */
		File Src=scrShot.getScreenshotAs(OutputType.FILE);	
		//Giving the location
		filePath = System.getProperty("user.dir")+"//screenshot//Screenshot"+i+".png";					        
		i++;
		//Moving image file to new destination
		File Dest=new File(filePath);	 
		//copying file at destination
		FileUtils.copyFile(Src, Dest);
		}catch(Exception e)
		{
			System.out.println("Screen Capture Error : "+e);
		}
		return filePath;
	}
}