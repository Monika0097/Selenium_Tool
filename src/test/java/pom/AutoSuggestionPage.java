package pom;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import test.DropdownTest;

import java.util.List;

public class AutoSuggestionPage
{
    private static WebDriver driver;

    public AutoSuggestionPage(WebDriver d)
    {
        driver = d;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//*[@id=\"item-1\"])[3]")
    private WebElement autoComplete;
    @FindBy(xpath = "//div[@class='auto-complete__value-container auto-complete__value-container--is-multi css-1hwfws3']")
    private WebElement multicolorAutoSuggestion;
    @FindBy(xpath = "//div[@class='auto-complete__value-container css-1hwfws3']")
    private WebElement singlecolorAutoSuggestion;

    public void handleMultiAutoSuggestion(String color, String color1, String color2) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", autoComplete);
        autoComplete.click();
        Assert.assertTrue(multicolorAutoSuggestion.isDisplayed());
        multicolorAutoSuggestion.sendKeys(color);
        multicolorAutoSuggestion.sendKeys(color1);
        multicolorAutoSuggestion.sendKeys(color2);
        Thread.sleep(2000);
    }

    public void handleSingleAutoSuggestion(String color) throws InterruptedException
    {
        Assert.assertTrue(singlecolorAutoSuggestion.isDisplayed());
        singlecolorAutoSuggestion.sendKeys(color);
        Thread.sleep(2000);
    }
}










