package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

public class AddProductToWishlistTest extends TestBase{

	String productName = "Apple MacBook Pro 13-inch";
	
	HomePage hompePageObject;
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsObject;
	WishListPage wishListPageObject;
	
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
	public void userCanAddProductToWhishList()
	{
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.addProductToWishList();
		productDetailsObject.openWishListPage();
		
		wishListPageObject = new WishListPage(driver);
		Assert.assertTrue(wishListPageObject.productName.getText().contains(productName));
	}
	
	
}
