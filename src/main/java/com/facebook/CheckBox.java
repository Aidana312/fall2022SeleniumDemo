package com.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CheckBox extends BaseTest {

    @Test

    public void checkBox(){

        driver.get("https://demoqa.com/checkbox");

        WebElement commands = driver.findElement(By.xpath("(//button[@title='Toggle'])[1]"));
    }
}
