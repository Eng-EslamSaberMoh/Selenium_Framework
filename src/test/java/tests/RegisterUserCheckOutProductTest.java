package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailsPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import pages.UserRegisterationPage;
import pages.checkOutPage;

public class RegisterUserCheckOutProductTest extends TestBase{

	
	
	String productName = "Apple MacBook Pro 13-inch";
	String productQty = "5";
	
	String firstName = "Islam";
	String lastName = "Saber";
	String password = "123456789";
	String email = "Islam79989876@gmail.com";
	String company = "Etisalat";
	String country = "Egypt";
	String state = "Cairo";
	String city = "Cairo";
	String address1 = "15 May city";
	String address2 = "";
	String postalCode = "123";
	String phoneNumber = "25506162";
	String shipping_method = "Next Day Air";
	String payment_method = " Check / Money Order";


	HomePage homePageObject;
	UserRegisterationPage userRegisterationPageObject ;
	LoginPage loginPageObject;

	SearchPage searchPageObject;
	ProductDetailsPage productDetailsObject;
	ShoppingCartPage shoppingCartPageObject;
	checkOutPage checkOutPageObject;
	
	OrderDetailsPage orderDetailsPageObject;
	
	
	
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
	public void registerUserCanSearchForProduct()
	{
		homePageObject = new HomePage(driver);
		homePageObject.productSearch(productName);
		
		searchPageObject = new SearchPage(driver);	
		searchPageObject.openProductDetailsPage();
		
		productDetailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsObject.productName.getText().equalsIgnoreCase(productName));
		
	} 
	
	
	@Test(dependsOnMethods = {"registerUserCanSearchForProduct"})
	public void registerUserCanAddProductToCart()
	{
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.AddProductToCart();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		productDetailsObject.openShoppingCart();
		
		shoppingCartPageObject = new ShoppingCartPage(driver);
		Assert.assertTrue(shoppingCartPageObject.productName.getText().contains(productName));

	} 
	
	@Test(dependsOnMethods = {"registerUserCanAddProductToCart"})
	public void registerUserCanCheckoutProduct()
	{
		shoppingCartPageObject = new ShoppingCartPage(driver);
		shoppingCartPageObject.openCheckOutPage();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		checkOutPageObject = new checkOutPage(driver);
		checkOutPageObject.checkoutProduct( firstName,  lastName,
				 email, country, city,  address1, 
				 postalCode,  phoneNumber,  shipping_method, 
				 payment_method );
		
		Assert.assertTrue( checkOutPageObject.productNameTxt.isDisplayed() );
		
		Assert.assertTrue( checkOutPageObject.productNameTxt.getText().contains(productName) );
		
		checkOutPageObject.confirmOrder();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Assert.assertTrue( checkOutPageObject.checkOutOrderStatus.getText().contains("Your order has been successfully processed!") );
		
		
	}
	
	@Test(dependsOnMethods = {"registerUserCanCheckoutProduct"})
	public void RegisterUserCanDownloadInvoice()
	{
		checkOutPageObject = new checkOutPage(driver);
		checkOutPageObject.openOrderDetailsPage();
		
		orderDetailsPageObject = new OrderDetailsPage(driver);
		orderDetailsPageObject.downloadPDFInvoice();
		
		//wait to finish download
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
