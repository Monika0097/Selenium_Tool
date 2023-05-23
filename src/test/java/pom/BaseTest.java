package pom;


import java.io.*;
import java.util.Properties;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.openqa.selenium.io.FileHandler.copy;

public class BaseTest {
    public static WebDriver driver;
    public static String propertiesFilePath= "C:\\Users\\monika bilung\\OneDrive\\Desktop\\Selenium Tool\\testData.properties";

    public static void launchBrowser()
    {
        System.setProperty("webdriver.chrome.driver","C:/Users/monika bilung/Downloads/chromedriver_win32 (4)/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        System.out.println("Chrome Browser is launched");

    }
    @BeforeMethod
    public static WebDriver launchApplication() throws IOException, IOException {
        launchBrowser();
        // retrieving the url from .properties file
        FileInputStream fis = new FileInputStream(propertiesFilePath);
        Properties props=new Properties();
        props.load(fis);
        String  urlPath = props.getProperty("url");
        String websiteUrlPath = props.getProperty("websiteURL");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(urlPath);

        Reporter.log("Application DEMO-QA is launched");
       String expectedURL = "https://demoqa.com/";

        System.out.println("The URL of appliction is  :  "+driver.getCurrentUrl());
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL);
        Reporter.log("URL "+" urlPath"+" is varified successfully" );
        return driver;

    }
    public static String getScreenShot(String testCaseName, WebDriver driver) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination =new File( "C:/Users/monika bilung/OneDrive/Desktop/Selenium Tool/FailedTestScreenshots/" + System.currentTimeMillis()+testCaseName+ ".png");
        copy(source, destination);
        return System.getProperty("user.dir") + "//Reports//" + testCaseName+ ".png";
    }

    @AfterMethod
    public void tear()
    {
        driver.quit();
    }

}
