package stepDefinitions;

import base.BaseUtil;
import com.geophy.evra.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps extends BaseUtil {

    private  BaseUtil base;
    private LoginPage loginPage;

    public LoginSteps(BaseUtil base)
    {
        this.base = base;
        loginPage = new LoginPage(base.driver);
    }
    
    @Given("User navigates to login page")
    public void userNavigatesToLoginPage() {
        loginPage.navigateToLoginPage();
    }

    @When("User click on login button")
    public void userClickOnLoginButton() {
        loginPage.clickOnLoginButton();
    }

    @Then("Blank field Error messages are shown")
    public void blankFieldErrorMessagesAreShown() {
        loginPage.verifyBlankFieldErrorMessagesAreShown();
        
    }

    @When("User provides email {string} and password {string}")
    public void userProvidesEmailAndPassword(String email, String password) {
        loginPage.enterEmailAndPassword(email,password);
    }

    @Then("User is successfully logged in")
    public void userIsSuccessfullyLoggedIn() {
        loginPage.verifyUserSuccessfullyLoggedIn();
    }
}
