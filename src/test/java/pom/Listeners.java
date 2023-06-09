package pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseTest implements ITestListener
	{
	ExtentTest test;
	ExtentReports extent = ExtentReportNG.getReport();
		@Override
	public void onTestStart(ITestResult result) 
	{
	test =extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
	  test.log(Status.PASS,result.getMethod().getMethodName()+ " : TEST PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		 test.log(Status.FAIL,result.getMethod().getMethodName()+ " : TEST FAILED");
		 test.fail(result.getThrowable());
		 
		 try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e)
		 {
					e.printStackTrace();
		}
		 String filePath = null;
		 try {
			filePath = getScreenShot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) 
	{
	extent.flush();
	}

}
