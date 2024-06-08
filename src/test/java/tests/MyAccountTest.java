package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegisterationPage;

public class MyAccountTest extends TestBase {

	
	HomePage homePageObject;
	UserRegisterationPage userRegisterationPageObject ;
	LoginPage loginPageObject;
	MyAccountPage myAccountPageObject;
	
	String firstName = "Islam";
	String lastName = "Mohamed";
	String email = "Islam12345789@gmail.com";
	String password = "123456789";
	String newPassword = "1234567891";
	
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
	
	
	@Test(dependsOnMethods = {"RegisterUserCanLogin"} )
	public void RegisterUserCanChangeAccountPassword()
	{
		homePageObject.openMyAccountPage();
		
		myAccountPageObject = new MyAccountPage(driver);
		myAccountPageObject.changeAccountPassword(password, newPassword);
		
		Assert.assertTrue( myAccountPageObject.notification.getText().contains("Password was changed"));
		
	}
}
