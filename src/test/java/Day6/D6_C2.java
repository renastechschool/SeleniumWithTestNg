package Day6;

import Utilities.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class D6_C2 {

    //1- Open a chrome browser
    //2- Go to:http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    //3- Enter username --->Tester
    //4- Enter password --->test
    //5- Click “Login” button
    //6- Verify title equals: Web Orders

    WebDriver driver = null;
    String url="http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";

    @BeforeMethod
    public void setup(){
        driver= WebDriverUtils.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }
    @AfterMethod
    public void tearDown(){
      //  driver.close();
    }

    public void login(){
        WebElement userNameField=driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        WebElement passwordField= driver.findElement(By.cssSelector("#ctl00_MainContent_password"));

        userNameField.sendKeys("Tester");
        passwordField.sendKeys("test");

        WebElement loginButton= driver.findElement(By.xpath("//*[@type='submit']"));
        loginButton.click();
    }

    @Test
    public void smartBearLogin(){
        login();
        String title = driver.getTitle();
        Assert.assertTrue(title.equalsIgnoreCase("Web Orders"));
    }

    /*
    Smartbear software street verification
      1. Open browser and login to Smartbear software
      2. Click on View all orders
      3. Verify Mark Smith has street as  “9, Maple Valley”
    */
    @Test
    public void smartBearStreetVerification(){
        //1. Open browser and login to Smartbear software
        login();
       // 2. Click on View all orders
        WebElement viewAllOrder= driver.findElement(By.xpath("//*[@href='Default.aspx']"));
        viewAllOrder.click();
       // 3. Verify Mark Smith has street as  “9, Maple Valley”
        WebElement MarksAddress= driver.findElement(By.xpath("//*[.='Mark Smith']/following-sibling::td[4]"));
        Assert.assertTrue(MarksAddress.getText().equalsIgnoreCase("9, Maple Valley"));
    }
}
