package com.bridgelabz.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CrossBrowserScript1 {

        WebDriver driver;
        @BeforeTest
        @Parameters("browser")
        public void setUp(String browser) throws Exception
        {
            if (browser.equalsIgnoreCase("chrome"))
            {
                System.setProperty("webdriver.chrome.driver", "/home/admin1/IdeaProjects/SeleniumNew/Driver/chromedriver");
                driver = new ChromeDriver();
            }
            else if (browser.equalsIgnoreCase("firefox"))
            {
                System.setProperty("webdriver.gecko.driver","/home/admin1/Downloads/geckodriver-v0.26.0-linux64/geckodriver");
                driver = new FirefoxDriver();
            }
            else {
                throw new Exception("Browser is not correct");
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }

        @Test
        public void testParameterWithXML() throws InterruptedException {
            driver.get("https://www.facebook.com/");
            WebElement userName = driver.findElement(By.id("email"));
            userName.sendKeys("khairnarswapna93@gmail.com");
            Thread.sleep(2000);
            WebElement password = driver.findElement(By.id("pass"));
            password.sendKeys("sweetpinu@93");
            Thread.sleep(2000);
            WebElement login = driver.findElement(By.id("u_0_b"));
            login.click();
        }

        @AfterMethod
        public void tearDown() {
            driver.quit();
        }

}
