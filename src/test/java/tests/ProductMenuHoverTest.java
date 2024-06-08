package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductMenuHoverTest extends TestBase{

	HomePage homePageObject ;
	
	@Test
	public void UserCanSelectSubCategoryFromMainMenu()
	{
		
		homePageObject = new HomePage(driver);
		homePageObject.openNotebooksPage();
		
		Assert.assertTrue( driver.getCurrentUrl().contains("notebooks"));
	}
}
