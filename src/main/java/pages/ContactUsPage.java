package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase
{

	public ContactUsPage(WebDriver driver) 
	{
		super(driver);
	}
	
	String name = "Islam";
	String email = "Islam.saber@gmail.com";
	String enquiry = "Dear Admin, This is for test. Thanks";
	
	
	@FindBy(id="FullName")
	WebElement yourNameTxtBox;
	
	@FindBy(id="Email")
	WebElement yourEmailTxtBox;
	
	@FindBy(id="Enquiry")
	WebElement EnquiryTxtBox;
	
	@FindBy(css = "button.button-1.contact-us-button")
	WebElement submitBtn;
	
	@FindBy(xpath = "//div[@class='page-body']/div[@class='result']" )
	public WebElement contactUsResult;
	
	public void contactUs()
	{
		setTextElementText(yourNameTxtBox, name);
		setTextElementText(yourEmailTxtBox, email);
		setTextElementText(EnquiryTxtBox, enquiry);
		clickButton(submitBtn);
	}

}
