package com.automation.tests;

import com.automation.pages.BasePage;
import com.automation.utils.ConfigReader;
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
    public void verifyUserCanLoginWithValidCredentials(){

        loginPage.openWebsite();
        Assert.assertTrue(loginPage.verifyUserOnLoginPage());
        loginPage.doLogin(ConfigReader.getConfigValue("username"),
                ConfigReader.getConfigValue("password")
        );
        Assert.assertTrue(homePage.verifyUserIsOnHomePage());

    }

    @Test(dataProvider = "InvalidData")
    public void verifyUserCannotLoginWithInValidCredentials(String username, String password){

        loginPage.openWebsite();
        Assert.assertTrue(loginPage.verifyUserOnLoginPage());
        loginPage.doLogin(username, password);
//                ConfigReader.getConfigValue("password")
//        );
        Assert.assertTrue(loginPage.verifyUserOnLoginPage());

    }

    @DataProvider(name = "InvalidData")
    public Object[][] invalidData() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook("src/test/resources/data/credentials.xlsx");
        XSSFSheet sheet = workbook.getSheet("negativeData");
        int rowNumber = sheet.getLastRowNum();
        Object[][] data = new Object[rowNumber][sheet.getRow(1).getLastCellNum()];

        for(int i =1;i<=rowNumber;i++){
            XSSFRow row = sheet.getRow(i);
            for(int j=0; j<row.getLastCellNum();j++){
                XSSFCell cell = row.getCell(j);
                data[i-1][j] = cell.toString();
            }
        }
        return data;
    }
}
