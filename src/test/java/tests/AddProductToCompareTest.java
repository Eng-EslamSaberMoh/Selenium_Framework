package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CompareProductsPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class AddProductToCompareTest extends TestBase{

	String first_productToCompare = "Apple MacBook Pro 13-inch";
	String second_productToCompare = "Asus N551JK-XO076H Laptop";
	
	HomePage homeObject;
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsObject;
	CompareProductsPage compareProductsPageObject;
	
	@Test(priority = 1)
	public void userCanCompareProducts()
	{
		homeObject = new HomePage(driver);
		productDetailsObject = new ProductDetailsPage(driver);
		searchPageObject = new SearchPage(driver);
		
		homeObject.productSearch(first_productToCompare);
		Assert.assertTrue( searchPageObject.productTitleLink.getText().contains(first_productToCompare));
		productDetailsObject.addProductToCompareList();

		homeObject.productSearch(second_productToCompare);
		Assert.assertTrue( searchPageObject.productTitleLink.getText().contains(second_productToCompare));
		productDetailsObject.addProductToCompareList();
		
		productDetailsObject.openProductComparePage();
		
		compareProductsPageObject = new CompareProductsPage(driver);
		compareProductsPageObject.compareProducts();
		
		Assert.assertTrue(compareProductsPageObject.productNameToCompare.get(0).getText().contains(second_productToCompare));
		Assert.assertTrue(compareProductsPageObject.productNameToCompare.get(1).getText().contains(first_productToCompare));
		
	}
	
	@Test(priority = 2)
	public void userCanClearCompareList()
	{
		compareProductsPageObject.clearCompareProductsList();
	}
}
