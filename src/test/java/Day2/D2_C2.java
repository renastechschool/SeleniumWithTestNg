package Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D2_C2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement userName= driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");

        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("admin123");

        WebElement login = driver.findElement(By.id("btnLogin"));

        login.click ();
    }
}
