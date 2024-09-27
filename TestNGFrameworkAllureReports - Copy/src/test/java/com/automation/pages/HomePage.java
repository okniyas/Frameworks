package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(css = ".product_sort_container")
    WebElement filterDropdown;

    @FindBy(css = ".shopping_cart_link")
    WebElement cartIcon;

    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerMenuIcon;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutLink;

    public boolean isHomePageDisplayed(){

        return filterDropdown.isDisplayed() && cartIcon.isDisplayed();
    }

    public void burgerMenuIconClick(){
        burgerMenuIcon.click();
    }

    public void logOutLink(){
        logoutLink.click();
    }
}
