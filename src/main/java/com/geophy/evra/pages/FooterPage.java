package com.geophy.evra.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FooterPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//a[contains(@href,'linkedin')]")
    public WebElement linkedinIconFooter;

    @FindBy(how = How.XPATH, using = "//a[contains(@href,'twitter')]")
    public WebElement twitterIconFooter;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'GEOPHY')]")
    public WebElement geophyIconFooter;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Terms & Conditions')]")
    public WebElement termsAndConditionsFooter;

    private SignUpPage signUpPage;

    public FooterPage(WebDriver driver) {
        super(driver);
        signUpPage = new SignUpPage(driver);
    }

    public void navigateToHomePage() {
        signUpPage.navigateToSignUpPage();
        scrollToEnd();
    }

    public void clickOnLinkedinIconInFooter() {
        linkedinIconFooter.click();
    }

    public void verifyTabOpensDisplayPage(String linkName) throws InterruptedException {

        tabNavigation();
        verifyIsPageNavigated(linkName);
        closeCurrentWindow();
        backToMainWindow();
    }

    public void clickOnTwitterIconInFooter() {

        twitterIconFooter.click();
    }

    public void clickOnGeophyIconInFooter() {
        geophyIconFooter.click();
    }

    public void clickOnTermsAndConditionsLinkInFooter() {
        termsAndConditionsFooter.click();
    }

    public void scrollToEnd() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
