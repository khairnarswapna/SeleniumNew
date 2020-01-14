package com.bridgelabz.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class MainTest extends BaseTest
{
    @Test(priority = 2)
    public void Navigate_gmailWebBrower() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.navigate().to("https://www.gmail.com/");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

    @Test(invocationCount = 4)
    public void AccessingGitHubAccount() throws InterruptedException {

        String baseUrl = "https://github.com/login";
        driver.get(baseUrl);
        WebElement email = driver.findElement(By.name("login"));
        WebElement password=driver.findElement(By.name("password"));
        WebElement SignIn=driver.findElement(By.name("commit"));
        email.sendKeys("khairnarswapna");
        Thread.sleep(2000);
        password.sendKeys("sweetpinu@93");
        Thread.sleep(2000);
        SignIn.click();
        /*sign out functionality*/
        driver.findElement(By.xpath("//summary[@class='Header-link']//img[@class='avatar']")).click();
        driver.findElement(By.xpath("//button[@class='dropdown-item dropdown-signout']")).click();

    }


    @Test
    public void FBAccount() throws InterruptedException {

        String baseUrl = "https://wwww.facebook.com";
        driver.get(baseUrl);
        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement password=driver.findElement(By.xpath("//input[@id='pass']"));
        WebElement SignIn=driver.findElement(By.xpath("//input[@id='u_0_b']"));
        email.sendKeys("khairnarswapna93@gmail.com");
        Thread.sleep(2000);
        password.sendKeys("sweetpinu@93");
        Thread.sleep(2000);
        SignIn.click();
        /*sign out functionality*/
        driver.findElement(By.xpath("//div[@id='userNavigationLabel']")).click();
        driver.findElement(By.xpath("//li[@class='_54ni navSubmenu _6398 _64kz __MenuItem']")).click();

    }


    @Test
    public void WebPage_ScrollUpAndDown() throws InterruptedException {

        String baseUrl = "http://seleniumhq.org/download";
        driver.get(baseUrl);
        //typecasting driver object to JavascriptExecutor interface type
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 1; i < 10; i++) {
            //scroll down on the webpage
            js.executeScript("window.scrollBy(0, 1000)");
            Thread.sleep(2000);
        }
        for (int i = 1; i < 10; i++) {
            //scroll up on the webpage
            js.executeScript("window.scrollBy(0, -1000)");
            Thread.sleep(2000);
        }

    }





}
