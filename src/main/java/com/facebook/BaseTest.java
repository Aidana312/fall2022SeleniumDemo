package com.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public abstract class BaseTest {

    WebDriver driver;
    BrowserHelper browserHelper;
    AlertHelper alertHelper;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup(); // Configure ChromeDriver to connect browser
        driver = new ChromeDriver(); // Creating instance of ChromeDriver
        driver.manage().window().maximize(); // Maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        browserHelper = new BrowserHelper(driver);
        alertHelper = new AlertHelper(driver);
   }
    @AfterClass
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}