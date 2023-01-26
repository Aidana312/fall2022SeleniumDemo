package com.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumExceptions extends BaseTest{

    @Test
    public void noSuchElementExceptionTest(){
        // NoSuchElementException:
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.findElement(By.xpath("userName")).sendKeys("Hello World");
    }

    @Test
    public void noSuchWindowExceptionTest(){
        // NoSuchWindowException
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.switchTo().window("Hello");
    }

    @Test
    public void noSuchFrameExceptionTest(){
        // NoSuchFrameException
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.switchTo().frame(123);
    }

    @Test
    public void noSuchAlertExceptionTest(){
        // NoSuchAlertException
        browserHelper.openURL("https://demoqa.com/text-box");
        alertHelper.acceptAlert();
    }
    @Test
    public void invalidSelectorExceptionTest(){
        //InvalidSelectorException
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.findElement(By.cssSelector("//button[@type='button'][2]"));
    }
    @Test
    public void noSuchSessionExceptionTest(){
        //noSuchSessionExceptionTest
        driver.quit();
        browserHelper.openURL("https://demoqa.com/text-box");
    }

    @Test
    public void staleElementReferenceExceptionTest(){
        //StaleElementReferenceExceptionTest
        driver.get("https://www.amazon.com/");
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
        List<WebElement> allBrands = driver.findElements(By.xpath("//div[@id='brandsRefinements']//ul/li/span/a"));
        int count = 0;
        for (WebElement e : allBrands) {
            count++;
            if (e.getText().contains("SAMSUNG")) {
                driver.findElement(By.xpath("(//div[@id='brandsRefinements']//ul/li/span/a/div/label/i)" + "[" + count + "]")).click();

            }
        }
    }

    @Test
    public void timeOutExceptionTest(){
        //TimeOutExceptionTest
        browserHelper.openURL("https://demoqa.com/text-box");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("enableAfter"))).click();

    }

    }




