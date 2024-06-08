package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage  extends PageBase
{

	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}
	

	@FindBy(id="FriendEmail")
	WebElement friendEmailTxtBox;
	
	@FindBy(id="PersonalMessage")
	WebElement personalMessageTxtBox;
	
	@FindBy(css="button.button-1.send-email-a-friend-button")
	WebElement sendEmailBtn;
	
	@FindBy(xpath = "//div[@class='page-body']/div[@class='result']")
	public WebElement emailFriendResult;
	
	
	public void emailFriend(String friendEmail, String personalMessage)
	{
		setTextElementText(friendEmailTxtBox, friendEmail);
		setTextElementText(personalMessageTxtBox, personalMessage);
		clickButton(sendEmailBtn);
	}
}
