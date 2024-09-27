package com.automation.tests;

import com.automation.utils.AllureReportManager;
import com.automation.utils.ConfigReader;
import io.qameta.allure.Allure;
import io.qameta.allure.testng.AllureTestNg;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends BaseTest{

    @Test
    public void verifyUserCanLoginWithValidCredentials() {

        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));
        Assert.assertFalse(homePage.isHomePageDisplayed(), "home page have some issues");
//        AllureReportManager.attachScreenshot();
    }

    @Test
    public void verifyUserCanLogout(){

        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed(), "home page have some issues");
        homePage.burgerMenuIconClick();
        homePage.logOutLink();
//        AllureReportManager.attachScreenshot();
        Assert.assertTrue(loginPage.isLoginPageDisplayed(),"Login page has some issue");


    }
}
