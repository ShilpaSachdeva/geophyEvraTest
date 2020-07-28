package stepDefinitions;

import base.BaseUtil;
import com.geophy.evra.pages.HistoryPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HistorySteps extends BaseUtil {

    private  BaseUtil base;
    private HistoryPage historyPage;

    public HistorySteps(BaseUtil base) {
        this.base = base;
        historyPage = new HistoryPage(base.driver);
    }

    @Given("User navigates to history page")
    public void user_navigates_to_history_page() {
        historyPage.navigateToHistoryPage();

    }

    @When("User opens a saved report for {string}")
    public void user_opens_a_saved_report_for(String address) {
        historyPage.userOpenSavedReport(address);
    }

    @Then("User will see the saved report for {string}")
    public void user_will_see_the_saved_report_for(String address) {
        historyPage.verifySavedReportInHistorySection(address);
    }

    @Given("User is logged in application with  email {string} and password {string}")
    public void userIsLoggedInApplicationWithEmailAndPassword(String email, String password) {
        historyPage.userIsLoggedInApplicationWithEmailAndPassword(email,password);
    }
}
