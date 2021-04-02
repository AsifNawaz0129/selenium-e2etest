package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MainPage {

	public WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver=driver;
    }
    
    By sideNavButton = By.cssSelector("#react-burger-menu-btn");
    By sideNavItems = By.cssSelector("#logout_sidebar_link");
    By inventoryNameList = By.xpath("//div[@class='inventory_item']/div[2]/a/div");
    By inventoryAddbuttonList = By.xpath("//div[@class='inventory_item']/div[2]/div[2]/button");
    By sortDropdown = By.cssSelector(".product_sort_container");
    By cartIcon = By.cssSelector("#shopping_cart_container");

    public CartPage clickCartIcon(){
        driver.findElement(cartIcon).click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }
    
    public WebElement getSideNavbarButton(){
        return driver.findElement(sideNavButton);
    }

    public  WebElement getLogoutButton(){
        return driver.findElement(sideNavItems);
    }

    public  List<WebElement> getInventoryItems(){
        return driver.findElements(inventoryNameList);
    }

    public  List<WebElement> getInventoryAddButtons(){
        return driver.findElements(inventoryAddbuttonList);
    }

    public Select getsortDropdown(){
        Select dropdownSort = new  Select( driver.findElement(sortDropdown));
        return dropdownSort;
    }

    public void optionZtoA(){
        getsortDropdown().selectByValue("za");
    }
    
    public void optionAtoZ(){
        getsortDropdown().selectByValue("az");
    }

    public   ArrayList<String> getLabels(){
        ArrayList<String> inventoryLabels = new ArrayList<String>();
        for(int x=0; getInventoryItems().size()>x ; x++){
            inventoryLabels.add(getInventoryItems().get(x).getText());
        }
        return inventoryLabels;
    }
}
