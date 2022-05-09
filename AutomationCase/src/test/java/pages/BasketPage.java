package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {
	
	WebDriver driver;
	
	private BasketPage basketpage;
	
	@FindBy(xpath="//*[contains(text(),'25 kg')]")
	WebElement checkAddedProductName;

	public BasketPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement checkIfCorrectProductAddedToTheBasket() {
		Assert.assertTrue(checkAddedProductName.isDisplayed());
		return checkAddedProductName;
	}
}
