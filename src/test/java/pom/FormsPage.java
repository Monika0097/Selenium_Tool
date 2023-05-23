package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class FormsPage {
    public static  WebDriver driver;
    public FormsPage(WebDriver d) {
        driver = d;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//*[@id=\"app\"]/header/a/img")
    private WebElement pageLogo;
    @FindBy(xpath="(//span[@class='group-header'])[2]")
    private WebElement formSection;
    @FindBy(xpath="(//ul[@class='menu-list'])[2]")
    private WebElement practiceForm;
    @FindBy(xpath="//input[@id='firstName']")
    private WebElement firstNameTextBox;

    @FindBy(xpath="//input[@id='lastName']")
    private WebElement lastNameTextBox;

    @FindBy(xpath="//input[@id='userEmail']")
    private WebElement userEmailTextBox;

    @FindBy(xpath="//label[@class='custom-control-label']")
    private List<WebElement> selectRadioButton;

    @FindBy(xpath="//input[@id='userNumber']")
    private WebElement userNumberTextBox;
    @FindBy(xpath="//input[@id='dateOfBirthInput']")
    private WebElement birthDateBox;
    @FindBy(xpath="//div[@class='subjects-auto-complete__control css-yk16xz-control']")
    private WebElement subjectTextBox;
    @FindBy(xpath="//input[@id='uploadPicture']")
    private WebElement uploadPictureButton;
    @FindBy(xpath="//textarea[@id='currentAddress']")
    private WebElement currentAddressTextArea;

    public void handlingForms(String fName, String lName, String email, String gender, String number, String subject, String hobby , String curAdress) throws InterruptedException
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",formSection);
        Assert.assertTrue(formSection.isDisplayed());
       // formSection.click();
        practiceForm.click();
        Thread.sleep(2000);
        firstNameTextBox.sendKeys(fName);
        Thread.sleep(1000);
        lastNameTextBox.sendKeys(lName);
        Thread.sleep(1000);
        userEmailTextBox.sendKeys(email);
        Thread.sleep(1000);

        List<WebElement> radioButtons = selectRadioButton;
        for(WebElement radioButton:radioButtons)
        {
            String genderLabel = radioButton.getText();
            if(genderLabel.equalsIgnoreCase(gender))
            {
                radioButton.click();
            }
        }
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(2000);
        userNumberTextBox.sendKeys(number);
        Thread.sleep(1000);
//		subjectTextBox.sendKeys(subject);
//		Thread.sleep(1000);
        for(WebElement radioButton:radioButtons)
        {
            String hobbyLabel = radioButton.getText();
            if(hobbyLabel.equalsIgnoreCase(hobby))
            {
                radioButton.click();
            }
        }
        currentAddressTextArea.sendKeys(curAdress);
        Thread.sleep(2000);

    }
}
