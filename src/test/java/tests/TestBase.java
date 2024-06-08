package tests;

import java.io.File;
import java.io.IOException;

import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests{

	public static WebDriver driver;

	public static String downloadFolderPath = System.getProperty("user.dir")+"\\Downloads";

	
	public static ChromeOptions  setChromeDriverOption()
	{
	
		ChromeOptions chromeOptions = new ChromeOptions();

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content.settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFolderPath);
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
		
		return chromeOptions;
	}
	
	
	public static FirefoxOptions  setFireFoxDriverOption()
	{
		
		FirefoxOptions fireFoxOptions = new FirefoxOptions();

		fireFoxOptions.addPreference("browser.download.folderList", 2);
		fireFoxOptions.addPreference("browser.download.dir", downloadFolderPath);
		fireFoxOptions.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream");


		return fireFoxOptions;
	}

	@Parameters( {"browser_Type"} )
	@BeforeSuite
	public void startDriver(@Optional("chrome") String browser)
	{
		System.out.println("browser: "+browser);


		if( browser.equalsIgnoreCase("chrome") )
		{
			WebDriverManager.chromedriver().setup();
			
			driver =  new ChromeDriver(setChromeDriverOption());
		}
		else if( browser.equalsIgnoreCase("Firefox") )
		{
			WebDriverManager.firefoxdriver().setup();
			driver =  new FirefoxDriver(setFireFoxDriverOption());
		}
		else if( browser.equalsIgnoreCase("Headless") )
		{
			DesiredCapabilities caps = new DesiredCapabilities();
			System.out.println(System.getProperty("user.dir"));
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, 
					System.getProperty("user.dir")+"/Drivers/phantomjs.exe");
			String[] phantomJsArgs = {"--web-security=no"
					,"--ignore-ssl-errors=yes"};
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsArgs);
			driver = new PhantomJSDriver(caps);
		}
		else if( browser.equalsIgnoreCase("Headless_Chrome") )
		{
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--headless");
			opt.addArguments("--window-size=1920,1080");
			driver =  new ChromeDriver(opt);
		}


		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void takeScreenShot(ITestResult result) throws IOException 
	{
		if( result.getStatus() == ITestResult.FAILURE ) 
		{
			String path = "./Screenshots/"+result.getName()+"_Failure.png";
			Helper.captureScreenshot(driver, path);
		}


	}

	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	}
}
