package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class ElementsPage {

    public static WebDriver driver;
    public ElementsPage(WebDriver d)  {
        driver = d;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//span[text()='Text Box']")
    private WebElement textButton;
    @FindBy(xpath="//input[@placeholder='Full Name']")
    private WebElement fullNameTextBox;
    @FindBy(xpath="//input[@id='userEmail']")
    private WebElement userEmailTextBox;
    @FindBy(xpath="//textarea[@id='currentAddress']")
    private WebElement currentAddressTextArea;
    @FindBy(xpath="//textarea[@id='permanentAddress']")
    private WebElement permanentAddressTextArea;
    @FindBy(xpath="//button[@id='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@class='border col-md-12 col-sm-12']")
    private WebElement enterdDataSection;
    @FindBy(xpath = "//p[@class='mb-1']")
    private List<WebElement> retieveEnteredData;

    @FindBy(xpath="//span[text()='Check Box']")
    private WebElement checkBoxButton;
    @FindBy(xpath="(//button[@title='Toggle'])[1]")
    private WebElement arrowButton;
    @FindBy(xpath="//span[@class='rct-checkbox']")
    private WebElement homeCheckBox;
    @FindBy(xpath="//div[@id='result']")
    private WebElement checkboxSelectedMSG;

    @FindBy(xpath="//span[text()='Radio Button']")
    private WebElement radioButton;
    @FindBy(xpath="//label[@for='yesRadio']")
    private WebElement yesRadioButton;
    @FindBy(xpath="//label[@for='impressiveRadio']")
    private WebElement impressiveRadioButton;
    @FindBy(xpath="//label[@for='noRadio']")
    private WebElement noRadioButton;
    @FindBy(xpath="//p[text()='You have selected ']")
    private WebElement radioButtonSelectedMSG;
    @FindBy(xpath="//span[@class='text-success']")
    private WebElement nameOfRadioButtonSelected;

    @FindBy(xpath="//span[text()='Web Tables']")
    private WebElement webTableButton;
    @FindBy(xpath="//div[@class='web-tables-wrapper']")
    private WebElement table;
    @FindBy(xpath="	//input[@id='searchBox']")
    private WebElement tableSearchBox;
    @FindBy(xpath="//span[@id='edit-record-1']")
    private WebElement editIcon;
    @FindBy(xpath="//span[@id='delete-record-1']")
    private WebElement deleteIcon;
    @FindBy(xpath="//div[@id='registration-form-modal']")
    private WebElement registrationForm;
    @FindBy(xpath="//span[text()='×']")
    private WebElement closeCrossIcon;

    @FindBy(xpath="//span[text()='Buttons']")
    private WebElement buttonsButton;
    @FindBy(xpath="//button[text()='Double Click Me']")
    private WebElement doubleClickButton;
    @FindBy(xpath="//p[text()='You have done a double click']")
    private WebElement doubleClickConfiramtion;
    @FindBy(xpath="//button[text()='Right Click Me']")
    private WebElement rightClickButton;
    @FindBy(xpath="//p[text()='You have done a right click']")
    private WebElement rightClickConfirmation;
    @FindBy(xpath="//button[text()='Click Me']")
    private WebElement clickButton;
    @FindBy(xpath="//p[text()='You have done a dynamic click']")
    private WebElement clickConfirmation;

    @FindBy(xpath="//span[text()='Links']")
    private WebElement linksButton;
    @FindBy(linkText="Home")
    private WebElement homeLink;
    @FindBy(xpath="//a[@id='dynamicLink']")
    private WebElement homeRuweeLink;
    @FindBy(xpath="//a[@id='created']")
    private WebElement createdLink;
    @FindBy(xpath="//a[@id='unauthorized']")
    private WebElement unauthorizedLink;
    @FindBy(xpath="//p[@id='linkResponse']")
    private WebElement badLinksresponse;

    @FindBy(xpath="//span[text()='Broken Links - Images']")
    private WebElement brokenLinksImagesButton;

    @FindBy(xpath="//span[text()='Upload and Download']")
    private WebElement uploadDownloadButton;
    @FindBy(xpath="//a[@id='downloadButton']")
    private WebElement downloadButton;
    @FindBy(xpath="//input[@id='uploadFile']")
    private WebElement uploadButton;

    @FindBy(xpath="//span[text()='Dynamic Properties']")
    private WebElement dynamicPropertiesButton;

    public void textBoxActivity(String fullName, String email, String curAddress , String perAddress) throws InterruptedException
    {
        Assert.assertTrue(textButton.isDisplayed());
        System.out.println("Text Button is displayed");
        textButton.click();
        Thread.sleep(2000);
        fullNameTextBox.sendKeys(fullName);
        Thread.sleep(2000);
        System.out.println("Full Name is entered :"+ fullNameTextBox.getText());
        userEmailTextBox.sendKeys(email);
        Thread.sleep(2000);
        System.out.println("User Email is entered :"+ userEmailTextBox.getText());
        currentAddressTextArea.sendKeys(curAddress);
        Thread.sleep(2000);
        System.out.println("Current Address is entered :"+currentAddressTextArea.getText());
        permanentAddressTextArea.sendKeys(perAddress);
        Thread.sleep(2000);
        System.out.println("Permanent Address is entered as :"+ permanentAddressTextArea.getText());
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",submitButton);
        submitButton.click();
        System.out.println("Submit button is clicked");
        Assert.assertTrue(enterdDataSection.isDisplayed());
        List<WebElement> enterdInputs = retieveEnteredData;
        for(WebElement input:enterdInputs)
        {
            String value = input.getAttribute("id");
            System.out.println(value);
            Thread.sleep(2000);
        }

        System.out.println("Text Box Activity is completed");
        Thread.sleep(2000);
    }
    public void handlingCheckBox() throws InterruptedException
    {
        checkBoxButton.click();
        System.out.println("Check Box button is clicked");
        Thread.sleep(1000);
        arrowButton.click();
        homeCheckBox.click();
        Assert.assertTrue(checkboxSelectedMSG.isDisplayed());
        System.out.println("CheckBox is selected");
        System.out.println("Confirmation message is displayed ; "+ checkboxSelectedMSG.getText());
        Thread.sleep(2000);

    }
    public void handlingRadioButton() throws InterruptedException
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",radioButton);
        radioButton.click();
        Thread.sleep(1000);
        System.out.println("Radio Button section is clicked");
        Assert.assertTrue(yesRadioButton.isEnabled());
        yesRadioButton.click();
        System.out.println("Yes Radio Button is clicked and message is displayed as : "+radioButtonSelectedMSG.getText()+" ; "+ nameOfRadioButtonSelected.getText() );
        Thread.sleep(1000);

        Assert.assertTrue(impressiveRadioButton.isEnabled());
        impressiveRadioButton.click();
        System.out.println("Impressive Radio Button is clicked and message is displayed as : "+radioButtonSelectedMSG.getText()+" ; "+ nameOfRadioButtonSelected.getText() );
        Thread.sleep(1000);

        noRadioButton.click();
        Assert.assertFalse(noRadioButton.isSelected());
        System.out.println("No Radio Button can not be clicked as it is disabled " );
        Thread.sleep(1000);

    }
    public void handlingWebtable(String searchname ) throws InterruptedException
    {

        webTableButton.click();
        System.out.println("Web table section is clicked");
        Thread.sleep(2000);
        Assert.assertTrue(table.isDisplayed());
        tableSearchBox.click();
        tableSearchBox.sendKeys(searchname);
        System.out.println("Seach box is clicked and enterd the name : "+ searchname);
        editIcon.click();
        System.out.println("Clicked on Edit icon");
        Thread.sleep(2000);
        Assert.assertTrue(registrationForm.isDisplayed());
        closeCrossIcon.click();
        System.out.println("Closed the edit form");

        deleteIcon.click();
        System.out.println("Deleted the person with name :"+ searchname);
        Thread.sleep(2000);

    }
    public void handlingButton() throws InterruptedException
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",buttonsButton);
        buttonsButton.click();
        Thread.sleep(2000);
        System.out.println("Button section is clicked");
        Assert.assertTrue(doubleClickButton.isDisplayed());
        Actions act = new Actions(driver);
        act.doubleClick(doubleClickButton).build().perform();
        Thread.sleep(2000);
        System.out.println(doubleClickConfiramtion.getText());
        act.moveToElement(rightClickButton).contextClick().build().perform();
        Thread.sleep(2000);
        System.out.println(rightClickConfirmation.getText());
        act.moveToElement(clickButton).click().build().perform();
        Thread.sleep(2000);
        System.out.println(clickConfirmation.getText());

    }
    public void handlingLinks() throws InterruptedException
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        linksButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(homeLink.isDisplayed());
        Assert.assertTrue(homeRuweeLink.isDisplayed());
        createdLink.click();
        System.out.println("Clicked on created Link");
        System.out.println("Response received as : "+ badLinksresponse.getText());
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView();",unauthorizedLink);
        unauthorizedLink.click();
        System.out.println("Clicked on Unauthorized Link");
        System.out.println("Response received as : "+ badLinksresponse.getText());
        Thread.sleep(2000);
    }
}
