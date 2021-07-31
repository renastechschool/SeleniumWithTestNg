package Day5;

import Utilities.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class D5_C3 {

    WebDriver driver = null;

    @BeforeMethod
    public void setup() {
        driver = WebDriverUtils.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown(){
  // driver.close();
    }

    /*
    providing multiple data
     */
    @Test(dataProvider = "test1")
    public void openHrm1233(String userName, String password) {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebElement userNameBox = driver.findElement(By.id("txtUsername"));
        WebElement passwordBox = driver.findElement(By.id("txtPassword"));
        userNameBox.sendKeys(userName);
        passwordBox.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        WebElement errorMessage= driver.findElement(By.xpath("//*[@id='spanMessage']"));

        String invalidMessage=errorMessage.getText();

        Assert.assertEquals(invalidMessage,"Invalid credentials");
        Assert.assertTrue(errorMessage.isDisplayed());
    }


    @DataProvider(name = "test1")
    public static Object[][] loginCredentials() {
        return new Object[][] {{"AD", "ADMIN"},
                {"admin", "falak;fag;fkabjse"}, {"admm", "1234"},
                {"fgfdf", "gjjfi"}, {"admin", "wrongpassword"}};
    }
}






