package Day6;

import Utilities.WebDriverUtils;
import com.sun.deploy.uitoolkit.impl.awt.AWTAppletAdapter;
import com.sun.org.glassfish.external.statistics.AverageRangeStatistic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class D6_C1 {

    //1- Open a chrome browser
    //2- Go to:http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    //3- Enter INVALID username
    //4- Enter INVALID password
    //5- Click "Login" button
    //6- Verify THE ERROR message

    WebDriver driver = null;
    String url="http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";

  @BeforeMethod
    public void setup(){
      driver= WebDriverUtils.getDriver("chrome");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
      driver.get(url);
  }
  @AfterMethod
    public void close(){
      driver.close();
  }
  @Test(dataProvider = "testData")
    public void smartBearLoginWithWrongCredentials(String userName, String password){

      WebElement userNameField=driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
      WebElement passwordField= driver.findElement(By.cssSelector("#ctl00_MainContent_password"));

      userNameField.sendKeys(userName);
      passwordField.sendKeys(password);

      WebElement loginButton= driver.findElement(By.xpath("//*[@type='submit']"));
      loginButton.click();

      WebElement errorMessage= driver.findElement(By.className("error"));

      Assert.assertTrue(errorMessage.isDisplayed());
  }

  /*

 Given that I am a registered user=>PRECONDITION/ARRANGE DATA
 When I login in with valid credentials=>ACTION
 Then I should see my account page=>ASSERTIONS/VALIDATIONS
   */

  @DataProvider(name="testData")
    public static Object[][] wrongUserCredentials(){
      return  new Object[][] {{"addhd","passeerr"},
              {"","02022835u2#$%%"},{"!!!ADMIN","00000"},{"Tester","te"}};
  }
}
