package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement loginErrorText;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterUserName(String username){
        type(usernameField, username);
    }

    public void enterPassword(String password){
        type(passwordField, password);
    }

    public void clickLoginButton(){
        click(loginButton);
    }

    public String getLoginErrorText(){
        if (loginErrorText.isDisplayed()){
            return getText(loginErrorText);
        }
        else {
            throw new AssertionError("Login error message is not displayed.");
        }

    }
}
