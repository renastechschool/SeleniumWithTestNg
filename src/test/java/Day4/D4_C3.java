package Day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class D4_C3 {
    public static void main(String[] args) throws InterruptedException {

        /*
        Dropdown menu
         -Select class from selenium
          if Html tagName starts "select" then we are able to use Select
          class from Selenium to interact with dropdown menu
          if Tag is not "select" then locate element per usual.
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://courses.letskodeit.com/practice");

        WebElement dropdown= driver.findElement(By.cssSelector("#carselect"));


        Select select= new Select(dropdown);

        select.selectByVisibleText("Benz");
        Thread.sleep(2000);

        select.selectByIndex(1);
        Thread.sleep(2000);

        select.selectByValue("honda");


    }
}
