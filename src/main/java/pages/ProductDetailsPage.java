package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy( id = "add-to-cart-button-4" )
	WebElement addToCartBtn;
	
	@FindBy(css = "button.button-2.add-to-compare-list-button")
	WebElement AddToCompareListBtn;
	
	@FindBy(xpath = "//div[@class='product-name']/h1")
	public WebElement productName;

	@FindBy(css="button.button-2.email-a-friend-button")
	WebElement emailFriendBtn;
	
	@FindBy(linkText = "product comparison")
	WebElement productComparePageLink;
	
	
	@FindBy(xpath = "//div[@class='product-price']")
	public WebElement productPrice;
	
	@FindBy(xpath = "//a[text()='Add your review']")
	public WebElement addYourReviewLink;
	
	
	@FindBy(id="add-to-wishlist-button-4")
	public WebElement addToWishListBtn;
	
	@FindBy(linkText = "wishlist")
	public WebElement wishListLink;
	
	@FindBy(linkText = "shopping cart")
	WebElement shoppingCartLink;
	
	public void clickEmailFriendBtn()
	{
		clickButton(emailFriendBtn);
	}
	
	public void openProductReviewsPage()
	{
		clickButton(addYourReviewLink);
	}
	
	public void addProductToWishList()
	{
		clickButton(addToWishListBtn);
	}
	
	public void openWishListPage()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickButton(wishListLink);
	}
	
	public void addProductToCompareList()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickButton(AddToCompareListBtn);
	}
	
	public void openProductComparePage()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickButton(productComparePageLink);
	}
	
	public void AddProductToCart()
	{
		clickButton(addToCartBtn);
	}
	
	public void openShoppingCart()
	{
		clickButton(shoppingCartLink);
	}
}
