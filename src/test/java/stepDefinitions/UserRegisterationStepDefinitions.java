package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;
import tests.TestBase;

public class UserRegisterationStepDefinitions extends TestBase{

	HomePage homePageObject;
	UserRegisterationPage userRegisterationPageObject ;
	LoginPage loginPageObject;
	
	@Given("User in homePage")
	public void user_in_home_page() 
	{
		homePageObject = new HomePage(driver);
	}
	
	@When("User opens registeration Page")
	public void user_opens_registeration_page() 
	{
		homePageObject = new HomePage(driver);
		homePageObject.openRegisterationPage();
		
	}
	
	@When("User enter {string} , {string} , {string} , {string}")
	public void user_enter(String firstName, String lastName, String email, String password) 
	{
		userRegisterationPageObject = new UserRegisterationPage(driver);
		userRegisterationPageObject.userRegister(firstName, lastName, email, password);
		
		
	}
	
	@Then("Registeration Succesfuly displayed")
	public void registeration_succesfuly_displayed() {
		userRegisterationPageObject = new UserRegisterationPage(driver);
		Assert.assertTrue( userRegisterationPageObject.registerationMessage.getText().contains("Your registration completed") );
	}
}
