package Day10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class leavePage {
    public leavePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@href='/index.php/leave/assignLeave' and @target='_self']")
    public WebElement assignLeave;
}
