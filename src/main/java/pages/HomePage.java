package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) 
	{
		super(driver);	
		js = (JavascriptExecutor) driver;
	
		action = new Actions(driver);
	}
	
	@FindBy(id="small-searchterms")
	WebElement searchStoreTxtBox;
	
	@FindBy(css="button.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement registerLink;
	
	@FindBy(xpath = "//a[text()='Log in']")
	WebElement loginLink;
	
	@FindBy(xpath = "//a[text()='Log out']")
	public WebElement logoutLink;
	
	@FindBy(xpath = "//a[text()='My account']")
	WebElement myAccountLink;
	
	
	@FindBy(xpath = "//a[text()='Contact us']")
	WebElement contactUsLink;
	
	@FindBy(id = "customerCurrency")
	WebElement customerCurrencySelector;
	
	@FindBy(xpath = "//a[text()='Computers ']")
	WebElement computersLink;
	
	@FindBy(xpath = "//a[text()='Notebooks ']")
	WebElement notebooksLink;
	
	@FindBy(id = "ui-id-1")
	List<WebElement> productSearchList;
	
	
	public void openContactUsPage()
	{
		scrollPageToBottom();
		clickButton( contactUsLink );
		
	}
	
	
	public void openRegisterationPage()
	{
		clickButton( registerLink );
		
	}
	
	public void openMyAccountPage()
	{
		clickButton(myAccountLink);
	}
	
	public void openLoginPage()
	{
		clickButton( loginLink );
	}
	
	public void userLogOut()
	{
		clickButton( logoutLink );
	}
	
	public void selectCurrency(String currency)
	{
		select = new Select(customerCurrencySelector);
		select.selectByVisibleText(currency);
	}
	
	public void openNotebooksPage()
	{
		action.moveToElement(computersLink).moveToElement(notebooksLink).click().build().perform();
	}
	
	public void productSearch(String productName)
	{
		setTextElementText(searchStoreTxtBox, productName);
		clickButton(searchBtn);
	}

	public void productSearchUsingAutoSuggest(String productName)
	{
		setTextElementText(searchStoreTxtBox, productName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickButton(productSearchList.get(0));
	}
}
