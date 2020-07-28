package com.geophy.evra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;



public class LoginPage extends BasePage{

    @FindBy(how = How.XPATH, using = "//a[text()='Login']")
    public WebElement loginHeaderLink;

    @FindBy(how = How.XPATH, using = "//button[text()='Log in']")
    public WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'The email field is required')]")
    public WebElement emailErrorMessage;

    @FindBy(how = How.XPATH, using = "//li[contains(text(),'The password field is required')]")
    public WebElement passwordErrorMessage;

    @FindBy(how = How.ID, using = "email")
    public WebElement emailTextBox;

    @FindBy(how = How.NAME, using = "password")
    public WebElement passwordTextBox;

    private SearchPage searchPage;

    public LoginPage(WebDriver driver) {

        super(driver);
        searchPage = new SearchPage(driver);
    }

    public void navigateToLoginPage() {
            loginHeaderLink.click();
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void verifyBlankFieldErrorMessagesAreShown() {
        Assert.assertEquals(emailErrorMessage.getText(),"The email field is required.");
        Assert.assertEquals(passwordErrorMessage.getText(),"The password field is required.");
    }

    public void enterEmailAndPassword(String email, String password) {
        emailTextBox.clear();
        emailTextBox.sendKeys(email);

        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
    }

    public void verifyUserSuccessfullyLoggedIn() {
        Assert.assertEquals((searchPage.welcomeBackHeaderText.getText()),"Welcome back, QA Geophy.");
        Assert.assertTrue(driver.getCurrentUrl().contains("https://evra.geophy.com/search"));
        System.out.println(driver.getCurrentUrl());
    }



}
