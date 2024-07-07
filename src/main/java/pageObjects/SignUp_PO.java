package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUp_PO extends BasePageObject {

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(css = "input[type='email']")
    WebElement emailField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(css = "[type='submit']")
    WebElement createAccountButton;

    @FindBy(css = ".error.notification")
    private WebElement errorMessage;

    @FindBy(css = "div.notification.active.error p")
    private WebElement warningMessage;

    @FindBy(id = "recaptcha-anchor")
    WebElement captchaAnchor;

    @FindBy(xpath = "//h1[contains(text(),'Welcome to RotoGrinders! Thanks for signing up!')]")
    public WebElement signingUpMessage;

    public SignUp_PO(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void checkCaptcha() {
        clickOnCaptcha(captchaAnchor);
    }

    public void clickCreateAccount() {
        createAccountButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public WebElement getErrorMessageElement() {
        return errorMessage;
    }

    public String getSigningUpMessage() {
        return signingUpMessage.getText();
    }

    public String getWarningMessage() {
        return warningMessage.getText();
    }

    public WebElement getWarningMessageElement() {
        return warningMessage;
    }
}
