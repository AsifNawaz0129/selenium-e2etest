package seleniumProject;

import java.util.List;
import java.io.IOException;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.CartPage;
import pageObjects.LandingPage;
import pageObjects.MainPage;
import resources.base;

public class CartTest extends base {

    public static Logger logger = LogManager.getLogger(base.class.getName());
    public WebDriver driver;
    CartPage cartPage;

    @BeforeTest
    public void initializeDriver() throws IOException {
        System.out.println(base.class.getName());
        driver = initalizeDriver();
        logger.info("driver is initialized");
        driver.get(properties.getProperty("url"));
        // Mazimize current window
        driver.manage().window().maximize();
        logger.info("navigate too home");
    }

    @Test(dataProvider = "CredentialProvider")
    public void cartAddingTest(final String user, final String pass) throws InterruptedException, SQLException {
        final LandingPage landingPage = new LandingPage(driver);
        landingPage.getusernameField().sendKeys(user);
        landingPage.getpassField().sendKeys(pass);
        final MainPage mainpage = landingPage.getLoginButton();
        logger.info("logging in");
        // Add first two items two carts
        final List<WebElement> addButtons = mainpage.getInventoryAddButtons();
        addButtons.get(0).click();
        addButtons.get(1).click();
        //tap on cart Icon
        cartPage = mainpage.clickCartIcon();
        //verify two items in cart
        int cartItemsNumbers = cartPage.getSideNavbarButton();
        if(cartItemsNumbers==2) {
        	logger.info("items added successfully");
        }
        else {
        	logger.info("items not added successfully");
        	Assert.assertTrue(false);
        }
        cartPage.getShoppingButton().click();
    }
    
    

    @AfterTest
    public void quitTest() throws IOException {
    	//closing driver
        driver.close();
    }

    @DataProvider(name = "CredentialProvider")
    public Object[][] DataProvider() {
        final Object[][] data = new Object[1][2];
        data[0][0] = "standard_user";
        data[0][1] = "secret_sauce";
        return data;
    }

}
