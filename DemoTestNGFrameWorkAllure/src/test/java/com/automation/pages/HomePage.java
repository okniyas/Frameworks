package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = ".product_sort_container")
    WebElement filterDropdown;

    @FindBy(css = ".shopping_cart_link")
    WebElement cartIcon;

    public boolean verifyUserIsOnHomePage() {

        return filterDropdown.isDisplayed() && cartIcon.isDisplayed();
//        return false;
    }
}
