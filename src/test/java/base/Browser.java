package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
    public Properties properties = new Properties();
    public WebDriver driver;

    @BeforeClass
    public void openBrowser() {
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (properties.getProperty("browser.name").toString()) {
        case "chrome":
            // Check if headless mode is enabled
            if (properties.getProperty("headless").toString().equalsIgnoreCase("true")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless"); // Run Chrome in headless mode
                driver = new ChromeDriver(options); // Initialize ChromeDriver with options
            } else {
                driver = new ChromeDriver(); // Initialize ChromeDriver normally
            }
            break;

        case "FF":
            WebDriverManager.firefoxdriver().setup(); // Sets up FirefoxDriver automatically
            driver = new FirefoxDriver();
            break;

        case "IE":
            WebDriverManager.edgedriver().setup(); // Sets up EdgeDriver automatically
            driver = new EdgeDriver();
            break;
    }

    driver.get(properties.getProperty("applicationURL").toString());
    }

    @AfterClass
    public void closeBrowser() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
