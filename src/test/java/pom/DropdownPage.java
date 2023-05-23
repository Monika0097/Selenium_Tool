package pom;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage
{
    private static WebDriver driver;

    public DropdownPage(WebDriver d)
    {
        driver = d;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "(//*[@id=\"item-8\"])[2]")
    private WebElement selectMenu;
    @FindBy(xpath = "(//div[@class=' css-tlfecz-indicatorContainer'])[1]")
    private WebElement selectValueDropdown;
    @FindBy(xpath = "(//div[@class=' css-tlfecz-indicatorContainer'])[2]")
    private WebElement selectOneDropdown;
    @FindBy(xpath = "(//div[@class=' css-tlfecz-indicatorContainer'])[3]")
    private WebElement multiSelectDropdown;
    @FindBy(xpath = "//select[@id='oldSelectMenu']")
    private  WebElement oldStypeDropdown;
//Group 1, option 1
    public void clickSelectMenu()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", selectMenu);
        selectMenu.click();;
        Assert.assertTrue(selectMenu.isDisplayed());
    }
    public void handleDropdownByValue(String option) throws InterruptedException {
        Assert.assertTrue(selectValueDropdown.isDisplayed());
        selectValueDropdown.click();
        Select select=new Select(selectValueDropdown);
        select.selectByVisibleText(option);
        Thread.sleep(2000);
    }
    public void handleDropDown(int index) throws InterruptedException {
        Assert.assertTrue(selectOneDropdown.isDisplayed());
        selectOneDropdown.click();
        Select select=new Select(selectOneDropdown);
        select.selectByIndex(index);
        Thread.sleep(2000);
    }
    public void handliOldStyleDropdown(String name) throws InterruptedException {
        Assert.assertTrue(oldStypeDropdown.isDisplayed());
        oldStypeDropdown.click();
        Select select=new Select(oldStypeDropdown);
        select.selectByVisibleText(name);
        Thread.sleep(2000);

    }


}
