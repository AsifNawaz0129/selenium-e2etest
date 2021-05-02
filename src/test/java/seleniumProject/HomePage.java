package seleniumProject;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.MainPage;
import resources.base;
//import resources.dbconnection;

public class HomePage extends base {

    public static Logger logger = LogManager.getLogger(base.class.getName());
    public  WebDriver driver;
    MainPage mainpage;

    @BeforeClass
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
    public void loginTest(String user, String pass) throws InterruptedException, SQLException {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.getusernameField().sendKeys(user);
        landingPage.getpassField().sendKeys(pass);
        mainpage = landingPage.getLoginButton();
        logger.info("logging in");
    }

    @Test(dependsOnMethods = { "loginTest" })
    public void verifySortingDescending() throws InterruptedException {
        Assert.assertTrue(mainpage.getSideNavbarButton().isDisplayed());
        ArrayList<String> reversedInventoryItems = mainpage.getLabels();
        Collections.sort(reversedInventoryItems, Collections.reverseOrder());
        mainpage.optionZtoA();
        ArrayList<String> InventoryItems = mainpage.getLabels();
        if (InventoryItems.equals(reversedInventoryItems)) {
            logger.info("sorting is correct");
        } else {
            logger.info("desc sorting is not functioning right");
            Assert.assertTrue(false);
        }

    }

    @Test(dependsOnMethods = { "verifySortingDescending" })
    public void verifySortingAscending() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        ArrayList<String> ascendingInventoryItems = mainPage.getLabels();
        Collections.sort(ascendingInventoryItems);
        mainPage.optionAtoZ();
        ArrayList<String> InventoryItems = mainPage.getLabels();
        if (InventoryItems.equals(ascendingInventoryItems)) {
            logger.info("sorting is correct");
        } else {
            logger.info("asc sorting is not functioning right");
            Assert.assertTrue(false);
        }

    }

    @Test(dependsOnMethods = { "verifySortingAscending" })
    public void logoutTest() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.getSideNavbarButton().click();
        mainPage.getLogoutButton().click();
    }

    @AfterClass
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
