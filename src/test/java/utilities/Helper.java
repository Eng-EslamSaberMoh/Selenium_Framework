package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	
	public static void captureScreenshot(WebDriver driver, String destPath) throws IOException
	{
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		File destFile = new File(destPath);
		FileUtils.copyFile(srcFile, destFile);
	}

}
