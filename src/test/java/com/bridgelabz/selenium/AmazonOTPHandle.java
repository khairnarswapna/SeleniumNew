package com.bridgelabz.selenium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AmazonOTPHandle extends BaseTest  {



     public static final String ACCOUNT_SID="AC2c10024d4b14cd5db970720fe2fee34d";
     public static final String AAUTHENTICATION_TOKEN="d0807efe3f55a354f92d15c079b11233";

    @Test
    public void testName() {

        driver.get("https://www.amazon.in/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[contains(text(),'Hello. Sign in')]")).click();
        driver.findElement(By.xpath("//div[@class='nav-signin-tooltip-footer']//a[@class='nav-a'][contains(text(),'Start here.')]")).click();
        driver.findElement(By.xpath("//input[@id='ap_customer_name']")).sendKeys("swapna khairnar");
       // driver.findElement(By.xpath(""))

    }
}
