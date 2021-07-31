package Day8;

import Utilities.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class D8_C1 {
    WebDriver driver;
    Actions actions=null;

    @BeforeMethod
    public void setup(){
        driver= WebDriverUtils.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions=new Actions(driver);
    }
    @Test
    public void allUpperCase(){
        driver.get("https://www.google.com/");

        WebElement searchField= driver.findElement(By.name("q"));
        actions.keyDown(searchField,Keys.SHIFT).
                sendKeys("renastech"+Keys.ENTER).keyUp(Keys.SHIFT).build().perform();
    }

    @Test
    public void firstLetterCapital(){
        /*
        press SHIFT and type
         */
        driver.get("https://www.google.com/");

        WebElement searchField= driver.findElement(By.name("q"));

        actions.keyDown(Keys.SHIFT).sendKeys(searchField,"r").
                keyUp(Keys.SHIFT).sendKeys(searchField,"enastech"+Keys.ENTER)
                .build().perform();
    }
    @Test
    public void copyAndPaste(){
        driver.get("https://amazon.com");
        WebElement searchField= driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        actions.sendKeys(searchField,"Harry Potter"+Keys.SPACE).
                //Pressing Command Key
                keyDown(Keys.COMMAND)
                //Selecting text
                .sendKeys("a")
                //Copy
                .sendKeys("c")
                //Paste
                .sendKeys("v")
                //Paste
                .sendKeys("v")
                //Paste
                .sendKeys("v")
                //Stop pressing Command key
                .keyUp(Keys.COMMAND).sendKeys(Keys.ENTER)
                .build().perform();
    }

    @Test
    public void cutAndPaste(){
        driver.get("https://amazon.com");
        WebElement searchField= driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        actions.sendKeys(searchField,"books").
                keyDown(Keys.COMMAND)
                //Select
                .sendKeys("a")
                //Cut
                .sendKeys("x")
                //Paste
                .sendKeys("v").
                //Paste
                sendKeys("v")
                //will release the Command Key
                .keyUp(Keys.COMMAND)
                //Click Enter
                .sendKeys(Keys.ENTER)
                .build().perform();
    }
}
