package com.bridgelabz.selenium;



import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    WebDriver driver;
    @BeforeMethod
    public void loading_web_Driver() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void closing_web_driver() {
        driver.close();

    }
}
