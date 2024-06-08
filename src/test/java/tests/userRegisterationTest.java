package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;

public class userRegisterationTest extends TestBase
{
	
	HomePage homePageObject;
	UserRegisterationPage userRegisterationPageObject ;
	LoginPage loginPageObject;
	
	String firstName = "Islam";
	String lastName = "Mohamed";
	String email = "Islam1235577@gmail.com";
	String password = "123456789";
	
	
	@Test
	public void UserCanRegisterSuccessfully()
	{
	
		homePageObject = new HomePage(driver);
		homePageObject.openRegisterationPage();
		
		userRegisterationPageObject = new UserRegisterationPage(driver);
		userRegisterationPageObject.userRegister(firstName, lastName, email, password);
		
		Assert.assertTrue( userRegisterationPageObject.registerationMessage.getText().contains("Your registration completed") );
	}
	
	@Test(dependsOnMethods = {"UserCanRegisterSuccessfully"} )
	public void RegisterUserCanLogin()
	{
		homePageObject.openLoginPage();
		
		loginPageObject = new LoginPage(driver);
		loginPageObject.userLogin(email, password);
		
		Assert.assertTrue( homePageObject.logoutLink.getText().contains("Log out") );
	}
}
