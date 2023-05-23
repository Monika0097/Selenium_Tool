package test;

import org.testng.annotations.Test;
import pom.AutoSuggestionPage;
import pom.BaseTest;
import pom.HomePage;

public class AutoSuggestionTest extends BaseTest {
    public static String color="Bl";
    public static String col1="Pi";
    public  static  String col2="Gre";
    public  static  String col3="Bl";
    @Test
    public void testAutoSuggestion() throws InterruptedException {
        HomePage home=new HomePage(driver);
        home.clickWidgets();
        AutoSuggestionPage auto= new AutoSuggestionPage(driver);
        auto.handleSingleAutoSuggestion(color);
        auto.handleMultiAutoSuggestion(col1,col2,col3);


    }
}
