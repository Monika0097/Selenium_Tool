package test;

import org.testng.annotations.Test;
import pom.BaseTest;
import pom.FormsPage;
import pom.HomePage;

public class FormsTest extends BaseTest
{
   public static  String firstName = "Sonia";
    public static  String lastName ="Wheeler";
    public static  String email="sonia@gmail.com";
    public static String gender="Female";
    public static String number= "9008562741";
    public static  String subject = " Mathematics";
    public static  String hobby="Music";
    public static String currentAdd="Rourkela, Odisha";
    @Test
    public void testForms() throws InterruptedException
    {
        HomePage home = new HomePage(driver);
        home.clickForms();
        FormsPage form = new FormsPage(driver);
        form.handlingForms(firstName,lastName,email,gender,number,subject,hobby,currentAdd);
        home.backToHome();
    }

}
