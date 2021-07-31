package Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class D3_C2 {
    public static void main(String[] args) {
  /*
    Navigate to https://the-internet.herokuapp.com/
    click forgot password
    fill out email field
    click retrieve password button
   */
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://the-internet.herokuapp.com/");


        WebElement forgotPassword= driver.findElement(By.xpath("//a[@href='/forgot_password']"));
        forgotPassword.click();

        WebElement emailField= driver.findElement(By.xpath("//input[@name='email']"));
        emailField.sendKeys("emai@email.com");
//            driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[20]/a")).click();
//            driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Admin"+ Keys.ENTER);

        WebElement retrievePasswordButton= driver.findElement(By.className("radius"));
        retrievePasswordButton.click();

        WebElement header= driver.findElement(By.tagName("h1"));

        String actualTitle= header.getText();
        String expectedTitle = "Internal Server Error";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("yay!!");
        }else{
            System.out.println("nay!");
        }
    }
}
