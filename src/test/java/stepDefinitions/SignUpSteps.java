package stepDefinitions;

import base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.geophy.evra.pages.SignUpPage;

public class SignUpSteps extends BaseUtil {

    private  BaseUtil base;
    private SignUpPage signUpPage;

    public SignUpSteps(BaseUtil base)
    {
        this.base = base;
        signUpPage = new SignUpPage(base.driver);
    }

    @Given("User navigates to sign up page")
    public void user_navigates_to_sign_up_page() {
        signUpPage.navigateToSignUpPage();
    }

    @When("User enter all required fields in Sign Up Form")
    public void userEnterAllRequiredFieldsInSignUpForm() throws InterruptedException {
        signUpPage.enterAllRequiredFieldsInSignUpForm();
    }

    @And("User click on Sign up button")
    public void userClickOnSignUpButton() {
        signUpPage.clickOnSignUpButton();
    }

    @Then("User is created")
    public void userIsCreated() {
        signUpPage.verifyUserIsCreated();
    }
}
