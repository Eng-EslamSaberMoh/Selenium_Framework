package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;


public class ProductSearchTest extends TestBase{

	String productName = "Apple MacBook Pro 13-inch";
	
	HomePage homeObject;
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsObject;
	
	@Test
	public void userCanSearchForProduct()
	{
		homeObject = new HomePage(driver);
		homeObject.productSearch(productName);
		
		searchPageObject = new SearchPage(driver);	
		searchPageObject.openProductDetailsPage();
		
		productDetailsObject = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetailsObject.productName.getText().equalsIgnoreCase(productName));
		
	}
}
