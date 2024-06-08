package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase{

	public UserRegisterationPage(WebDriver driver) 
	{
		super(driver);
	}

	
	@FindBy(id = "gender-male")
	WebElement genderMaleRdoBtn;
	
	@FindBy(id = "gender-female")
	WebElement genderFemaleRdoBtn;
	
	@FindBy(id = "FirstName")
	WebElement fistNameTxtBox;
	
	@FindBy(id = "LastName")
	WebElement lastNameTxtBox;
	
	@FindBy(id = "Email")
	WebElement emailTxtBox;
	
	@FindBy(id = "Password")
	WebElement passwordTxtBox;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTxtBox;
	
	@FindBy(id = "register-button")
	WebElement registerBtn;
	
	@FindBy(css ="div.result")
	public  WebElement registerationMessage;
	
	public void userRegister(String firstName, String lastName, 
			String email, String password)
	{
		clickButton(genderMaleRdoBtn);
		
		setTextElementText(fistNameTxtBox, firstName);
		setTextElementText(lastNameTxtBox, lastName);
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		setTextElementText(confirmPasswordTxtBox, password);
		
	
		clickButton(registerBtn);
		
		
	}
	
}
