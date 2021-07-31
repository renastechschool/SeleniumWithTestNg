package Day7;

import Utilities.WebDriverUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.tools.jconsole.Tab;

import java.util.Set;

public class D7_C1 {

    WebDriver driver= null;
    @BeforeMethod
    public void setup(){
    driver= WebDriverUtils.getDriver("chrome");

    }
    @AfterMethod
    public void tearDown(){
   //driver.close();
    }
    @Test
    public void jsAlert() throws InterruptedException {
        driver.navigate().to("http://the-internet.herokuapp.com/");


        //Action helps us to do all the keyboard and mouse action
        Actions action = new Actions(driver);
        WebElement javaScriptAlert= driver.findElement(By.xpath("//*[@href='/javascript_alerts']"));

        String mainPageurl=driver.getCurrentUrl();
        System.out.println(mainPageurl);
      action.keyDown(Keys.SHIFT).click(javaScriptAlert).keyUp(Keys.SHIFT).build().perform();

        /*
       Window Handles are unique identifiers of different windows, tabs.
       In order to switch from one window to anther we need to use window handles

        */
       String firstWIndowHandle= driver.getWindowHandle();
       //We store multiple window handles in Set<String>
       Set<String> allWindowHandles=driver.getWindowHandles();

       String secondWindowHandle="";

       // for loop helps us to compare window handles
       for (String id:allWindowHandles){
           if(!id.equals(firstWIndowHandle)){
              secondWindowHandle=id;
              //it will switch to window
               driver.switchTo().window(secondWindowHandle);
           }
       }
        String url= driver.getCurrentUrl();
        System.out.println(url);

        WebElement jsAlert= driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsAlert.click();

        Thread.sleep(3000);
       Alert alert= driver.switchTo().alert();
       driver.switchTo().alert().accept();
       /*
       ALERT HANDLING METHODS
       driver.SwitchTp().alert()...

       Accept
       Dismiss
       getText()
       SendKeys()
        */
    }

    @Test
    public void jsConfirmOkay() throws InterruptedException {
        driver.navigate().to("http://the-internet.herokuapp.com/");

        WebElement javaScriptAlert= driver.findElement(By.xpath("//*[@href='/javascript_alerts']"));

        javaScriptAlert.click();
        WebElement clickJsConfirm= driver.findElement(By.xpath("//*[@onclick='jsConfirm()']"));
        clickJsConfirm.click();

        Alert alert=driver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();

        WebElement okayText= driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(okayText.getText().contains("Ok"));

    }

    @Test
    public void jsConfirmCancel(){
        /*
        Go to "http://the-internet.herokuapp.com/"
        click JavaScript Alerts
        click js Confirm
        Click Cancel
        Validate text
         */

        driver.navigate().to("http://the-internet.herokuapp.com/");

        WebElement javaScriptAlert= driver.findElement(By.xpath("//*[@href='/javascript_alerts']"));

        javaScriptAlert.click();
        WebElement clickJsConfirm= driver.findElement(By.xpath("//*[@onclick='jsConfirm()']"));
        clickJsConfirm.click();

        Alert alert=driver.switchTo().alert();
        alert.dismiss();
        WebElement actualText= driver.findElement(By.xpath("//p[@id='result']"));

        String expectedText= "You clicked: Cancel";

        Assert.assertFalse(actualText.getText().contains("Ok"));
        Assert.assertTrue(actualText.getText().contains("Cancel"));
        Assert.assertEquals(actualText.getText(),expectedText);
    }
    @Test
    public void jsPromptAlert() throws InterruptedException {
        /*
         Go to "http://the-internet.herokuapp.com/"
         click JavaScript Alerts
         Click for Js Prompt
         Enter "I love this game" text
         Click okay
         Validate your text appearing on the page
         */

        driver.navigate().to("http://the-internet.herokuapp.com/");

        WebElement javaScriptAlert= driver.findElement(By.xpath("//*[@href='/javascript_alerts']"));
        javaScriptAlert.click();

        WebElement clickJsConfirm= driver.findElement(By.xpath("//*[@onclick='jsPrompt()']"));
        clickJsConfirm.click();

        Alert alert= driver.switchTo().alert();
        Thread.sleep(3000);
        alert.sendKeys("I love this game");
        alert.accept();

        WebElement actualText= driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(actualText.getText().contains("I love"));

    }
    // alert or window pop ups mean same thing
    @Test
    public void basicAuthorizationAlert() throws InterruptedException {
        /*
        We can simply provide userName and password within url
         */
        //http://username:password@domain.com
        driver.navigate().to("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        WebElement congratsText= driver.findElement(By.tagName("p"));

        Assert.assertTrue(congratsText.getText().contains("Congratulations"));
    }



    @Test
    public void twitterPopUp() throws InterruptedException {

       /*
       Navigate to https://www.seleniumeasy.com/test/window-popup-modal-demo.html
       Click Twitter button
       Switch to pop window(it is not an alert)
       fill out UserName and Password fields with Invalid data
       validate error message
        */

        driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");

        Thread.sleep(3000);

        WebElement clickTwitter= driver.findElement(By.xpath("//a[@title='Follow @seleniumeasy on Twitter']"));

        clickTwitter.click();

      String handle=  driver.getWindowHandle();
       Set<String>handles= driver.getWindowHandles();
        String secondHandle="";
       for (String id:handles){
           if(!id.equals(handle)){
              secondHandle=id;
               driver.switchTo().window(secondHandle);
           }
       }
       Thread.sleep(3000);
       driver.findElement(By.xpath("//input[@name='session[username_or_email]']")).sendKeys("myUsername");
       driver.findElement(By.xpath("//input[@name='session[password]']")).sendKeys("11234444");
       driver.findElement(By.xpath("//*[@role='button' and @class='css-18t94o4 css-1dbjc4n r-urgr8i r-42olwf r-sdzlij r-1phboty r-rs99b7 r-ero68b r-vkv6oe r-1ny4l3l r-1fneopy r-o7ynqc r-6416eg r-lrvibr']")).click();
    }
    //input[@name='session[password]']
    //input[@name='session[username_or_email]']
}
