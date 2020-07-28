package stepDefinitions;

import base.BaseUtil;
import com.geophy.evra.pages.FooterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FooterSteps extends BaseUtil {

    private  BaseUtil base;
    private FooterPage footerPage;

    public FooterSteps(BaseUtil base)
    {
        this.base = base;
        footerPage = new FooterPage(base.driver);
    }

    @Given("User navigates to home page")
    public void user_navigates_to_home_page() {
        footerPage.navigateToHomePage();
    }

    @When("User clicks on linkedin icon in footer")
    public void userClicksOnLinkedinIconInFooter() {
        footerPage.clickOnLinkedinIconInFooter();
    }

    @When("User clicks on twitter icon in footer")
    public void userClicksOnTwitterIconInFooter() {
        footerPage.clickOnTwitterIconInFooter();
    }

    @When("User clicks on Geophy icon in footer")
    public void userClicksOnGeophyIconInFooter() {
        footerPage.clickOnGeophyIconInFooter();
        
    }

    @When("User clicks on terms and conditions link in footer")
    public void userClicksOnTermsAndConditionsLinkInFooter() {
        footerPage.clickOnTermsAndConditionsLinkInFooter();
        
    }


    @Then("user is navigated to page {string}")
    public void userIsNavigatedToPage(String linkName) throws InterruptedException {

        footerPage.verifyTabOpensDisplayPage(linkName);

    }
}
