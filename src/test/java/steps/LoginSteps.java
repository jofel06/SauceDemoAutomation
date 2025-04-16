package steps;

import base.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.LoginDataModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import utils.ConfigReader;
import utils.LoginDataReader;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    public LoginSteps() {
        this.driver = Hooks.driver;
        this.loginPage = new LoginPage(driver);
    }

    @Given("I am on the Saucedemo login page")
    public void userIntheLoginPage(){
        String baseUrl = ConfigReader.getUrl(); //Use ConfigReader to get the URL
        driver.get(baseUrl);
    }

    @When("I enter the username and password")
    public void userEnterTheUsernameAndPassword(){
        LoginDataModel loginData = LoginDataReader.getLoginData(); // Use the data reader
        loginPage.enterUserName(loginData.getUsername());
        loginPage.enterPassword(loginData.getPassword());
    }

    @And("I click the login button")
    public void userClickTheLoginButton(){
        loginPage.clickLoginButton();
    }

    @Then("I should be logged in normally")
    public void userShouldLoggedInNormally(){
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "User is Logged in Normally");
    }
}
