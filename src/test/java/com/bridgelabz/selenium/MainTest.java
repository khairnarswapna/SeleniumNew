package com.bridgelabz.selenium;

import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

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
    public void FBAccount() throws InterruptedException, AWTException {

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
        Thread.sleep(5000);
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

    @Test
    public void DragnDrop() throws InterruptedException {

        driver.get("http://demo.guru99.com/test/drag_drop.html");

        //Element which needs to drag.
        WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));

        //Element on which need to drop.
        WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li"));

        //Using Action class for drag and drop.
        Actions act=new Actions(driver);

         Thread.sleep(4000);
        //Dragged and dropped.
         act.dragAndDrop(From, To).build().perform();
         Thread.sleep(5000);
    }


    @Test
    public void ReadPDF() throws Exception {
        URL TestURL = new URL("http://www.axmag.com/download/pdfurl-guide.pdf");

        BufferedInputStream TestFile = new BufferedInputStream(TestURL.openStream());
        PDFParser TestPDF = new PDFParser((RandomAccessRead) TestFile);
        TestPDF.parse();
        String TestText = new PDFTextStripper().getText(TestPDF.getPDDocument());
        Assert.assertTrue(TestText.contains("Open the setting.xml,you can see it is like this"));


    }

    @Test
    public void PDFReader() throws IOException {

        driver.get("http://www.pdf995.com/samples/pdf.pdf");
        driver.manage().window().maximize();
        String Currentlink=driver.getCurrentUrl();
        URL url=new URL(Currentlink);
        InputStream is=url.openStream();
        BufferedInputStream fp=new BufferedInputStream(is);
        PDDocument document=null;
        document=PDDocument.load(fp);
        String pdfContent= new PDFTextStripper().getText(document);
        System.out.println(pdfContent);

    }


    @Test
    public void testHandleBrowserPopUpWindow() throws InterruptedException, AWTException {

        //Launching the site.
        driver.get("http://demo.guru99.com/popup.php");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
        String MainWindow = driver.getWindowHandle();
        // To handle all new opened window.
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        while (iterator.hasNext()) { String next = iterator.next();
        if (!MainWindow.equalsIgnoreCase(next)) {

        // Switching to Child window
            driver.switchTo().window(next);
            driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com ");
            Thread.sleep(2000);
            driver.findElement(By.name("btnLogin")).click();
            Thread.sleep(2000);
        // Closing the Child Window.
            driver.close();
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(MainWindow);
    }


}
