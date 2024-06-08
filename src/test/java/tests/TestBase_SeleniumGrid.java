package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class TestBase_SeleniumGrid {

    private static String url = "https://demo.nopcommerce.com/";

    protected ThreadLocal<RemoteWebDriver> driver = null;


    public static String downloadFolderPath = System.getProperty("user.dir")+"\\Downloads";

    @Parameters( {"browser_Type"} )
    @BeforeSuite
    public void startDriver(@Optional("firefox") String browser) throws MalformedURLException {
        driver = new ThreadLocal<>();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName",browser);
        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/ui/"),caps));
        getDriver().get(url);
    }

    public WebDriver getDriver()
    {
        return driver.get();
    }




    @AfterMethod
    public void takeScreenShot(ITestResult result) throws IOException
    {
        if( result.getStatus() == ITestResult.FAILURE )
        {
            String path = "./Screenshots/"+result.getName()+"_Failure.png";
            Helper.captureScreenshot(getDriver(), path);
        }


    }

    @AfterSuite
    public void stopDriver()
    {
        getDriver().quit();
        driver.remove();
    }
}

