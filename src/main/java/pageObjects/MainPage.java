package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MainPage {

	public WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(css = "#react-burger-menu-btn")
    WebElement sideNavButton;

    @FindBy(css = "#logout_sidebar_link")
    WebElement sideNavItems;

    @FindBy(xpath = "//div[@class='inventory_item']/div[2]/a/div")
    List<WebElement> inventoryNameList;

    @FindBy(xpath = "//div[@class='inventory_item']/div[2]/div[2]/button")
    List<WebElement> inventoryAddbuttonList;

    @FindBy(css = ".product_sort_container")
    WebElement sortDropdown;

    @FindBy(css = "#shopping_cart_container")
    WebElement cartIcon;

    public CartPage clickCartIcon(){
        cartIcon.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }
    
    public WebElement getSideNavbarButton(){
        return sideNavButton;
    }

    public WebElement getLogoutButton(){
        return sideNavItems;
    }

    public List<WebElement> getInventoryItems(){
        return inventoryNameList;
    }

    public List<WebElement> getInventoryAddButtons(){
        return inventoryAddbuttonList;
    }

    public Select getsortDropdown(){
        Select dropdownSort = new Select(sortDropdown);
        return dropdownSort;
    }

    public void optionZtoA(){
        getsortDropdown().selectByValue("za");
    }
    
    public void optionAtoZ(){
        getsortDropdown().selectByValue("az");
    }

    public ArrayList<String> getLabels(){
        ArrayList<String> inventoryLabels = new ArrayList<String>();
        for(int x=0; getInventoryItems().size()>x ; x++){
            inventoryLabels.add(getInventoryItems().get(x).getText());
        }
        return inventoryLabels;
    }
}
