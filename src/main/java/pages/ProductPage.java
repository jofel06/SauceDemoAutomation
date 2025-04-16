package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage{

    @FindBy(className = "app_logo")
    private WebElement productsPageAppLogo;

    public ProductPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String isAppLogoDisplayed(){
        if(productsPageAppLogo.isDisplayed()){
            return getText(productsPageAppLogo);
        }
        else {
            throw new AssertionError("Login not Successful, user was not redirected to the Product page");
        }
    }
}
