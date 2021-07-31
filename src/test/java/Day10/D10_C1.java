package Day10;

import Utilities.CommonUtils;
import Utilities.WebDriverUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class D10_C1 {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= WebDriverUtils.getDriver("chrome");
    }

    @Test
    public void screenShotTest() throws IOException {
        driver.get("https://google.com");
        //Screenshot method
        File firstScreenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //Screenshot folder
        String screenShotFolder="screenshot/";

        //Folder path and name
        FileUtils.copyFile(firstScreenShotFile,
                new File(screenShotFolder
                        +"myScreenshot"+System.currentTimeMillis()+".png"));
    }

    @Test
    public void test(){
        driver.get("https://etsy.com");
        Assert.fail();// explicitly failing the test case
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(!result.isSuccess()){
            CommonUtils.takeScreenShot(driver, result.getName());
        }
        driver.quit();
    }
}
