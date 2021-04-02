package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * base
 */
public class base {

    // Class Variable
    public WebDriver driver;
    public Properties properties;

    // Class Methods
    public WebDriver initalizeDriver() throws IOException {
        properties = new Properties();
        String path = (System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
        System.out.println(path);
        FileInputStream fis = new FileInputStream(path);
        properties.load(fis);
        String browserName = properties.getProperty("browser");
        System.out.println("." + browserName + ".");

        if (browserName.equals("chrome")) {
            // Initialize chrome browser
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (browserName.equals("firefox")) {
            // Initialize Firefox browser
            driver = new FirefoxDriver();
        } else if (browserName.equals("IE")) {
            // Initialize IE browser
            driver = new InternetExplorerDriver();
        }
        // Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public String getScreenshot(String testName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationPath = System.getProperty("user.dir") + "\\report\\" + testName + ".png";
        File destinationFile = new File(destinationPath);
        FileUtils.copyFile(source, destinationFile);
        return destinationPath;
    }
}