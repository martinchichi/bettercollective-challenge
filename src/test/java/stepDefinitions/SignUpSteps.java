package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.SignUp_PO;
import driver.DriverFactory;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class SignUp_Steps {
    WebDriver driver;
    SignUp_PO signUpPage;

    @Given("I access the Roto Grinder sign up page")
    public void i_access_the_roto_grinder_sign_up_page() {
        driver = DriverFactory.getDriver();
        driver.get("https://rotogrinders.com/sign-up");
        signUpPage = new SignUp_PO(driver);
    }

    @When("I enter a username")
    public void i_enter_a_username() {
        signUpPage.enterUsername("usuario123");
    }

    @When("I enter an email address")
    public void i_enter_an_email_address() {
        signUpPage.enterEmail("usuario123@example.com");
    }

    @When("I enter a password")
    public void i_enter_a_password() {
        signUpPage.enterPassword("password123");
    }

    @When("I check the captcha box")
    public void i_check_the_captcha_box() {
        signUpPage.checkCaptcha();
    }

    @When("I click on the create account button")
    public void i_click_on_the_create_account_button() {
        signUpPage.clickCreateAccount();
    }

    @Then("I should be presented with the successful signing up message")
    public void i_should_be_presented_with_the_successful_signing_up_message() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(signUpPage.signingUpMessage));

        String expectedMessage = "Welcome to RotoGrinders! Thanks for signing up!";
        String actualMessage = signUpPage.getSigningUpMessage();
        assertEquals(expectedMessage, actualMessage);
        DriverFactory.cleanupDriver();
    }
}
