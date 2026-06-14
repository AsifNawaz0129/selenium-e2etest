package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    private WebDriver driver;
    
    public LandingPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[type='submit']")
    WebElement loginButton;

    @FindBy(css = "input[id='user-name']")
    WebElement usernameField;

    @FindBy(css = "input[id='password']")
    WebElement passField;

    public MainPage getLoginButton() {
        loginButton.click();
        return new MainPage(driver);
    }
    public WebElement getusernameField(){
        return usernameField;
    }
    public WebElement getpassField(){
        return passField;
    }
}