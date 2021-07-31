package Day8;

import Utilities.WebDriverUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class  D8_C2 {
    WebDriver driver;
    Actions actions;
    Alert alert;

    @BeforeMethod
    public void setup(){
        driver= WebDriverUtils.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions= new Actions(driver);

    }
    @AfterMethod
    public void tearDown(){
       // driver.close();
    }
    @Test
    public void click(){
        driver.get("http://the-internet.herokuapp.com/");
        WebElement aBTest= driver.findElement(By.xpath("//a[text()='A/B Testing']"));
        actions.click(aBTest).build().perform();
    }
    @Test
    public void mouseRightClick() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/");

        WebElement contextClick= driver.findElement(By.linkText("Context Menu"));
       //Clicking contextText by using mouse click
        actions.click(contextClick).build().perform();

        WebElement rectangleClick= driver.findElement(By.id("hot-spot"));
        //Right click
        actions.contextClick(rectangleClick).build().perform();
        //Accepting the alert
        alert= driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void doubleClick(){
        driver.navigate().to("http://demo.guru99.com/test/simple_context_menu.html");

        String pageTitle= driver.getTitle();

        Assert.assertEquals("Simple Context Menu",pageTitle);

        WebElement doubleClickButton= driver.findElement(By.xpath("//button[@ondblclick='myFunction()']"));

        actions.doubleClick(doubleClickButton).perform();

        Alert alert= driver.switchTo().alert();
        String alertMessage= alert.getText();
        alert.accept();
        Assert.assertTrue(alertMessage.contains("You double clicked me"));
    }
    @Test
    public void mouseSliding() throws InterruptedException {
        driver.navigate().to("http://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider= driver.findElement(By.xpath("//input[@type='range']"));

        actions.clickAndHold(slider).moveByOffset(50,0).perform();

        Thread.sleep(3000);
        actions.clickAndHold(slider).moveByOffset(20,20).perform();
    }

    @Test
    public void hoverOver(){
        driver.navigate().to("http://the-internet.herokuapp.com/hovers");

        WebElement thirdImg= driver.findElement(By.xpath("//h5[.='name: user3']/../preceding-sibling::img"));

        actions.moveToElement(thirdImg).perform();

        WebElement ImgText= driver.findElement(By.xpath("//h5[.='name: user3']"));

        boolean actualText= thirdImg.isDisplayed();

        Assert.assertTrue(actualText);
    }

    @Test
    public void dragElement(){

        driver.get("https://www.primefaces.org/showcase/ui/dnd/draggable.xhtml?jfwid=9eb68");

        WebElement draggableElement= driver.findElement(By.id("pnl_header"));
        WebElement destination = driver.findElement(By.xpath("//div[@class='content-section introduction']"));

        actions.dragAndDrop(draggableElement,destination).perform();

    }
    @Test
    public void dragByElement(){

        driver.get("https://www.primefaces.org/showcase/ui/dnd/draggable.xhtml?jfwid=9eb68");

        WebElement draggableElement= driver.findElement(By.id("pnl_header"));

        actions.dragAndDropBy(draggableElement,600,0).perform();
    }
}
