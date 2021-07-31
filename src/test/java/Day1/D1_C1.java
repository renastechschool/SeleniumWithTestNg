package Day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class D1_C1 {

    public static void main(String[] args) throws InterruptedException {

        /*
        TASK:
        Navigate to Facebook Login Page
        Validate that using title and url
         */

        /*
        Choosing the browser from WebdriverManager
         */
        WebDriverManager.chromedriver().setup();
       /*
       Create instance of chromedriver to be alble to test tings on chrome
        */
        WebDriver driver= new ChromeDriver();

        /*
        Get method will help us to navigate to a URL/URI
         */
        driver.get("https://www.facebook.com/");

        //This method will maximize the browser
        driver.manage().window().maximize();

        /*
        Validate title of the specific page
         */
        String actualTitle= driver.getTitle();
        System.out.println("Facebook title is: "+actualTitle);

        String expectedTitle= "Facebook - Log In or Sign Up";

        if(actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("Test is passed");
        }else{
            System.out.println("Test is failed");
        }

        /*
        GetCurrentUrl will get the page's URL/URI
         */
        String currentUrl=driver.getCurrentUrl();
        System.out.println("The URL is :" + currentUrl);


        /*
        It comes from Java
        It stops the compiler for a particular amount of seconds
        It is called "lazy wait"
        It is not preferable by automation tester
         */
        Thread.sleep(3000);

         /*
        will close the certain page
         */
        //driver.close();

        //will close the browser
       // driver.quit();
    }
}
