package com.OpenCart.StepDefinition;

import com.OpenCart.base.Browser;
import com.OpenCart.locators.Locator;
import com.OpenCart.pages.Home;
import com.OpenCart.pages.Login;
import com.OpenCart.pages.MenuBar;
import com.OpenCart.pages.ResultPage;
import com.OpenCart.pages.Search;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BrowseProduct{
	@Given("open browser and enter the url")
	public void open_browser_and_enter_the_url() {
		Browser.setDriver();
		Browser.getUrl(Locator.getPropertyData("url"));
	}

	@When("click on Login in My Account")
	public void click_on_Login_in_My_Account() {
		Home.clickMyAccount();
	}

	@When("user enters {string} and {string}")
	public void user_enters_and(String email, String password) {
		Login.loginData(email, password);
	}

	@When("user clicks login button")
	public void user_clicks_login_button() {
		Login.loginButton();

	}

	@And("close the browser")
	public void close_the_browser() {
		Browser.closeBrowser();
	}

	@And("navigate to home page")
	public void navigate_to_home_page() {
	    Home.clickAppLogo();
	}


	@When("user enters the product name in search field")
	public void user_enters_the_product_name_in_search_field() {
		Search.searchData(8, 3,2);
	}

	@And("clicks on search icon")
	public void clicks_on_search_icon() {
	    Search.searchButton();
	}

	@Then("verify search field shows relevant result page.")                 
	public void verify_search_field_shows_relevant_product_page() {
	    Search.verifySearchResultPage();
	}

	@When("user enters the wrong data in search field")
	public void user_enters_the_wrong_data_in_search_field() {
	    Search.searchData(21, 3,0);
	}

	@Then("verify error message is displayed with invalid product")
	public void verify_error_message_is_displayed_with_invalid_product() {
	    Search.verfiyErrorMessage(23, 3,0);
	}

	@When("user clicks on a product category")
	public void user_clicks_on_a_product_category() {
		MenuBar.category(31,3,0);
	}

	@And("clicks on the sub-category")
	public void clicks_on_the_sub_category() {
		MenuBar.subCategory(32,3,0);
	}

	@Then("verify user is navigated to result page")      
	public void verify_user_is_navigated_to_result_page() {
		MenuBar.verifyNavigatedResultPage();
	}

	@When("user clicks on Sort by dropdown and choose an option")  
	public void user_clicks_on_Sort_by_dropdown() {
	    ResultPage.sort(35, 3,0);
	}

	@Then("verify result page is sorted according to option") 
	public void verify_result_page_is_sorted_according_to_option() {
	    ResultPage.verifyPageSorted();
	}

	@When("user clicks on add to wishlist button")  
	public void user_clicks_on_add_to_wishlist_button() {
	    ResultPage.wishlist(47 ,3,0);
	}

	@Then("verify product is added to wishlist") 
	public void verify_product_is_added_to_wishlist() {
		ResultPage.verifyWishlist();      
	}

	@When("user clicks on add to compare button") 
	public void user_clicks_on_add_to_compare_button() {
		ResultPage.compareProduct(49 ,3,0);
	}

	@Then("verify product is added for comparison") 
	public void verify_product_is_added_for_comparison() {
		ResultPage.verifyaddToCompare(); 
	}

	@When("user clicks on a product")                
	public void user_clicks_on_a_product() {
		ResultPage.clickProduct();
	}

	@Then("verify user is navigated to product description page") 
	public void verify_user_is_navigated_to_product_description_page() {
		//ResultPage.verifyProductPage();
	}

	@And("scroll to bottom") 
	public void scroll_to_bottom() {
		ResultPage.scrollBottom();
	}

	@Then("verify number of search records displayed")     
	public void verify_number_of_search_records_displayed() {
	    ResultPage.verifyRecords();
	}
}
