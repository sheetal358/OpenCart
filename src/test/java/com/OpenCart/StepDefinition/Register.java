package com.OpenCart.StepDefinition;

import com.OpenCart.pages.Home;
import com.OpenCart.pages.RegisterPage;

import io.cucumber.java.en.*;

public class Register {
	@When("click on register in My Account")
	public void click_on_register_in_My_Account() {
		Home.clickRegister();
	}

	@When("user enters new account details into mandatory fields")
	public void user_enters_new_account_details_into_mandatory_fields() {
		RegisterPage.addAllData();
		RegisterPage.checklistPrivacyPolicy(true);
	}

	@When("user clicks on continue button")
	public void user_clicks_on_continue_button() {
		RegisterPage.clickContinueButton();
	}

	@Then("click on continue button that is displayed in account success page")
	public void click_on_continue_button_that_is_displayed_in_account_success_page() {
		RegisterPage.clickAccountSuccessContinueButton();
	}

	@When("user enters new account details into all the fields")
	public void user_enters_new_account_details_into_all_the_fields() {
		RegisterPage.addAllData();
	}

	@When("user enter password as {string} into password field and {string} into password confirm field with all other details")
	public void user_enter_password_as_into_password_field_and_into_password_confirm_field_with_all_other_details(
			String password, String confirm_password) {
		RegisterPage.addAllData(password, confirm_password);
	}

	@And("verify password does not match message")
	public void verify_password_does_not_match_message() {
		RegisterPage.verifyPasswordMessage();
	}

	@When("do not select the privacy policy checkbox option")
	public void do_not_select_the_privacy_policy_checkbox_option() {
		RegisterPage.checklistPrivacyPolicy(false);
	}
	
	@And("select the privacy policy checkbox option")
	public void select_the_privacy_policy_checkbox_option() {
		RegisterPage.checklistPrivacyPolicy(true);
	}

	@And("verify privacy policy error message")
	public void verify_privacy_policy_error_message() {
		RegisterPage.verifyPrivacyPolicyMessage();
	}

	@When("user enters existing account details into all the fields\\({string}, {string}, {string}, {string}, {string}, {string})")
	public void user_enters_existing_account_details_into_all_the_fields(String fname, String lname, String email,
			String telephone, String password, String confirmPassword) {
		// Write code here that turns the phrase above into concrete actions
		RegisterPage.addExistingData(fname, lname, email, telephone, password, confirmPassword);
	}

	@Then("verify the url, title, heading of registered page")
	public void verify_the_url_title_heading_of_registered_page() {
		RegisterPage.verifyUI();
	}

	@When("user enters new account details into all the fields and not enter password in confirm password field")
	public void user_enters_new_account_details_into_all_the_fields_and_not_enter_password_in_confirm_password_field() {
		RegisterPage.addAllData("abc123", "");
	}

	@When("user enters new account details into all the fields but with invalid {string} into email field")
	public void user_enters_new_account_details_into_all_the_fields_but_with_invalid_into_email_field(String emailId) {
		RegisterPage.addAllData(emailId);
	}
	
	@Then("check the email address used for registering the account")
	public void check_the_email_address_used_for_registering_the_account() {
	    throw new io.cucumber.java.PendingException();
	}

	@Then("click on the login page link from email body")
	public void click_on_the_login_page_link_from_email_body() {
	    throw new io.cucumber.java.PendingException();
	}

}
