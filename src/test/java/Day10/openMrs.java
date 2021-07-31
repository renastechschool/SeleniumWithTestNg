package Day10;

import Utilities.Base;
import Utilities.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.Test;

public class openMrs extends Base {

    /*
    ****Implement Page object model
      -Test classes
       -loginPage
       -DashboardPage
       *
    navigate https://demo.openmrs.org/openmrs/
    locate elements for login
     userName= admin
     password= Admin123
     Click inpatient ward
     click login button

     once you are logged in locate an element
     */
    WebDriver driver= WebDriverUtils.getDriver("chrome");
    loginPageOpenMrs login= new loginPageOpenMrs(driver);
    dashboardPageOpemMrs dashboard= new dashboardPageOpemMrs(driver);
    registerPageOpenMrs register= new registerPageOpenMrs(driver);

    @Test
    public void openMrsTest(){

        driver.navigate().to("https://demo.openmrs.org/openmrs/");
//        WebElement usernameBox = driver.findElement(By.id("username"));
//        WebElement passwordBox = driver.findElement(By.id("password"));
//        usernameBox.sendKeys("admin");
//        passwordBox.sendKeys("Admin123");
//        WebElement option = driver.findElement(By.id("Inpatient Ward"));
//        option.click();
//        WebElement login = driver.findElement(By.id("loginButton"));
//        login.click();

        login.usernameField.sendKeys("admin");
        login.passwordField.sendKeys("Admin123");
        login.inpatientWard.click();
        login.loginButton.click();

        String title= driver.getTitle();
        Assert.assertTrue(title.equals("Home"));
        dashboard.clickRegisterButton.click();
        register.nameField.sendKeys("RenasTech");

    }
}
