package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class checkOutPage extends PageBase{

	public checkOutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="BillingNewAddress_FirstName")
	WebElement BillingNewAddress_FirstNameTxt;
	
	@FindBy(id="BillingNewAddress_LastName")
	WebElement BillingNewAddress_LastNameTxt;
	
	@FindBy(id="BillingNewAddress_Email")
	WebElement BillingNewAddress_EmailTxt;
	
	@FindBy(id="BillingNewAddress_Company")
	WebElement BillingNewAddress_CompanyTxt;
	
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement BillingNewAddress_CountrySelector;
	
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement BillingNewAddress_StateSelector;
	
	@FindBy(id="BillingNewAddress_City")
	WebElement BillingNewAddress_City;
	
	@FindBy(id="BillingNewAddress_Address1")
	WebElement BillingNewAddress_Address1Txt;
	
	@FindBy(id="BillingNewAddress_Address2")
	WebElement BillingNewAddress_Address2Txt;
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement BillingNewAddress_ZipPostalCodeTxt;
	
	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement BillingNewAddress_PhoneNumberTxt;
	
	@FindBy(id="BillingNewAddress_FaxNumber")
	WebElement BillingNewAddress_FaxNumberTxt;
	
	@FindBy(css="button.button-1.new-address-next-step-button")
	WebElement Billing_Continue_Btn;
	
	@FindBy(id = "shippingoption_0")
	WebElement  Shipping_Ground  ;
	
	@FindBy(id = "shippingoption_1")
	WebElement  Shipping_Next_Day_Air;
	
	@FindBy(id = "shippingoption_2")
	WebElement  Shipping_The_two_day_air ;
	
	@FindBy(css="button.button-1.shipping-method-next-step-button")
	WebElement Shipping_Continue_Btn;
	
	@FindBy(id = "paymentmethod_0")
	WebElement  Payment_by_cheque_or_money_order  ;
	
	@FindBy(id = "paymentmethod_1")
	WebElement  Payment_by_credit_or_debit_card  ;
	
	@FindBy(css="button.button-1.payment-method-next-step-button")
	WebElement Payment_Continue_Btn;
	
	@FindBy(css="button.button-1.payment-info-next-step-button")
	WebElement Payment_Information_Continue_Btn;
	
	@FindBy(css="button.button-1.confirm-order-next-step-button")
	WebElement confirm_order_btn;
	
	@FindBy(xpath ="//div[@class='section order-completed']/div/strong")
	public WebElement checkOutOrderStatus;
	
	@FindBy(css = "a.product-name")
	public WebElement productNameTxt;
	
	@FindBy(xpath = "//div[@class='details-link']/a")
	WebElement orderDetailsLink;
	
	
	public void checkoutProduct(String firstName, String lastName,
			String email,  String country,
			String city, String address1, 
			String postalCode, String phoneNumber, String shipping_method, 
			String payment_method )
	{
		setTextElementText(BillingNewAddress_FirstNameTxt, firstName);
		setTextElementText(BillingNewAddress_LastNameTxt, lastName);
		setTextElementText(BillingNewAddress_EmailTxt, email);
		
		selectCountry(country);
		
		setTextElementText(BillingNewAddress_City, city);
		setTextElementText(BillingNewAddress_Address1Txt, address1);
		setTextElementText(BillingNewAddress_ZipPostalCodeTxt, postalCode);
		setTextElementText(BillingNewAddress_PhoneNumberTxt, phoneNumber);
		
		clickButton(Billing_Continue_Btn);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		selectShippingMethod( shipping_method );
		
		clickButton(Shipping_Continue_Btn);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		selectPaymentMethod( payment_method );
		
		clickButton( Payment_Continue_Btn ) ;
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		clickButton( Payment_Information_Continue_Btn ) ;
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public void confirmOrder()
	{
		clickButton( confirm_order_btn ) ;
	}
	
	public void selectCity(String city)
	{
		select = new Select(BillingNewAddress_City);
		select.selectByVisibleText(city);
	}
	
	
	public void selectCountry(String country)
	{
		select = new Select(BillingNewAddress_CountrySelector);
		select.selectByVisibleText(country);
	}
	
	public void selectState(String state)
	{
		select = new Select(BillingNewAddress_StateSelector);
		select.selectByVisibleText(state);
	}
	
	
	public void selectShippingMethod(String shipping_method)
	{
		if( shipping_method.contains("Ground") )
		{
			clickButton(Shipping_Ground);
		}
		else if( shipping_method.contains("Next Day Air") )
		{
			clickButton(Shipping_Next_Day_Air);
		}
		else if( shipping_method.contains("2nd Day Air") )
		{
			clickButton(Shipping_The_two_day_air);
		}
		
	}
	
	
	public void selectPaymentMethod(String payment_method)
	{
		if( payment_method.contains("Check / Money Order") )
		{
			clickButton(Payment_by_cheque_or_money_order);
		}
		else if( payment_method.contains("Credit Card") )
		{
			clickButton(Payment_by_credit_or_debit_card);
		}
	
		
	}
	
	public void openOrderDetailsPage()
	{
		clickButton(orderDetailsLink);
	}
}
