package pom;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.IOException;

public class ExtentListener extends BaseTest implements ITestListener{

    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports report;
    public static ExtentTest test;

    public static ExtentReports  configuration()
    {
        htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/Report-Output/Reports.html");
        report= new ExtentReports();
        report.attachReporter(htmlReporter);

        //configure system configuration;
        report.setSystemInfo("Machine","Acer");
        report.setSystemInfo("OS","Window 10");
        report.setSystemInfo("Browser","Chrome");
        report.setSystemInfo("Host","QA");
        report.setSystemInfo("Tester","Monika");

        //Configuration for report look and feel
        htmlReporter.config().setDocumentTitle("Automation Extent Report");
        htmlReporter.config().setReportName("Automation Test Report");
        htmlReporter.config().setTheme(Theme.DARK);
        return report;
    }
    @Override
    public void onTestStart(ITestResult result)
    {
        configuration();
        Reporter.log(result.getMethod().getMethodName()+" Started");

    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        Reporter.log(result.getMethod().getMethodName()+" Successfully Executed");
        test = report.createTest(result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("Name Of Passed Test Case : "+ result.getName(), ExtentColor.GREEN));

    }

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result)
    {
        Reporter.log(result.getMethod().getMethodName()+"Failed");
        //test.fail(result.getThrowable());
        test = report.createTest(result.getName());
        test.log(Status.FAIL, MarkupHelper.createLabel("Name Of Failed Test Case : "+ result.getName(), ExtentColor.RED));
        try {
            driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());

          String  filePath = BaseTest.getScreenShot(result.getMethod().getMethodName(),driver);

        test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());


    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        Reporter.log(result.getMethod().getMethodName()+" Skipped");
        test = report.createTest(result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel("Name Of Skipped Test Case : "+ result.getName(), ExtentColor.ORANGE));


    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result)
    {
        Reporter.log(result.getMethod().getMethodName()+"Failed");
    }

    @Override
    public void onStart(ITestContext context) {

        Reporter.log("Execution Started");

    }

    @Override
    public void onFinish(ITestContext context)
    {
        Reporter.log("Execution Started");
        report.flush();
    }
}
