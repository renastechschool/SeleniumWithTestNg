package Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D3_C5 {
    public static void main(String[] args) {
        //Contains method in xpath
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

        driver.findElement(By.xpath("//input[contains(@id,'tw')]"))
                .sendKeys("Books"+ Keys.ENTER);
    }
}
