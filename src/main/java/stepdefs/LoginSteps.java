package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        loginPage.navigateTo();
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("I should be redirected to the products page")
    public void i_should_be_redirected_to_the_products_page() {
        productPage = new ProductPage(driver);
        assertThat(productPage.getProductCount(), is(greaterThan(0)));
    }

    @Then("I should see at least {int} products")
    public void i_should_see_at_least_products(int minCount) {
        assertThat(productPage.getProductCount(), is(greaterThanOrEqualTo(minCount)));
    }
}
