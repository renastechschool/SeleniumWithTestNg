package Day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class D4_C1 {
    public static void main(String[] args) {
        /*
        Css
        -The fastest locator
        What is the implementation css in code?
        css locator driver.findElement(By.cssSelector("kgfak");
         */
        WebDriverManager.chromedriver().setup();
        //polymorphism->
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        //implicit wait=> it will wait for the whole page to load
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com");

        WebElement searchField= driver.findElement(By.cssSelector("#twotabsearchtextbox"));

        searchField.sendKeys("apples");


         WebElement searchButton= driver.findElement(By.cssSelector("#nav-search-submit-button"));

         searchButton.click();
    }
}
