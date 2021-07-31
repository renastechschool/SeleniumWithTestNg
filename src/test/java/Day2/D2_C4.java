package Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D2_C4 {
    public static void main(String[] args) throws InterruptedException {
  //Locating By.tagName and ClassName

        WebDriverManager.chromedriver().setup();

        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://www.facebook.com/");

        WebElement userNameField= driver.findElement(By.id("email"));

        userNameField.sendKeys("My email Address");

        Thread.sleep(2000);
        WebElement passwordField= driver.findElement(By.id("pass"));
        passwordField.sendKeys("123456");
        Thread.sleep(2000);

        WebElement loginButton= driver.findElement(By.tagName("button"));
        loginButton.click();

        WebElement errorMessage= driver.findElement(By.className("_9ay7"));

        if(errorMessage.isDisplayed()){
            System.out.println("your test is passed");
        }else{
            System.out.println("your test is failed");
        }
    }
}
