package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AlertWindowsPage {
    public static WebDriver driver;
    public AlertWindowsPage(WebDriver d) {
        driver = d;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[3]/span/div")
    private WebElement alertFrameWindowSection;
    @FindBy(xpath="(//*[@id=\"item-1\"])[2]")
    private WebElement alertSection;
    @FindBy(xpath="//button[@id='alertButton']")
    private WebElement simpleAlert;
    @FindBy(xpath="//button[@id='confirmButton']")
    private WebElement confirmationAlert;
    @FindBy(xpath="//button[@id='promtButton']")
    private WebElement promptAlert;

    @FindBy(xpath="(//li[@id='item-0'])[3]")
    private WebElement windowSection;
    @FindBy(xpath="//button[@id='tabButton']")
    private WebElement newTabButton;
    @FindBy(xpath=" //button[@id='windowButton']")
    private WebElement newWindowButton;
    @FindBy(xpath=" //button[@id='messageWindowButton']")
    private WebElement windowMessageButton;
    public void handlingAlert(String alertText) throws InterruptedException
    {
        Assert.assertTrue(alertFrameWindowSection.isDisplayed());
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Assert.assertTrue(alertSection.isDisplayed());
        alertSection.click();

        simpleAlert.click();
        System.out.println("Generated Simple alert => "+ driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        System.out.println("Clicked on simple alert and accepted it");

        confirmationAlert.click();
        System.out.println("Generated Confirmation alert => "+ driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
        System.out.println("Clicked on confirmation alert and dismissed it");

        promptAlert.click();
//        Thread.sleep(2000);
        Alert alert= driver.switchTo().alert();
        alert.sendKeys(alertText);
        alert.accept();
//        driver.switchTo().alert().sendKeys(alertText);
//        driver.switchTo().alert().accept();
        System.out.println("Clicked on promt alert ");
        System.out.println("Sent input :"+alertText);
        System.out.println("and clicked on OK");
        Thread.sleep(4000);
    }
    public void handlingWindows() throws InterruptedException
    {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Assert.assertTrue(windowSection.isDisplayed());
        windowSection.click();
        Thread.sleep(2000);
        String parentWindow= driver.getWindowHandle();
        newTabButton.click();
        WebDriver newTab= driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(3000);
        System.out.println("Clicked on new tab ");
        System.out.println("The URL of new tab is "+ newTab.getCurrentUrl());
        driver.switchTo().window(parentWindow);
        Thread.sleep(3000);
        Assert.assertTrue(newWindowButton.isDisplayed());
        newWindowButton.click();
        WebDriver newWindow= driver.switchTo().newWindow(WindowType.WINDOW);
        Thread.sleep(3000);
        System.out.println("Clicked on new Window button");
        System.out.println("URL of new Window is => "+ newWindow.getCurrentUrl());
        newWindow.close();
        System.out.println("Closed new window");
        driver.switchTo().window(parentWindow);
        Thread.sleep(5000);
        Assert.assertTrue(windowMessageButton.isDisplayed());
        windowMessageButton.click();


        WebDriver winMessage= driver.switchTo().newWindow(WindowType.WINDOW);
        Thread.sleep(3000);
        WebElement winText = winMessage.findElement(By.xpath("/html/body"));
        System.out.println("Message displayed on new window is :  "+ winText.getText());
        winMessage.close();
        driver.switchTo().window(parentWindow);
        Thread.sleep(2000);
    }

}
