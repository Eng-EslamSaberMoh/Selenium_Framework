package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ProductAutoSuggestionSearchTest  extends TestBase
{
	String productName = "Apple";
	ProductDetailsPage productDetailsPageObject;
	HomePage homePageObject;
	
	@Test
	public void userCanSearchWithAutoSuggestSearchForProduct()
	{
		homePageObject = new HomePage(driver);
		homePageObject.productSearchUsingAutoSuggest(productName);
		
		
		productDetailsPageObject = new ProductDetailsPage(driver);
		Assert.assertTrue( productDetailsPageObject.productName.getText().contains(productName) );
	}
}
