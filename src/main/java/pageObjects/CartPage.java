package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class CartPage {
	public WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver=driver;
    }
    
    By getCartitems = By.cssSelector(".cart_item");
    By getContinueShoppingButton= By.cssSelector("button[name='continue-shopping']");
    
    public int getSideNavbarButton(){
        List<WebElement> cartItems=driver.findElements(getCartitems);
        int cartItemsNumber=cartItems.size();
        return cartItemsNumber;
    }
    
    public WebElement getShoppingButton(){       
        return driver.findElement(getContinueShoppingButton);
    }


}
