package Day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D4_C2 {
    public static void main(String[] args) {

        /*
        Navigate to https://courses.letskodeit.com/practice
        click on BMW RADIO button
        verify that its selected
        Check Bmw, Benz, honda
        validate that benz is selected
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://courses.letskodeit.com/practice");

        WebElement clickBmw=driver.findElement(By.cssSelector("#bmwradio"));
        clickBmw.click();

        boolean bmwRadioSelected= clickBmw.isSelected();

        if(!bmwRadioSelected){ // is its not selected print out "failed
            System.out.println("failed");
        }else{  //else passed
            System.out.println("passed");
        }
    }
}
