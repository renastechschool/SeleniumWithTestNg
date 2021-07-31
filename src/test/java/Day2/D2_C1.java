package Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D2_C1 {

    public static void main(String[] args) {
        /*
        Locating Elements By.name();
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement userNameField= driver.findElement(By.name("txtUsername"));
        userNameField.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("txtPassword"));
        password.sendKeys("admin123");

        WebElement loginButton= driver.findElement(By.name("Submit"));
        loginButton.click();
    }
}
