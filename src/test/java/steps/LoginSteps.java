package steps;

import base.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.LoginDataModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProductPage;
import utils.ConfigReader;
import utils.LoginDataReader;

import java.util.List;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;
    private LoginDataModel loginData;

    public LoginSteps() {
        this.loginPage = new LoginPage(Hooks.getDriver());
        this.productPage = new ProductPage(Hooks.getDriver());
    }

    @Given("User is on the Saucedemo login page")
    public void userIntheLoginPage(){
        Hooks.getDriver().get(ConfigReader.getUrl());
    }

    @When("User logs in as {string}")
    public void userEnterLoginCredentials(String usernameKey){
        List<LoginDataModel> allUsers = LoginDataReader.getLoginData();

        loginData = allUsers.stream()
                .filter(user -> user.getUsername().equals(usernameKey))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found in JSON: " + usernameKey));

        loginPage.enterUserName(loginData.getUsername());
        loginPage.enterPassword(loginData.getPassword());
        loginPage.clickLoginButton();
    }

    @Then("User should be logged in normally")
    public void userShouldBeLoggedInNormally(){
        Assert.assertEquals(productPage.isAppLogoDisplayed(), "Swag Labs", "User is not logged in successfully");
    }

    @Then("User should see the error message {string}")
    public void iShouldSeeTheErrorMessage(String expectedMessage) {
        String actualErrorMessage = loginPage.getLoginErrorText();
        Assert.assertEquals(actualErrorMessage, "Epic sadface: Sorry, this user has been locked out.");
    }
}
