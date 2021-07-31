package Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D2_C3 {
    public static void main(String[] args) throws InterruptedException {
        /*
        Using LinkText and PartialLinkText
        These locators type are very useful whenever you need click on another url
        It uses the inner Text of the link
         */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        /*
        LinkText and PartialLinkText
        LinkText will use whole inner text whereas PartialLinkText will use portion of it
         */
        //click forgot password button
        WebElement forgotPassword=
                //driver.findElement(By.linkText("Forgot Password?"));

                driver.findElement(By.partialLinkText("Password?"));
        Thread.sleep(2000);
        forgotPassword.click();
        driver.navigate().back();

        //Click create account button
        WebElement CreateAnAccount= driver.findElement(By.partialLinkText("New Account"));
        CreateAnAccount.click();

        WebElement SignupPage= driver.findElement(By.className("mbs _52lq fsl fwb fcb"));
        String text= SignupPage.getText();
        System.out.println(text);
    }
}
