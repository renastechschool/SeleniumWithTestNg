package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonUtils {

    public static void takeScreenShot(WebDriver driver, String screenshotName){

        //take screenshot
        File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String destinationDirectory="screenshot/";

        //path and name
        try {
            FileUtils.copyFile(file,new File(
                    destinationDirectory+screenshotName+"-"+System.currentTimeMillis()+".png"));
        } catch (IOException ex) {
          //  e.printStackTrace();
            System.out.println("Failed to take a screenshot: "+ex.getStackTrace());
        }
    }

    public static void clickableElement(WebDriver driver, By locator){
        WebDriverWait wait= new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public static void visibleElement(WebDriver driver,By locator){
        WebDriverWait wait= new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static String readProperty(String fileName, String key){
        File file= new File(fileName);

        Properties properties= new Properties();
        try {
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }

}
