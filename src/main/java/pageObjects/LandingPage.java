package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    private WebDriver driver;
    
    public LandingPage(WebDriver driver){
        this.driver= driver;
    }

    By loginButton = By.cssSelector("input[type='submit']");
    By usernameField = By.cssSelector("input[id='user-name']");
    By passField = By.cssSelector("input[id='password']");

    public WebElement getLoginButton(){
        return driver.findElement(loginButton);
    }
    public WebElement getusernameField(){
        return driver.findElement(usernameField);
    }
    public WebElement getpassField(){
        return driver.findElement(passField);
    }
}
