package Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D3_C1 {
    public static void main(String[] args) {
        /*
        There 2 types of xpaths
        Relative Xpath //TagName[@TagAttribute='tagValue']
        --// at the begining of the locator.
        --It is more flexible
        --When web elements changes, it might break

        Absolute xpath /html/body/div/div/div/li/ul/div/a
         --From top to a specific element
         --Single / at the begining of the locator
         --Absolute xpath is more reliable since its starts from the top
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");
        WebElement header= driver.findElement(By.xpath("/html/body/div/div/h1"));

       String title= driver.getTitle();
       String url=  driver.getCurrentUrl();

        if(header.isDisplayed()){
            System.out.println("yay!");
        }else{
            System.out.println("nay!");
        }
        System.out.println(url);
        System.out.println(title);


    }
}
