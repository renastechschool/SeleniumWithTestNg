package Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D3_C4 {

    public static void main(String[] args) {

         /*
        navigate to herokuapp
        click AddRemoveElements
        Click Add button
        Check if Delete button is displayed using an if statement
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.xpath("//a[text()='Add/Remove Elements']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();

        WebElement deleteButton=driver.findElement(By.xpath("//button[text()='Delete']"));

        if (deleteButton.isDisplayed()){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }

    }
}
