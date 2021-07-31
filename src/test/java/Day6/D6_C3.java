package Day6;

import Utilities.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class D6_C3 {


    /*
    Navigate to "http://the-internet.herokuapp.com/iframe"
    Clean the text field
    Type "Hello it's me" to the text field
    Validate the title
     */

    /*
    Selenium => WEBDRIVER, Select,
    TestNg=> Assertions, Annotations(Test, BeforeMethod, Ignore), xml
    Bony Garcia WebdriverManager=browsers
     */

    WebDriver driver;

      @BeforeMethod
      public void setup(){
      driver= WebDriverUtils.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test
    public void iframes(){
          driver.get("http://the-internet.herokuapp.com/iframe");
      /*
          In order to interact with elements within an iframe, one needs to
          locate the iframe first by using locators
          and then SWITCH to the iframe
        */
        driver.switchTo().frame("mce_0_ifr"); //id for iframe

        WebElement messageBox= driver.findElement(By.id("tinymce"));
        messageBox.clear();
        messageBox.sendKeys("Hello it's me");

      //  driver.switchTo().parentFrame();// returns to  previous iframe ot html block
        driver.switchTo().defaultContent();// returns to the main html

        System.out.println(driver.getTitle());
    }

    /*
    Navigate to http://the-internet.herokuapp.com/nested_frames
    Switch to other frames
     */

    @Test
    public void nestedIframes() throws InterruptedException {
        driver.navigate().to("http://the-internet.herokuapp.com/nested_frames");

        Thread.sleep(2000);
        driver.switchTo().frame("frame-top");
        Thread.sleep(2000);
        //switchTo method
        driver.switchTo().frame(0);
        WebElement getIframeText= driver.findElement(By.tagName("body"));

        System.out.println(getIframeText.getText());
        Assert.assertFalse(!getIframeText.getText().equalsIgnoreCase("left"));
        Assert.assertTrue(getIframeText.getText().equalsIgnoreCase("left"));
    }
    @Test
   public void buttomIframe(){
     /*
     Locate the Buttom iframe
     validate the text and print out
      */
        driver.navigate().to("http://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-bottom");
        WebElement buttomText= driver.findElement(By.tagName("body"));
        System.out.println(buttomText.getText());
    }
}

