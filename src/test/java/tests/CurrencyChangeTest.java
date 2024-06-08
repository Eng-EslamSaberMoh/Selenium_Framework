package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class CurrencyChangeTest extends TestBase{

	
	
	String productName = "Apple MacBook Pro 13-inch";
	String currency = "Euro";
	
	HomePage hompePageObject;
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsObject;
	
	@Test
	public void userCanSearchForProduct()
	{
		hompePageObject = new HomePage(driver);
		hompePageObject.productSearch(productName);
		
		
		searchPageObject = new SearchPage(driver);
		searchPageObject.openProductDetailsPage();
		
		productDetailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsObject.productName.getText().equalsIgnoreCase(productName));
		
	}
	
	@Test(dependsOnMethods = {"userCanSearchForProduct"})
	public void userCanChangeCurrency()
	{
		hompePageObject = new HomePage(driver);
		hompePageObject.selectCurrency(currency);
		
		Assert.assertTrue(productDetailsObject.productPrice.getText().contains("€"));
		
	}
}
