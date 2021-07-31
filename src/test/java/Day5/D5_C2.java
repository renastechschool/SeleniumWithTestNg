package Day5;

import Utilities.WebDriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class D5_C2 {
    /*
    Navigate to google
    validate the title
    Locate the search field
    Search "Renastech"
    close the browser
     */


    WebDriver driver=null;// it is visible to evryr method

    @BeforeMethod// before every @Test
    public void setup(){
       driver= WebDriverUtils.getDriver("chrome");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.get("https://www.google.com/");
    }
   @AfterMethod
   public void tearDown() throws InterruptedException {
        driver.close();
   }

    @Test(priority = 2)
    public void googleSearch() throws InterruptedException {

        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.equalsIgnoreCase("Google"));
        WebElement search=driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        Thread.sleep(3000);
        search.sendKeys("Renastech"+ Keys.ENTER);
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void googleSearch1() throws InterruptedException {
        WebElement search=driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        search.sendKeys("Apple and oranges"+Keys.ENTER);
        Thread.sleep(3000);
    }

    @Test(priority=3)
    public void googleSearch3(){
        WebElement search=driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        search.sendKeys("Java books"+Keys.ENTER);
    }

    @Test(priority = 4)
    public void googleSearch4(){
        WebElement search=driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
        search.sendKeys("Selenium"+Keys.ENTER);
    }
}
