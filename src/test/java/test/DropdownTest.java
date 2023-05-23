package test;

import org.testng.annotations.Test;
import pom.BaseTest;
import pom.AutoSuggestionPage;
import pom.DropdownPage;
import pom.HomePage;

public class DropdownTest extends BaseTest  {
  public static String name= "Magenta";

    @Test
    public void testDropdown() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.clickWidgets();
        DropdownPage drop= new DropdownPage(driver);
        drop.clickSelectMenu();
        drop.handliOldStyleDropdown(name);
    }

}
