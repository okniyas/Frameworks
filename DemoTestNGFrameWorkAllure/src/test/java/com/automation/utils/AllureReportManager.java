package com.automation.utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class AllureReportManager {

    public static void attachScreenshot(){
        TakesScreenshot takesScreenshot = (TakesScreenshot) DriverManager.getDriver();
        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("screenshot", new ByteArrayInputStream(screenshot));
    }

    public static void attachLog(String message){
        Allure.addAttachment("Log", message);
    }
}
