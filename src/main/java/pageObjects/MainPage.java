package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver){
        this.driver=driver;
    }
    
    By sideNavButton = By.cssSelector("#react-burger-menu-btn");
    By sideNavItems = By.cssSelector("#logout_sidebar_link");
    By inventoryList = By.xpath("//div[@class='inventory_item']/div[2]/a/div");
    By sortDropdown = By.cssSelector(".product_sort_container");

    public WebElement getSideNavbarButton(){
        return driver.findElement(sideNavButton);
    }

    public  WebElement getLogoutButton(){
        return driver.findElement(sideNavItems);
    }

    public  List<WebElement> getInventoryItems(){
        System.out.println("size of an array   :  "+driver.findElements(inventoryList).size());
        return driver.findElements(inventoryList);
    }

    public Select getsortDropdown(){
        Select dropdownSort = new  Select( driver.findElement(sortDropdown));
        return dropdownSort;
    }

    public void optionZtoA(){
        getsortDropdown().selectByValue("za");
    }

    public   ArrayList<String> getLabels(){
        ArrayList<String> inventoryLabels = new ArrayList<String>();
        System.out.println("size of an array"+getInventoryItems().size());
        for(int x=0; getInventoryItems().size()>x ; x++){
            inventoryLabels.add(getInventoryItems().get(x).getText());
        }
        return inventoryLabels;
    }
}
