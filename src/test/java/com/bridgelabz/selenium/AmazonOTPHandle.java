package com.bridgelabz.selenium;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class AmazonOTPHandle extends BaseTest  {

     public static final String ACCOUNT_SID="AC2c10024d4b14cd5db970720fe2fee34d";
     public static final String AAUTHENTICATION_TOKEN="d0807efe3f55a354f92d15c079b11233";

    @Test
    public void testName() {

        driver.get("https://www.amazon.in/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[contains(text(),'Hello. Sign in')]")).click();
        driver.findElement(By.xpath("//a[@class='nav-a' and @rel='nofollow']")).click();

        driver.findElement(By.xpath("//input[@id='ap_customer_name']")).sendKeys("swapna khairnar");
        driver.findElement(By.id("auth-country-picker-container")).click();

        driver.findElement(By.xpath("//a[@id='auth-country-picker_212']")).click();

        driver.findElement(By.xpath("//input[@id='ap_phone_number']")).sendKeys("6075244240");
        driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("khairnarswapna");
        driver.findElement(By.xpath("//input[@id='continue']")).click();

        //get the OTP using twillio API

        Twilio.init(ACCOUNT_SID,AAUTHENTICATION_TOKEN);
        String smsbody=getMessage();
        System.out.println(smsbody);
        driver.findElement(By.xpath("//input[@id='auth-pv-enter-code']")).sendKeys(smsbody);
    }
   public String getMessage(){

        return getMessages().filter(m->m.getDirection().compareTo(Message.Direction.INBOUND)==0)
                .filter(m->m.getTo().equals("+16075244240")).map(Message::getBody).findFirst()
                .orElseThrow(IllegalStateException::new);
    }
    private Stream<Message> getMessages() {

        ResourceSet<Message> messages= Message.reader(ACCOUNT_SID).read();
        return StreamSupport.stream(messages.spliterator(),false);
    }
}
