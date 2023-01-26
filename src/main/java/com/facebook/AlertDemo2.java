package com.facebook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertDemo2 extends BaseTest{

    @Test
    public void testAlert1(){
        driver.get("https://demoqa.com/alerts");

        WebElement alertBtn = driver.findElement(By.id("alertButton"));
        alertBtn.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        //Helper.pause(3000);



    }

    @Test
    public void testExplicitWaitAndAlert(){
        driver.get("https://demoqa.com/alerts");

        WebElement alertButton = driver.findElement(By.id("timerAlertButton"));
        alertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void testAlert3(){
        driver.get("https://demoqa.com/alerts");

        WebElement confirmButton = driver.findElement(By.id("confirmButton"));
        confirmButton.click();

        Alert alert= driver.switchTo().alert();
        alert.dismiss();

        WebElement confirmResult = driver.findElement(By.id("confirmResult"));

        Assert.assertEquals(confirmResult.getText(),"You selected Cancel");


        WebElement promtButton = driver.findElement(By.id("promtButton"));
        promtButton.click();

        Alert alert1 = driver.switchTo().alert();
        alert1.sendKeys("K");
        alert1.accept();

        WebElement promptResult = driver.findElement(By.id("promptResult"));
        Assert.assertEquals(promptResult.getText(),"You entered K");
    }

}



