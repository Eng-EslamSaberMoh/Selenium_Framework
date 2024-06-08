package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(xpath = "//a[text()='Change password']")
	WebElement changePasswordLink;
	
	@FindBy(id="OldPassword")
	WebElement oldPasswordTxtBox;
	
	@FindBy(id="NewPassword")
	WebElement newPasswodTxtBox;

	@FindBy(id="ConfirmNewPassword")
	WebElement confirmNewPasswordTxtBox;

	@FindBy(css="button.button-1.change-password-button")
	WebElement changePasswordBtn;
	
	@FindBy(css = "p.content")
	public WebElement notification;
	
	public void changeAccountPassword(String oldPassword, String newPassword)
	{
		clickButton(changePasswordLink);
		setTextElementText(oldPasswordTxtBox, oldPassword);
		setTextElementText(newPasswodTxtBox, newPassword);
		setTextElementText(confirmNewPasswordTxtBox, newPassword);
		clickButton(changePasswordBtn);
	}
}
