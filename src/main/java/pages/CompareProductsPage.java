package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareProductsPage extends ProductDetailsPage
{

	public CompareProductsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "a.clear-list")
	WebElement clearListBtn;
	
	@FindBy(xpath = "//table[@class='compare-products-table']/tbody/tr")
	List<WebElement> allCompareProductsTableRows;
	
	@FindBy(xpath = "//table[@class='compare-products-table']/tbody/td")
	List<WebElement> allCompareProductsTableColumns;
	
	@FindBy(xpath = "//tr[@class='product-name']/td/a")
	public List<WebElement> productNameToCompare;
	
	@FindBy(xpath = "//tr[@class='product-name']/td[2]/a")
	WebElement secondProductNameToCompare;
	
	public void clearCompareProductsList()
	{
		clickButton(clearListBtn);
	}
	
	public void compareProducts()
	{
		for(WebElement table_row: allCompareProductsTableRows)
		{
			System.out.println(table_row.getText() + "\t");
			for(WebElement  table_col: allCompareProductsTableColumns)
			{
				System.out.println(table_col.getText() + "\t");
			}
		}
		
		
	}
	
	
}
