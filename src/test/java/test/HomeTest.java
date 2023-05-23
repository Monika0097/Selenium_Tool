package test;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pom.BaseTest;
import pom.HomePage;

public class HomeTest extends BaseTest
{
    //    public static WebDriver driver;
    @Test
    public void verfiyApplicationLaunch() throws InterruptedException
    {
        HomePage home= new HomePage(driver);
        home.verifyLog();
        home.verifyElementsToBeTested("Elements");
    }
}
