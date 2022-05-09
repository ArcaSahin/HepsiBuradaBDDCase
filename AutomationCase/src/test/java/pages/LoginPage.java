package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	private HomePage homepage;
	private LoginPage loginpage;
	
	@FindBy(id="txtUserName")
	WebElement usernameTxt;
	
	@FindBy(id="txtPassword")
	WebElement passwordTxt;
	
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage enterUsernameAndPassword(String username, String password) {
		usernameTxt.sendKeys(username);
		passwordTxt.sendKeys(password);
		return loginpage;
	}
	
	public HomePage clickLogin() {
		loginBtn.click();
		return homepage;
	}
}
