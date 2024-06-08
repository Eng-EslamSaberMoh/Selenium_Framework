package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class AddProductToShoppingCart extends TestBase
{
	String productName = "Apple MacBook Pro 13-inch";
	String productQty = "5";
	
	HomePage homeObject;
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsObject;
	ShoppingCartPage shoppingCartPageObject;
	
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
	
	
	@Test(dependsOnMethods = {"userCanSearchForProduct"})
	public void userCanAddProductToCart()
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		productDetailsObject = new ProductDetailsPage(driver);
		productDetailsObject.AddProductToCart();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		productDetailsObject.openShoppingCart();
		
		shoppingCartPageObject = new ShoppingCartPage(driver);
		Assert.assertTrue(shoppingCartPageObject.productName.getText().contains(productName));

	} 
	
	@Test(dependsOnMethods = {"userCanAddProductToCart"})
	public void userCanUpdateCartProductQty()
	{
		
		shoppingCartPageObject = new ShoppingCartPage(driver);
		shoppingCartPageObject.updateProductQty(productQty);

		System.out.println("Quantity: "+shoppingCartPageObject.productQty.getAttribute("value"));
		Assert.assertTrue(shoppingCartPageObject.productQty.getAttribute("value").contains(productQty));

	} 
	
	@Test(dependsOnMethods = {"userCanUpdateCartProductQty"})
	public void userCanClearShoppingCart()
	{
		shoppingCartPageObject = new ShoppingCartPage(driver);
		shoppingCartPageObject.removeProductFromCart();

		Assert.assertTrue(shoppingCartPageObject.shoppingCartOrderSummaryContent.getText().contains("Your Shopping Cart is empty!"));

	}
}
