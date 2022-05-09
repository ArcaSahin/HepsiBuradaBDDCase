package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

	WebDriver driver;
	
	private ProductPage productpage;
	private BasketPage basketpage;
	
	@FindBy(id="addToCart")
	WebElement addToCartBtn;
	
	
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public ProductPage addToCart() {
		addToCartBtn.click();
		return productpage;
	}
	
	public BasketPage goToBasket() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Sepete git')]"))).click();
		return basketpage;	
	}
}
