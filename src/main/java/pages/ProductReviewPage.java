package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="AddProductReview_Title")
	WebElement reviewTitleTxt;

	@FindBy(id="AddProductReview_ReviewText")
	WebElement reviewText;
	
	@FindBy(id="addproductrating_1")
	WebElement rating_1_RadioBtn;
	
	@FindBy(css="button.button-1.write-product-review-button")
	WebElement submitReviewBtn;
	
	@FindBy(xpath = "//div[@class='page-body']/div[@class='result']")
	public WebElement productReviewResult;
	
	public void addProductReview(String review_Title, String review_Text)
	{
		setTextElementText(reviewTitleTxt, review_Title);
		setTextElementText(reviewText, review_Text);
		clickButton(rating_1_RadioBtn);
		clickButton(submitReviewBtn);
	}
	
	
	
}
