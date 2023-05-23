package pom;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class HomePage {
    public static WebDriver driver;

    public HomePage(WebDriver d) {
        driver = d;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/header/a/img")
    private WebElement logo;
    @FindBy(xpath = "//div[@class='card-body']")
    private List<WebElement> elementToBeTested;
    @FindBy(xpath = "//div[@class='category-cards']")
    private WebElement optionsBody;
    @FindBy(xpath = "(//div[@class='card-body'])[1]")
    private WebElement elements;
    @FindBy(xpath = "(//div[@class='card-body'])[2]")
    private WebElement forms;
    @FindBy(xpath = "(//div[@class='card-body'])[3]")
    private WebElement alertWindows;
    @FindBy(xpath = "(//div[@class='card-body'])[4]")
    private  WebElement widgets;

    //        @FindBy(xpath = "")
//    private WebElement logo;
//        @FindBy(xpath = "")
//    private WebElement logo;
    public void verifyLog()
    {
        String title = driver.getTitle();
        Reporter.log("The title of Application is : " + title);
        Assert.assertTrue(logo.isDisplayed());
        System.out.println("Logo is displayed ");
    }
    public void backToHome()
    {
        Assert.assertTrue(logo.isDisplayed());
        logo.click();
        String homeURL = "https://demoqa.com/";
        if(homeURL.equalsIgnoreCase(driver.getCurrentUrl()))
            System.out.println("Navigated to Home page");
    }

    public void verifyElementsToBeTested(String elements) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        List<WebElement> options = elementToBeTested;
        Reporter.log("Printing the value of Elements to be tested");
        for (WebElement option : options) {
            String optionValue = option.getText();
            System.out.println(optionValue);
            Assert.assertTrue(option.isDisplayed());
            Thread.sleep(2000);
        }

    }

    public  void clickElement() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        Assert.assertTrue( elements.isDisplayed());
        elements.click();
        Thread.sleep(2000);
        String elementPageURLexpected="https://demoqa.com/elements";
        String elementPageURLactual= driver.getCurrentUrl();
        if(elementPageURLexpected.equalsIgnoreCase(elementPageURLactual))
        System.out.println("Element option is clicked");
        System.out.println("The URL of Element page is "+elementPageURLactual);
    }
    public void clickForms() throws InterruptedException
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        Assert.assertTrue( elements.isDisplayed());
        forms.click();
        Thread.sleep(2000);
        String formsPageURLexpected="https://demoqa.com/forms";
        String formsPageURLactual= driver.getCurrentUrl();
        if(formsPageURLexpected.equalsIgnoreCase(formsPageURLactual))
            System.out.println("Element option is clicked");
        System.out.println("The URL of Element page is "+formsPageURLactual);
    }
    public void clickAlertWindows() throws InterruptedException
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        Assert.assertTrue( elements.isDisplayed());
        alertWindows.click();
        Thread.sleep(2000);
        String alertWindowsPageURLexpected="https://demoqa.com/alertsWindows";
        String alertWindowsPageURLactual= driver.getCurrentUrl();
        if(alertWindowsPageURLexpected.equalsIgnoreCase(alertWindowsPageURLactual))
            System.out.println("Element option is clicked");
        System.out.println("The URL of Element page is "+alertWindowsPageURLactual);

    }
    public void clickWidgets() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        Assert.assertTrue( widgets.isDisplayed());
        widgets.click();
        Thread.sleep(2000);
        String widgetsPageURLexpected="https://demoqa.com/widgets";
        String widgetsPageURLactual= driver.getCurrentUrl();
        if(widgetsPageURLexpected.equalsIgnoreCase(widgetsPageURLactual))
            System.out.println("Widgets option is clicked");
        System.out.println("The URL of Widgets page is "+widgetsPageURLactual);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}




