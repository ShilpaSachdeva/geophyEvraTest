package com.geophy.evra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.waitUtils;

public class SearchPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Search')]")
    public WebElement SearchHeaderLink;

    @FindBy(how = How.ID, using = "address_input")
    public WebElement addressTextBox;

    @FindBy(how = How.CSS, using = "input#noi")
    public WebElement netOperatingIncomeTextBox;

    @FindBy(how = How.CSS, using = "input[name=number_of_units]")
    public WebElement numberOfUnitsTextBox;

    @FindBy(how = How.NAME, using = "year_built")
    public WebElement yearOfConstructionTextBox;

    @FindBy(how = How.NAME, using = "occupancy")
    public WebElement occupancyTextBox;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Run Valuation')]")
    public WebElement runValuationButton;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Welcome back')]")
    public WebElement welcomeBackHeaderText;

    @FindBy(how = How.XPATH, using = "//*[@id='page-content']/div/section[2]/div[2]/div[2]/h4")
    public WebElement headerAddressReport;

    private By byRunningValuationText = By.xpath("//h4[contains(text(),'Running Valuation')]");

    public SearchPage(WebDriver driver) {
        super(driver);

    }

    public void navigateToSearchPage() {
        SearchHeaderLink.click();
    }

    public void userEnterSearchInformation(String address, String netOperatingIncome, String numberOfUnits, String yearOfConstruction, String occupancy) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        addressTextBox.sendKeys(address);
        Thread.sleep(waitUtils.WaitTime.TINY.getValue());
        waitUntilElementIsClickable(addressTextBox);

        addressTextBox.sendKeys(Keys.DOWN);
        Thread.sleep(waitUtils.WaitTime.MEDIUM.getValue());
        addressTextBox.sendKeys(Keys.ENTER);


        netOperatingIncomeTextBox.sendKeys(netOperatingIncome);
        softAssert.assertTrue(netOperatingIncomeTextBox.isDisplayed());

        numberOfUnitsTextBox.sendKeys(numberOfUnits);
        softAssert.assertTrue(numberOfUnitsTextBox.isDisplayed());

        yearOfConstructionTextBox.sendKeys(yearOfConstruction);
        softAssert.assertTrue(yearOfConstructionTextBox.isDisplayed());

        occupancyTextBox.sendKeys(occupancy);
        softAssert.assertTrue(occupancyTextBox.isDisplayed());

        softAssert.assertAll();

    }

    public void clickOnRunValuationButton() throws InterruptedException {
        waitUntilElementIsClickable(runValuationButton);
        Thread.sleep(2000);
        runValuationButton.click();
        Thread.sleep(waitUtils.WaitTime.MEDIUM.getValue());

    }

    public void verifyValuationReport(String address) throws InterruptedException {
        try {
            waitForElementToDisappear(byRunningValuationText);
            String addressFormatted = address.toLowerCase().replace(".", "").replace(",", "");
            Assert.assertTrue(headerAddressReport.getText().toLowerCase().replace(",", "").contains(addressFormatted));
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

}
