package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pom.BaseTest;
import pom.ElementsPage;
import pom.ExcelHandler;
import pom.HomePage;

import java.io.IOException;

public class ElementsTest extends BaseTest {
//       public static WebDriver driver;

     String excel =System.getProperty("user.dir")+"Excel-Data/Selenium Test Data.xlsx";
//     String fullName = readExcelData(excel, "Sheet1", 1, 0);
//     String emailID = readExcelData(excel, "Sheet1", 1, 1);
//     String currentAddress = readExcelData(excel, "Sheet1", 1, 2);
//     String permanentAddress = readExcelData(excel, "Sheet1", 1, 3);
//     String tableSearch = readExcelData(excel, "Sheet1", 1, 4);
  public static String fullName = "Lucy Stan";
  public static String emailID="lucy@gmail.com";
    public static String currentAddress =" California, West Lane, House#021";
    public static String permanentAddress =" California, West Lane, House#021";
    String tableSearch ="Cierra";
        @Test
    public void testElements() throws Exception{
        HomePage home = new HomePage(driver);
        home.clickElement();
        ElementsPage element = new ElementsPage(driver);
        element.textBoxActivity(fullName,emailID,currentAddress,permanentAddress);
        element.handlingCheckBox();
        element.handlingRadioButton();
        element.handlingWebtable(tableSearch);
        element.handlingButton();
        element.handlingLinks();
        home.backToHome();

    }
}
