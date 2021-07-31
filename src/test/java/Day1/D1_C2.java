package Day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D1_C2 {

    public static void main(String[] args) throws InterruptedException {
        /*
        TASK
        Navigate to https://www.google.com/
        Get the title
        Navigate to "https://www.facebook.com/"
        Get the title
        Navigate Back
        Navigate Forward
        Refresh
         */

        //WebDriver Setup
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        /*
        driver.get vs driver.Navigate()
        driver.get will navigate to a particular website and it will wait until page is loaded
        driver.navigate() will navigate to a page but it will not wait until the page is fully load
         */

        //Maximize Window
        driver.manage().window().maximize();

        //Navigate Google and Get title
        driver.get("https://www.google.com/");
        String googleActualTitle= driver.getTitle();
        System.out.println(googleActualTitle);

        Thread.sleep(4000);
        /*
        Navigate class 4 methods:
         -navigate().to(); will navigate to a URL
         -Navigate().Back();
         -Navigate().Forward();
         -Navigate().Refresh();
         */

        //Navigate Facebook and Get title
        driver.navigate().to("https://www.facebook.com/");
        String facebookActualTitle=driver.getTitle();
        System.out.println(facebookActualTitle);

        Thread.sleep(3000);
        //will navigate to previous page
        driver.navigate().back();

        Thread.sleep(3000);
        //will navigate to previous page
        driver.navigate().forward();

        Thread.sleep(3000);
        //will refresh the page
        driver.navigate().refresh();

        //quit browser
        driver.quit();
    }
}
