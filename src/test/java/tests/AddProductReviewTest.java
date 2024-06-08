package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegisterationPage;

public class AddProductReviewTest extends TestBase{

	HomePage homePageObject;
	UserRegisterationPage userRegisterationPageObject ;
	LoginPage loginPageObject;
	
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsObject;
	
	ProductReviewPage productReviewPageObject;
	
	String firstName = "Islam";
	String lastName = "Mohamed";
	String email = "Islam1254678@gmail.com";
	String password = "12345789";
	String productName = "Apple MacBook Pro 13-inch";
	
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
	public void loginUserCanAddProductReview()
	{
		productDetailsObject.openProductReviewsPage();
		
		productReviewPageObject = new ProductReviewPage(driver);
		productReviewPageObject.addProductReview("Test", "This is Test");
		
		Assert.assertTrue(productReviewPageObject.productReviewResult.getText().contains("Product review is successfully added"));
	}
	
	@Test(dependsOnMethods = {"loginUserCanAddProductReview"} )
	public void RegisterUserCanLogout()
	{
		homePageObject.userLogOut();
		
	}
	
}
