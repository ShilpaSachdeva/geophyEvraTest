package com.geophy.evra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LogoutPage extends BasePage {


    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Logout')]")
    public WebElement logoutHeaderLink;

    private LoginPage loginPage;

    public LogoutPage(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    public void clickOnLogoutButton() {
        logoutHeaderLink.click();
    }

    public void verifyUserIsLoggedOut() {
        Assert.assertTrue(loginPage.loginHeaderLink.isDisplayed());
    }
}
