package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BasketPage;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.ProductPage;
import pages.SearchPage;

public class AddBassketViaLoginSteps {

	WebDriver driver = null;

	LandingPage landingpage;
	LoginPage loginpage;
	HomePage homepage;
	SearchPage searchpage;
	ProductPage productpage;
	BasketPage basketpage;

	@Given("^browser is open$")
	public void browser_is_open() throws Throwable {
		//boni garcia method
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@When("^buyer is on landing page$")
	public void buyer_is_on_landing_page() {
		driver.navigate().to("https://www.hepsiburada.com/");
	}

	@And("^buyer clicks login and goes to login page$")
	public void buyer_clicks_login_and_goes_to_login_page() {
		landingpage = new LandingPage(driver);
		loginpage = landingpage.clickLogin();
	}

	@And("^buyer enters valid \"([^\"]*)\" and \"([^\"]*)\"$")
	public void buyer_enters_valid_username_and_password(String username, String password) {
		loginpage = new LoginPage(driver);
		loginpage.enterUsernameAndPassword(username, password);
	}

	@When("^buyer is navigated to the home page$")
	public void buyer_is_navigated_to_the_home_page() {
		LoginPage loginpage = new LoginPage(driver);
		homepage = loginpage.clickLogin();
	}

	@Then("^check if buyer should have been registered successfully$")
	public void check_if_buyer_should_have_been_registered_successfully() {
		homepage = new HomePage(driver);
		Assert.assertTrue(homepage.checkBuyerLoggedIn().isDisplayed());
	}

	@When("^buyer searches for a \"([^\"]*)\"$")
	public void buyer_searches_for_a_something(String productname) {
		homepage.enterSearchText(productname);
	}

	@And("^buyer clicks search and navigated to the search page$")
	public void buyer_clicks_search_and_navigated_to_the_search_page() { 
		homepage = new HomePage(driver);
		searchpage = homepage.clickSearchButton();
	}

	@And("^buyer selects a wanted product$")
	public void buyer_selects_a_wanted_product() {
		searchpage = new SearchPage(driver);
		productpage = searchpage.selectWantedProduct();
	}

	@And("^buyer adds the selected product to the cart$")
	public void buyer_adds_the_selected_product_to_the_basket() {
		productpage = new ProductPage(driver);
		productpage.addToCart();
	}

	@And("^buyer goes to the basket page$")
	public void buyer_goes_to_the_basket_page() {
		productpage = new ProductPage(driver);
		basketpage = productpage.goToBasket();
	}

	@Then("^check if buyer added correct product to the basket on basket page$")
	public void check_if_buyer_added_correct_product_to_the_basket_on_basket_page() {
		basketpage = new BasketPage(driver);
		basketpage.checkIfCorrectProductAddedToTheBasket();
	}

	@After
	public void browserTeardown() {
		driver.close();
		driver.quit();
	}


}
