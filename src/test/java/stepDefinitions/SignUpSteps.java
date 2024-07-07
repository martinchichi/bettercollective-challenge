package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.SignUp_PO;
import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static utils.GlobalVariables.ROTOGRINDER_SIGNUP_URL;

public class SignUpSteps {
    WebDriver driver;
    SignUp_PO signUpPage;

    @Given("I access the Roto Grinder sign up page")
    public void i_access_the_roto_grinder_sign_up_page() {
        driver = DriverFactory.getDriver();
        driver.get(ROTOGRINDER_SIGNUP_URL);
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

    @When("I enter an invalid email address")
    public void i_enter_an_invalid_email_address() {
        signUpPage.enterEmail("invalid-email");
    }

    @When("I enter a password")
    public void i_enter_a_password() {
        signUpPage.enterPassword("password123");
    }

    @When("I enter a weak password")
    public void i_enter_a_weak_password() {
        signUpPage.enterPassword("123");
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

    @Then("I should see an error message indicating that the username is required")
    public void i_should_see_an_error_message_indicating_that_the_username_is_required() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(signUpPage.getErrorMessageElement()));

        String expectedMessage = "A username is required.";
        String actualMessage = signUpPage.getErrorMessage();
        assertEquals(expectedMessage, actualMessage);
        DriverFactory.cleanupDriver();
    }

    @Then("I should see an error message indicating that the email is required")
    public void i_should_see_an_error_message_indicating_that_the_email_is_required() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(signUpPage.getErrorMessageElement()));

        String expectedMessage = "An email is required.";
        String actualMessage = signUpPage.getErrorMessage();
        assertEquals(expectedMessage, actualMessage);
        DriverFactory.cleanupDriver();
    }

    @Then("I should see an error message indicating that the password is required")
    public void i_should_see_an_error_message_indicating_that_the_password_is_required() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(signUpPage.getErrorMessageElement()));

        String expectedMessage = "A password is required.";
        String actualMessage = signUpPage.getErrorMessage();
        assertEquals(expectedMessage, actualMessage);
        DriverFactory.cleanupDriver();
    }

    @Then("I should see an error message indicating que el formato del email es inválido")
    public void i_should_see_an_error_message_indicating_que_el_formato_del_email_es_invalido() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(signUpPage.getErrorMessageElement()));

        String expectedMessage = "Invalid email format";
        String actualMessage = signUpPage.getErrorMessage();
        assertEquals(expectedMessage, actualMessage);
        DriverFactory.cleanupDriver();
    }

    @Then("I should see an error message indicating that password is too weak")
    public void i_should_see_an_error_message_indicating_that_the_password_is_too_weak() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(signUpPage.getErrorMessageElement()));

        String expectedMessage = "Your password must be at least 6 characters long.";
        String actualMessage = signUpPage.getErrorMessage();
        assertEquals(expectedMessage, actualMessage);
        DriverFactory.cleanupDriver();
    }

    @Then("I should see a warning message indicating que el username already exists")
    public void i_should_see_a_warning_message_indicating_que_el_username_already_exists() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(signUpPage.getWarningMessageElement()));

        String expectedMessage = "That username is already taken.";
        String actualMessage = signUpPage.getWarningMessage();
        assertEquals(expectedMessage, actualMessage);
        DriverFactory.cleanupDriver();
    }

    @Then("I should see a warning message indicating que el email already exists")
    public void i_should_see_a_warning_message_indicating_que_el_email_already_exists() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(signUpPage.getWarningMessageElement()));

        String expectedMessage = "That email is already taken.";
        String actualMessage = signUpPage.getWarningMessage();
        assertEquals(expectedMessage, actualMessage);
        DriverFactory.cleanupDriver();
    }

    @Then("I should see a warning message indicating que el password ya está en uso")
    public void i_should_see_a_warning_message_indicating_que_el_password_ya_esta_en_uso() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(signUpPage.getWarningMessageElement()));

        String expectedMessage = "That password is already taken.";
        String actualMessage = signUpPage.getWarningMessage();
        assertEquals(expectedMessage, actualMessage);
        DriverFactory.cleanupDriver();
    }

    @When("I enter a random username")
    public void i_enter_a_random_username() {
        String randomUsername = RandomStringUtils.randomAlphabetic(8);
        signUpPage.enterUsername(randomUsername);
    }

    @When("I enter a random email address")
    public void i_enter_a_random_email_address() {
        String randomEmail = RandomStringUtils.randomAlphabetic(5) + "@example.com";
        signUpPage.enterEmail(randomEmail);
    }

    @When("I enter an existing username")
    public void i_enter_an_existing_username() {
        signUpPage.enterUsername("usuario123");
    }

    @When("I enter an existing email address")
    public void i_enter_an_existing_email_address() {
        signUpPage.enterEmail("usuario123@example.com");
    }

    @When("I enter an existing password")
    public void i_enter_an_existing_password() {
        signUpPage.enterPassword("password123");
    }
}
