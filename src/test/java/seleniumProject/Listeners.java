package seleniumProject;


import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.SendReport;
import resources.base;
import resources.extentReporterNG;

public class Listeners extends base implements ITestListener {
	
	ExtentReports extent = extentReporterNG.getReportObject();
	ExtentTest test;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(final Object obj) {
        return super.equals(obj);
    }

    @Override
    protected void finalize() throws Throwable {
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void onFinish(final ITestContext context) {
        extent.flush();
        SendReport sendReport = new SendReport();
        sendReport.sendEmail();
    }

    @Override
    public void onStart(final ITestContext context) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(final ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(final ITestResult result) {
    }

    @Override
    public void onTestFailure(final ITestResult result) {
    	test.fail(result.getThrowable());
        final String testName = result.getMethod().getMethodName();
        
		
		try {
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Exception e)
		{
			
		}
		try {
			
			test.addScreenCaptureFromPath(getScreenshot(testName, driver), testName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }			

    @Override
    public void onTestSkipped(final ITestResult result) {
    }

    @Override
    public void onTestStart(final ITestResult result) {
    	test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(final ITestResult result) {
        test.log(Status.PASS,"Test Passed");

    }
    
}