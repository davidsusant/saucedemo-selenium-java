package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.LoginPage;

public class Hooks {
    private static WebDriver driver;
    private static LoginPage loginPage;

    @BeforeSuite
    public void beforeSuite() {

    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        String headlessProperty = System.getProperty("headless");
        if (headlessProperty != null && headlessProperty.equals("true")) {
            options.addArguments("--headless=new");
        }
        driver = new ChromeDriver(options);
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void afterSuite() {

    }
}
