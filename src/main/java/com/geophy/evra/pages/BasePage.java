package com.geophy.evra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.waitUtils;

import java.util.ArrayList;



public class BasePage {
    private static final int TIMEOUT = 20;
    private static final int POLLING = 100;

    public WebDriver driver;
    private WebDriverWait wait;
    private String mainWindowHandle;


    public BasePage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    protected void waitUntilElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitUntilElementIsClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementToDisappear(By locator) {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void backToMainWindow() {
        driver.switchTo().window(mainWindowHandle);
    }

    public void closeCurrentWindow() {
        driver.close();
    }

    public void tabNavigation() throws InterruptedException {

        mainWindowHandle = driver.getWindowHandle();

        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1).toString());
        Thread.sleep(waitUtils.WaitTime.SMALL.getValue());
    }

    public void verifyIsPageNavigated(String pageName) {

        Assert.assertTrue(driver.getCurrentUrl().contains(pageName));
    }

}
