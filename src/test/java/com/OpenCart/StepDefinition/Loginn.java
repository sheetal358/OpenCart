package com.OpenCart.StepDefinition;

import com.OpenCart.pages.Login;
import io.cucumber.java.en.*;

public class Loginn {
	@Then("user sees a error message")
	public void user_sees_a_error_message() {
		Login.errorMessage(22,3,1);
	}

	@Then("verify user is logged in")
	public void verify_user_is_logged_in() {
	    Login.verifylogoutButton();
	}

	@Then("password should be visible in bullet format.")
	public void password_should_be_visible_in_bullet_format() {		Login.passwordField();
	}

	@When("user press enter key.")
	public void user_press_enter_key() {
	    Login.enterButton();
	}

    @And("user clicks on Forgot Password link")
    public void user_clicks_on_Forgot_Password_link() {
	    Login.ForgotPasswordLink(17, 3,1);  //change
	}
    @Then("user should be able to see reset password page")
    public void user_should_be_able_to_see_reset_password_page() {
	    Login.ForgottenPage();
	}
}
