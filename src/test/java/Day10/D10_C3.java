package Day10;

import Utilities.CommonUtils;
import Utilities.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class D10_C3 {

    WebDriver driver;
    loginPage loginPage;
    leavePage leavePage;

    @BeforeMethod
    public void setup(){
        driver= WebDriverUtils.getDriver(CommonUtils.readProperty("src/test/resources/login.properties", "browser"));
        loginPage= new loginPage(driver);
        leavePage=new leavePage(driver);
    }
    /*
    Document Object Model (DOM) => HTML
    Page Object Model (POM)
    POM helps use to organize our code by storing elements from
    different pages into different classes. That way we are able to improve maintainablitiy,
    readability of our code structure
     */
    @Test
    public void pageObjectModelPractice(){

        driver.get(CommonUtils.
                readProperty("src/test/resources/credentials.properties", "url"));

        //WebElement usernameField= driver.findElement(By.id("txtUsername"));

        loginPage.usernameField.sendKeys("Admin");
        loginPage.passwordField.sendKeys("admin123");
        loginPage.loginButton.click();
        leavePage.assignLeave.click();
    }
}
