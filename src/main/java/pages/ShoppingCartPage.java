package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(css = "a.product-name")
	public WebElement productName;

	@FindBy(xpath = "//td[@class='unit-price']//span[@class='product-unit-price']")
	public WebElement productPrice;
	
	@FindBy(css  = "input.qty-input")
	public WebElement productQty;

	@FindBy(className = "product-subtotal")
	public WebElement productTotalPrice;

	@FindBy(css = "button.remove-btn")
	WebElement removeProductBtn;
	
	@FindBy(id = "updatecart")
	WebElement updateShoppingCartBtn;
	
	@FindBy(css = "div.no-data")
	public WebElement shoppingCartOrderSummaryContent;
	
	@FindBy(id = "termsofservice")
	WebElement termsOfServiceCheckBox;
	
	@FindBy(id = "checkout")
	WebElement checkOutBtn;
	
	public void openCheckOutPage()
	{
		clickButton(termsOfServiceCheckBox);
		clickButton(checkOutBtn);
	}
	
	public void checktermsOfServiceCheckBox()
	{
		clickButton(termsOfServiceCheckBox);
	}
	
	
	
	public void removeProductFromCart()
	{
		clickButton(removeProductBtn);
	}
	
	public void updateProductQty(String qty)
	{
		clearTxt(productQty);
		setTextElementText(productQty, qty);
		clickButton(updateShoppingCartBtn);
	}

}
