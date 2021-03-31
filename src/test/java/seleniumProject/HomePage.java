package seleniumProject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.MainPage;
import resources.base;
//import resources.dbconnection;

public class HomePage extends base {

    public static Logger logger = LogManager.getLogger(base.class.getName());

    @BeforeTest
    public void initializeDriver() throws IOException {
        System.out.println(base.class.getName());
        driver = initalizeDriver();
        logger.info("driver is initialized");
        driver.get(properties.getProperty("url"));
        logger.info("navigate too home");
    }

    @Test(dataProvider = "CredentialProvider")
    public void loginTest(String user, String pass) throws InterruptedException, SQLException {
        LandingPage landingPage = new LandingPage(driver);
        // dbconnection dbcon = new dbconnection();
        // dbcon.makeConnection();
        landingPage.getusernameField().sendKeys(user);
        landingPage.getpassField().sendKeys(pass);
        landingPage.getLoginButton().click();
        logger.info("logging in");
    }

    @Test (dependsOnMethods = { "loginTest" })
    public void verifySortingDescending() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.getSideNavbarButton().isDisplayed());
        ArrayList<String> reversedInventoryItems = mainPage.getLabels();
        Collections.sort(reversedInventoryItems, Collections.reverseOrder());  
        mainPage.optionZtoA();
        ArrayList<String> InventoryItems = mainPage.getLabels();
        if (InventoryItems.equals(reversedInventoryItems)){
            logger.info("sorting is correct");
        }
        else{
            Assert.assertTrue(false);
        }
        
    }

    @Test(dependsOnMethods = { "verifySortingDescending" })
    public void logoutTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.getSideNavbarButton().click();
        mainPage.getLogoutButton().click();
    }

    @AfterTest
    public void quitTest() throws IOException {
        driver.close();
    }

    @DataProvider(name = "CredentialProvider")
    public Object[][] DataProvider() {
        Object[][] data = new Object[1][2];
        data[0][0] = "standard_user";
        data[0][1] = "secret_sauce";
        return data;
    }
}
