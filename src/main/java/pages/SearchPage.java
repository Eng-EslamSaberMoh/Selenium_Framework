package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase{

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	
	
	
	
	@FindBy(xpath = "//div[@class='details']/h2/a")
	public WebElement productTitleLink;

	

	
	public void openProductDetailsPage()
	{
		clickButton(productTitleLink);
	}
	
	

}
