package Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Base {

  protected   WebDriver driver;

    @BeforeMethod
    public void setup(){
     String browser=CommonUtils.readProperty("src/test/resources/credentials.properties","browser");
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(!result.isSuccess()){
            CommonUtils.takeScreenShot(driver,result.getName());
        }
        driver.quit();
    }
}
