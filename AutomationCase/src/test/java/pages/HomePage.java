package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	private HomePage homepage;
	private SearchPage searchpage;
	
	@FindBy(xpath="//a[@title='Hesabım']")
	WebElement myAccountTxt;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement enterTxt;
	
	@FindBy(className="SearchBoxOld-buttonContainer")
	WebElement searchBtn;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement checkBuyerLoggedIn() {
		return myAccountTxt;
	}
	
	public HomePage enterSearchText(String productname) {
		enterTxt.sendKeys(productname);
		return homepage;
	}
	
	public SearchPage clickSearchButton() {
		searchBtn.click();
		return searchpage;
	}
	
	
}
