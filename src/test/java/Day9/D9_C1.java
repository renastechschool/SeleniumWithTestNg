package Day9;

import Utilities.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class D9_C1 {


    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setup(){
        driver= WebDriverUtils.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new WebDriverWait(driver,100);
    }
    @Test
    public void implicitWait(){

        /*
          The Implicit Wait in Selenium is used to tell the web driver to
           wait for a certain amount of time before it throws a "No Such Element Exception".
          The default setting is 0. Once we set the time, the web driver will
          wait for the element for that time before throwing an exceptio
         */


        driver.get("https://google.com");

        driver.findElement(By.name("q"));
    }

    @Test
    public void explicitWait() throws InterruptedException {


        /*
        Explicit Wait
      The Explicit Wait in Selenium is used to tell the Web Driver to wait for
      certain conditions (Expected Conditions) or maximum time exceeded before
      throwing "ElementNotVisibleException" exception.
      It is an intelligent kind of wait, but it can be applied only for specified elements.
      It gives better options than implicit wait as it waits for dynamically loaded Ajax elements.

      */
        driver.get("https://google.com");

        wait.until(ExpectedConditions.titleIs("Google"));

          //Thread.sleep(5000);// it will wait for 5

        wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
    }

    @Test
    public void explicitWaitPractice(){
        driver.get("https://www.amazon.com/");

        wait.until(ExpectedConditions.titleContains("Amazon"));
        String bestSeller= "Best Seller";
        wait.until(ExpectedConditions.textToBePresentInElement(driver.
                findElement(By.xpath("//a[@data-csa-c-slot-id='nav_cs_0']")),"Best Seller"));
    }

    public void clickableElement(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void visibleElement(By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    @Test
    public void praticeClickableElement(){
        driver.get("https://www.amazon.com/");

      visibleElement(By.cssSelector("#twotabsearchtextbox"));
      WebElement searchField= driver.findElement(By.cssSelector("#twotabsearchtextbox"));
      searchField.sendKeys("apple and oranges");
      clickableElement(By.cssSelector("#nav-search-submit-button"));
    }

    /*
    Fluent Wait
     The Fluent Wait in Selenium is used to define maximum
    time for the web driver to wait for a condition,
    as well as the frequency with which we want to
    check the condition before throwing an
    "ElementNotVisibleException" exception.
    It checks for the web element at regular
     intervals until the object is found or timeout happens.

     */
    @Test
    public void fluentWait(){
        driver.get("http://google.com");

        Wait<WebDriver>fluentWait=new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        fluentWait.until(driver->driver.findElement(By.name("q")));
    }
}
