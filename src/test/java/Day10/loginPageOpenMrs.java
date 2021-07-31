package Day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPageOpenMrs {
//
//    WebElement usernameBox = driver.findElement(By.id("username"));
//    WebElement passwordBox = driver.findElement(By.id("password"));
//        usernameBox.sendKeys("admin");
//        passwordBox.sendKeys("Admin123");
//    WebElement option = driver.findElement(By.id("Inpatient Ward"));
//        option.click();
//    WebElement login = driver.findElement(By.id("loginButton"));
//        login.click();

    public loginPageOpenMrs(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "username")
    public WebElement usernameField;

    @FindBy (id = "password")
    public WebElement passwordField;

    @FindBy(id = "Inpatient Ward")
    public WebElement inpatientWard;

    @FindBy(id = "loginButton")
    public WebElement loginButton;


}
