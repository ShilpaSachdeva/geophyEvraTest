package stepDefinitions;

import base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.geophy.evra.pages.SearchPage;

public class SearchSteps extends BaseUtil {

    private  BaseUtil base;
    private SearchPage searchPage;

    public SearchSteps(BaseUtil base)
    {
        this.base = base;
        searchPage = new SearchPage(base.driver);
    }

    @Given("User navigates to search page")
    public void user_navigates_to_search_page() {
        searchPage.navigateToSearchPage();
    }

    @When("User enter information {string} , {string} , {string} , {string}, {string}")
    public void user_enter_information(String address, String netOperatingIncome, String numberOfUnits, String yearOfConstruction, String occupancy) throws InterruptedException {
        searchPage.userEnterSearchInformation(address, netOperatingIncome, numberOfUnits, yearOfConstruction, occupancy);
    }

    @And("User clicks on run valuation button")
    public void userClicksOnRunValuationButton() throws InterruptedException {
        searchPage.clickOnRunValuationButton();
    }

    @Then("The valuation report of the chosen property with {string} is shown to the user")
    public void the_valuation_report_of_the_chosen_property_with_is_shown_to_the_user(String address) throws InterruptedException {
        searchPage.verifyValuationReport(address);
    }
}
