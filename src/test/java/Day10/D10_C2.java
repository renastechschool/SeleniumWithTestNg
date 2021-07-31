package Day10;

import Utilities.CommonUtils;
import Utilities.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class D10_C2 {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= WebDriverUtils.getDriver(
                CommonUtils.readProperty("src/test/resources/login.properties","browser"));
    }
    @Test
    public  void readPropertiesTest() throws IOException {
        File propertiesFile= new File("src/test/resources/credentials.properties");

        Properties properties= new Properties();
        properties.load(new FileInputStream(propertiesFile));

        String browser= properties.getProperty("browser");
        System.out.println(browser);

        String url= properties.getProperty("url");
        System.out.println(url);

        String username= properties.getProperty("username");
        System.out.println(username);

        String password= properties.getProperty("password");
        System.out.println(password);

    }

    @Test
    public void login(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        WebElement userNameField=driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        WebElement passwordField= driver.findElement(By.cssSelector("#ctl00_MainContent_password"));

        userNameField.sendKeys(CommonUtils.
                readProperty("src/test/resources/login.properties","username"));
        passwordField.sendKeys(
                        CommonUtils.readProperty("src/test/resources/login.properties","password"));

        WebElement loginButton= driver.findElement(By.xpath("//*[@type='submit']"));
        loginButton.click();

    }
}
