package com.geophy.evra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class HistoryPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'History')]")
    public WebElement historyHeaderLink;

    @FindBy(how = How.ID, using = "search")
    public WebElement searchHistoryTextBox;

    @FindBy(how = How.XPATH, using = "//a[contains(@href,'https://evra.geophy.com/report/')]")
    public List<WebElement> reportLinks;


    private LoginPage loginPage;

    public HistoryPage(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    public void userIsLoggedInApplicationWithEmailAndPassword(String email, String password) {
        loginPage.navigateToLoginPage();
        loginPage.enterEmailAndPassword(email, password);
        loginPage.clickOnLoginButton();
    }

    public void navigateToHistoryPage() {
        historyHeaderLink.click();
    }

    public void userOpenSavedReport(String address) {
        searchHistoryTextBox.click();
        String addressFormatted1 = address.replace(".", "").substring(0, 13);
        searchHistoryTextBox.sendKeys(addressFormatted1);
    }

    public void verifySavedReportInHistorySection(String address) {
        try {
            List<String> reportAddresses = new ArrayList<>();

            for (WebElement report : reportLinks) {
                String addressReport = report.getText().toLowerCase().replace(",", "");
                reportAddresses.add(addressReport);
            }
            String addressFormatted = address.toLowerCase().replace(".", "").replace(",", "");
            Assert.assertTrue(reportAddresses.stream().allMatch(x -> x.contains(addressFormatted)));
        } catch (Exception e) {
            System.out.println(e.getCause());
        }

    }
}
