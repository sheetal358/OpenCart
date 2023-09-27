package com.OpenCart.StepDefinition;

import com.OpenCart.pages.ResultPage;
import com.OpenCart.pages.Search;
import io.cucumber.java.en.*;

public class SearchDef {
	@When("user enters a valid product in searchbar")
	public void user_enters_a_valid_product_in_searchbar() {
		Search.searchData(1, 3, 2);
	}

	@And("click on search icon")
	public void click_on_search_icon() {
		Search.searchButton();
	}

	@Then("valid product should be present in search result page")
	public void valid_product_should_be_present_in_search_result_page() {
		Search.verifySearchResultPage();
	}

	@When("user enters a invalid product in searchbar")
	public void user_enters_a_invalid_product_in_searchbar() {
		Search.searchData(5, 3, 2);
	}

	@Then("a message should be visible on screen with shopping cart as empty")
	public void a_message_should_be_visible_on_screen_with_shopping_cart_as_empty() {
		Search.verfiyErrorMessage(7, 3, 2);
	}

	@When("user clicks on sortby option to sort the product")
	public void user_clicks_on_sortby_option_to_sort_the_product() {
		ResultPage.sort(11, 3, 2);
	}

	@Then("search result page should be sorted accordingly")
	public void search_result_page_should_be_sorted_accordingly() {
		ResultPage.verifyPageSorted();
	}

	@When("copy the product description")
	public void copy_the_product_description() {
		Search.productDescription();
	}

	@When("user enters product description in search option")
	public void user_enters_product_description_in_search_option() {
		Search.enterDescInSearchbox();
	}

	@Then("same product should be present in search result page")
	public void same_product_should_be_present_in_search_result_page() {
		Search.checkProductdescAndProductMatch(14, 3, 2);
	}

	@When("user selects a {string}")
	public void user_selects_a(String string) {
		Search.selectCategory(string);
	}

	@Then("user goes to the search result page")
	public void user_goes_to_the_search_result_page() {
		Search.goToResultPage();
	}
}