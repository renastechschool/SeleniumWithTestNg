package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverUtils {


//        WebDriverManager.chromedriver().setup();
//        //WebDriverManager.firefoxdriver().setup();
//         WebDriver driver= new ChromeDriver();
//

    public static WebDriver getDriver(String browser) {
        //This method will accept string value
        //this will return Wedriver

        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        }else if(browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        }else if(browser.equalsIgnoreCase("safari")){
            return  new SafariDriver();

        }else if(browser.equalsIgnoreCase("iedriver")) {
            WebDriverManager.iedriver().setup();
            return new InternetExplorerDriver();
        }else{
            System.out.println("Browser does not exist");
            System.out.println("Please check browser name");
            System.out.println("Current browser name: "+browser);
            return null;
        }
    }
}
