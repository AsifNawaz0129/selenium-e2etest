package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class CartPage {
	public WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(css = ".cart_item")
    List<WebElement> cartItems;

    @FindBy(css = "button[name='continue-shopping']")
    WebElement continueShoppingButton;
    
    public int getSideNavbarButton(){
        return cartItems.size();
    }
    
    public WebElement getShoppingButton(){       
        return continueShoppingButton;
    }
}
