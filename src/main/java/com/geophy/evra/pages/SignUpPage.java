package com.geophy.evra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static utils.commonUtils.emailGenerator;
import static utils.commonUtils.getRandomNumber;

public class SignUpPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//a[text()='Sign up']")
    public WebElement signUpHeaderLink;

    @FindBy(how = How.ID, using = "first-name")
    public WebElement firstNameTextBox;

    @FindBy(how = How.NAME, using = "last_name")
    public WebElement lastNameTextBox;

    @FindBy(how = How.XPATH, using = "//input[@id='company']")
    public WebElement companyTextBox;

    @FindBy(how = How.ID, using = "email")
    public WebElement emailTextBox;

    @FindBy(how = How.ID, using = "password")
    public WebElement passwordTextBox;

    @FindBy(how = How.XPATH, using = "//span[@class='checkmark']")
    public WebElement termsCheckBox;

    @FindBy(how = How.XPATH, using = "//button[text()='Sign up']")
    public WebElement signUpButton;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Thank you for your request')]")
    public WebElement signUpSuccessMessageText;

    @FindBy(how = How.XPATH, using = "//a[text()='Continue']")
    public WebElement continueButtonSignUpSuccess;

    private String emailDefault;


    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToSignUpPage() {
        signUpHeaderLink.click();
    }

    public void enterAllRequiredFieldsInSignUpForm() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(firstNameTextBox.isDisplayed());
        firstNameTextBox.sendKeys("TestFirstName");

        softAssert.assertTrue(lastNameTextBox.isDisplayed());
        lastNameTextBox.sendKeys("TestLastName");

        softAssert.assertTrue(companyTextBox.isDisplayed());
        companyTextBox.sendKeys("TestCompany");

        softAssert.assertTrue(emailTextBox.isDisplayed());
        emailTextBox.sendKeys(enterEmailAddress());

        softAssert.assertTrue(passwordTextBox.isDisplayed());
        passwordTextBox.sendKeys(getRandomNumber(8));

        softAssert.assertTrue(termsCheckBox.isDisplayed());
        termsCheckBox.click();

        softAssert.assertAll();
    }

    public void clickOnSignUpButton() {
        signUpButton.click();
    }

    public void verifyUserIsCreated() {
        Assert.assertTrue(continueButtonSignUpSuccess.isDisplayed());
        Assert.assertTrue(signUpSuccessMessageText.getText().contains("Thank you for your request"));
    }

    public String enterEmailAddress() throws InterruptedException {

        emailDefault = emailGenerator();
        return emailDefault;
    }

    public void enterPassword() {
        passwordTextBox.sendKeys(getRandomNumber(8));
    }
}
