package Day10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    public loginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="txtUsername")
    public WebElement usernameField;

    @FindBy(id = "txtPassword")
    public  WebElement passwordField;

    @FindBy(name = "Submit")
    public WebElement loginButton;
}
