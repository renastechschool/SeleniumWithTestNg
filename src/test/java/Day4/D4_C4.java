package Day4;

import Utilities.WebDriverUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class D4_C4 {
       /*
        Navigate to Etsy.com
        Find  Search button and click
        Click ShipIn1Day
        and verify that it is selected
        Click ShipIn3Days
        and Verify that it is selected
         */
       public static void main(String[] args) throws InterruptedException {


           WebDriver driver = WebDriverUtils.getDriver("chrome");
          // WebDriver driver = WebDriverUtils.getDriver("chrome");


           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           driver.get("https://www.etsy.com");

           WebElement searchButton= driver.findElement(By.xpath("//button[@class='wt-input-btn-group__btn global-enhancements-search-input-btn-group__btn' and @type='submit']"));
           searchButton.click();

           Thread.sleep(2000);
           WebElement oneDayShipping=driver.findElement(By.xpath("//label[@for='max-processing-days-1']"));

           oneDayShipping.click();


           WebElement clickedDayOne= driver.findElement(By.xpath("//label[@for='max-processing-days-1']/preceding-sibling::input"));

           if(clickedDayOne.isSelected()){
               System.out.println("1 day shipping");
           }else {
               System.out.println("no shipping in 1 day");
           }

           WebElement threeDayShipping= driver.findElement(By.xpath("//label[@for='max-processing-days-3']"));
           threeDayShipping.click();

           WebElement clickedThreeDayShipping= driver.findElement(By.xpath("//label[@for='max-processing-days-3']/preceding-sibling::input"));

           if(clickedThreeDayShipping.isSelected()){
               System.out.println("3 days shipping");
           }else{
               System.out.println("no shipping in 3 days");
           }

       }
}
