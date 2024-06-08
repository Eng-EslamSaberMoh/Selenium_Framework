package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{
	
	HomePage homePageObject;
	ContactUsPage contactUsPageObject;
	
	@Test
	public void UserCanContactUs()
	{
		homePageObject = new HomePage(driver);
		homePageObject.openContactUsPage();
		
		contactUsPageObject = new ContactUsPage(driver);
		contactUsPageObject.contactUs();
		
		Assert.assertTrue(contactUsPageObject.contactUsResult.getText().contains("Your enquiry has been successfully sent to the store owner."));
	}
}
