package seleniumProject;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
//import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import resources.base;

public class checkURLTest extends base {

    public static Logger logger = LogManager.getLogger(base.class.getName());
    public WebDriver driver;
    CartPage cartPage;

    @BeforeTest
	public void createDirectorySetup() throws IOException, InterruptedException
	{
	//taskkill /F /IM node.exe
		Thread.sleep(3000);
        createDirectory("screenshot");
	}

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

    @Test
    public void driverStatusTest() {
        String currentURL= driver.getCurrentUrl();
        if(currentURL!="https://www.saucedemo.asdasfcom/"){
            Assert.assertTrue(false);
        }
    } 

    @AfterClass
    public void quitTest() throws IOException {
    	//closing driver
        driver.close();
    }
}
