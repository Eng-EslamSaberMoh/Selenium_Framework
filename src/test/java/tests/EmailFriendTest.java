package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class EmailFriendTest extends TestBase{

	HomePage homePageObject;
	UserRegisterationPage userRegisterationPageObject ;
	LoginPage loginPageObject;
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsObject;
	EmailFriendPage emailFriendPageObject;
	
	String firstName = "Islam";
	String lastName = "Mohamed";
	String email = "Islam12345@gmail.com";
	String password = "123456789";
	String productName = "Apple MacBook Pro 13-inch";
	String friendEmail = "aaa@gmail.com";
	String personalMessage = "Hello Ahmed, This is for test";
	
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
	

	@Test(dependsOnMethods = {"RegisterUserCanLogin"})
	public void userCanSearchForProduct()
	{
		homePageObject = new HomePage(driver);
		homePageObject.productSearch(productName);
		
		searchPageObject = new SearchPage(driver);
		searchPageObject.openProductDetailsPage();
		
		productDetailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsObject.productName.getText().equalsIgnoreCase(productName));
		
	}
	
	
	@Test(dependsOnMethods = {"userCanSearchForProduct"})
	public void loginUserCanEmailProductToFriend()
	{
		productDetailsObject.clickEmailFriendBtn();
		
		emailFriendPageObject = new EmailFriendPage(driver);
		emailFriendPageObject.emailFriend(friendEmail,  personalMessage);
		
		Assert.assertTrue( emailFriendPageObject.emailFriendResult.getText().contains("Your message has been sent.") );
		
	}
}
