package com.automation.listeners;

import com.automation.utils.DriverManager;
import com.automation.utils.ExtendReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtendReportListener implements ITestListener {
    @Override
    public void onFinish(ITestContext context) {
        ExtendReportManager.flush();
    }

    @Override
    public void onStart(ITestContext context) {
        ExtendReportManager.initExtendReporter();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtendReportManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtendReportManager.getTest().pass("Test Passed");
        ExtendReportManager.attachScreenshot();

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtendReportManager.getTest().skip("Test Skipped");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtendReportManager.getTest().fail("Test failed \n"+ result.getThrowable().getMessage());
        ExtendReportManager.attachScreenshot();
    }
}
