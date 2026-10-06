package Listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener  {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("--------------------------------");
        System.out.println("TEST STARTED: "
                + result.getMethod().getMethodName());
        System.out.println("--------------------------------");
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("PASS: "
                + result.getMethod().getMethodName());
    }

}
