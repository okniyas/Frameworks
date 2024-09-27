package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ExtendReportManager {


    private static ExtentReports extentReports;
    private static ExtentTest test;

    public static void initExtendReporter() {
        String reportPath = System.getProperty("user.dir") + "\\reports\\extendReport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);

    }

    public static void flush() {
        extentReports.flush();
    }

    public static void createTest(String name) {
        test = extentReports.createTest(name);
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void attachScreenshot() {
        try {
            test.addScreenCaptureFromPath(takeScreenshot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String takeScreenshot() throws IOException {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File file = ts.getScreenshotAs(OutputType.FILE);
        String filePath = "src/test/resources" + "/screenshot.png";
        FileUtils.copyFile(file, new File(filePath));
        return System.getProperty("user.dir") + "/" + filePath;
    }

}
