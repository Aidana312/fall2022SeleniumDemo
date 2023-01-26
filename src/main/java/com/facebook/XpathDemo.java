package com.facebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class XpathDemo extends BaseTest {


    @Test
    public void xpath1Test(){ //

        WebDriverManager.chromedriver().setup(); // сохраняем элемент

        WebDriver driver = new ChromeDriver(); // управляем браузером(весь процесс с браузером в роли посредника это driver
        driver.manage().window().maximize(); // просим открыть на весь экран
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // даем 20 секунд на открытие сайта

        driver.get("https://demoqa.com/text-box");// заходим на наш нужный сайт

        WebElement nameText = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[2]/div[1]/label"));

        String expectedEmailText = "Email"; //ищем такой текст

        Assert.assertEquals(nameText.getText(),expectedEmailText); //сравниваем фактический и ожидаемый результат

        driver.close();// нам закрывает сайт



    }
}
