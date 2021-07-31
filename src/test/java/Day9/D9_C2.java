package Day9;

import Utilities.WebDriverUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class D9_C2 {

    WebDriver driver;
    JavascriptExecutor js;
    @BeforeMethod
    public void setup(){
        driver= WebDriverUtils.getDriver("chrome");
        js= (JavascriptExecutor) driver;
    }

    @Test
    public void jsExecutor(){

        js.executeScript("window.location='https://amazon.com'");

        WebElement searchField= (WebElement) js.executeScript
                ("return document.getElementById('twotabsearchtextbox').value='love'");
    }

    @Test
    public void scrolling() throws InterruptedException { //scroll down for a specific amount
        driver.get("https://amazon.com");

        //executeScript("window.scrollBy(x-pixels,y-pixels)");
        // Scroll vertically down by 4950 pixels
        js.executeScript("window.scrollBy(0,4950)");
//
//        WebElement someText= driver.findElement(By.linkText("Sign in to see personalized recommendations"));
//
//        Assert.assertTrue(someText.isDisplayed());

        Thread.sleep(2000);
        //Scroll up
        js.executeScript("window.scrollBy(0,-5000)");
    }

    @Test
    public void scrollingToEndOfThePage() throws InterruptedException {
        driver.get("https://amazon.com");

        //scroll to end of page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
       Thread.sleep(2000);
        //will scroll up for 800 pixels
      js.executeScript("window.scrollBy(0,-800)");

        WebElement someText= driver.findElement(By.linkText("Sign in to see personalized recommendations"));

        Assert.assertTrue(someText.isDisplayed());
    }

    @Test
    public void ScrollByElement(){
        driver.get("http://demo.guru99.com/test/guru99home/");

        WebElement element= driver.findElement(By.linkText("Linux"));

        js.executeScript("arguments[0].scrollIntoView();", element);
    }

}
