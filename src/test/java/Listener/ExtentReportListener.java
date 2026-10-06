package Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportListener implements ITestListener {

    ExtentReports extent;
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {

    	String path = System.getProperty("user.dir")
    	        + "\\test-output\\ExtentReport.html";
        ExtentSparkReporter spark =
                new ExtentSparkReporter(path);

        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("TEST STARTED: "
                + result.getMethod().getMethodName());

       
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("PASS: "
                + result.getMethod().getMethodName());

      //  test.info("Test was passed by venu");
        test.pass("Test Passed Successfully for Listener");
    }
    @Override
    public void onTestFailure(ITestResult result2) {
 
        System.out.println("Fail: "
                + result2.getMethod().getMethodName());

        test.fail("Test failed Successfully for Listener");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

}
