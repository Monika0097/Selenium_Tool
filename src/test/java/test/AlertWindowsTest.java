package test;

import org.testng.annotations.Test;
import pom.AlertWindowsPage;
import pom.BaseTest;
import pom.FormsPage;
import pom.HomePage;

public class AlertWindowsTest extends BaseTest
{
    public static String alertText= "Inside Promt Alert";
    @Test(priority =1)
    public  void testAlertWindows() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.clickAlertWindows();
        AlertWindowsPage alertWindow = new AlertWindowsPage(driver);
        alertWindow.handlingAlert("Inside Prompt Alert");
        home.backToHome();
    }
    @Test(priority = 2, dependsOnMethods = {"testAlertWindows"})
    public void testWindow() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.clickAlertWindows();
        AlertWindowsPage window= new AlertWindowsPage(driver);
        window.handlingWindows();
        home.backToHome();

    }

}
