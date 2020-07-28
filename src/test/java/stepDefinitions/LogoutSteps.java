package stepDefinitions;

import base.BaseUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.geophy.evra.pages.LogoutPage;

public class LogoutSteps extends BaseUtil {

    private  BaseUtil base;
    private LogoutPage logoutPage;

    public LogoutSteps(BaseUtil base)
    {
        this.base = base;
        logoutPage = new LogoutPage(base.driver);
    }

    @When("user clicks on logout button")
    public void user_clicks_on_logout_button() {
        logoutPage.clickOnLogoutButton();
    }

    @Then("user is logged out")
    public void userIsLoggedOut() {
        logoutPage.verifyUserIsLoggedOut();
    }
}
