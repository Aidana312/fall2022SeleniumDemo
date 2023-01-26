package com.facebook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertDemo extends BaseTest{

    @Test
    public void testAlert1(){
        driver.get("https://demoqa.com/alerts");
        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();// driver переключись на алерт
        alert.accept();
        Helper.pause(3000);
    }
    @Test
    public void testExplicitWaitAndAlert(){
        driver.get("https://demoqa.com/alerts");
        WebElement alertButton = driver.findElement(By.id("timerAlertButton"));
        alertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // явное ожидание(объект класса)
        wait.until(ExpectedConditions.alertIsPresent());//жди пока наши ожидаемые условия не появятся
        Alert alert = driver.switchTo().alert();
        alert.accept();//нажимает на ОК(поддтверждает алерт)
    }
    @Test
    public void clickMe(){
        driver.get("https://demoqa.com/alerts");
        WebElement clickMe1 = driver.findElement(By.id("confirmButton"));
        clickMe1.click();
        Alert alert2 = driver.switchTo().alert();
        alert2.dismiss();//нажимает на "отмена"(отклонить алерт)
        WebElement cancelText = driver.findElement(By.id("confirmResult"));
        Assert.assertEquals(cancelText.getText(),"You selected Cancel");
    }
    @Test
    public void promptTest(){
        driver.get("https://demoqa.com/alerts");
        WebElement prompt = driver.findElement(By.id("promtButton"));
        prompt.click();
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Aidana");
        alert3.accept();
        WebElement promt2 = driver.findElement(By.id("promptResult"));
        Assert.assertEquals(promt2.getText(),"You entered Aidana");
    }
}


