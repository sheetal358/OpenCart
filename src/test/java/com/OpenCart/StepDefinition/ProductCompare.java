package com.OpenCart.StepDefinition;

import com.OpenCart.pages.ProductPage;
import com.OpenCart.pages.ResultPage;
import com.OpenCart.pages.Search;
import io.cucumber.java.en.*;

public class ProductCompare {
	@When("user enters an existing product in searchbar")
	public void user_enters_an_existing_product_in_searchbar() {
		Search.searchData(1, 3, 3);
	}

	@When("user hover the mouse on the compare the product option from product display page")
	public void user_hover_the_mouse_on_the_compare_the_product_option_from_product_display_page() {
		ProductPage.hoverToComparisonButton();
	}

	@And("click on product displayed to search result")
	public void click_on_product_displayed_to_search_result() {
		ResultPage.goToProductPage(1, 3, 3);
	}

	@When("select compare this product option")
	public void select_compare_this_product_option() {
		ProductPage.clickComparisonButton(17, 3, 3);
	}

	@Then("a success message should be displayed")
	public void a_success_message_should_be_displayed() {
		ProductPage.verifySuccessMessage();
	}

	@Then("click on product comparison link")
	public void click_on_product_comparison_link() {
		ProductPage.goToComparisonPage();
	}

	/*@Then("user goes to featured section")
	public void user_goes_to_featured_section() {
		Home.goToFeaturedSection();
	}*/

	@Then("verify title, url, heading")
	public void verify_title_url_heading() {
		ProductPage.verifyUI();
	}

	@When("select compare this product for same product {int} times")
	public void select_compare_this_product_for_same_product_times(Integer int1) {
		ProductPage.clickComparisonButton(int1);
	}

	@Then("verify no duplicate product is present")
	public void verify_no_duplicate_product_is_present() {
		ProductPage.verifyNoDuplicateProductAdded();
	}

	@Then("select compare this product option for {int} product")
	public void select_compare_this_product_option_for_prodcut(Integer int1) {
		ProductPage.selectProductToCompare(int1);
	}

	@Then("verify more than {int} products cannot be added")
	public void verify_more_than_products_cannot_be_added(Integer int1) {
		ProductPage.verifyLimitOfProductsInComparisonPage(int1);
	}

	@Then("go to remove button on comparison page")
	public void go_to_remove_button_on_comparison_page() {
		ProductPage.goToRemoveButton();
	}

	@Then("click remove button")
	public void click_remove_button() {
		ProductPage.clickRemoveButton();
	}

	@Then("verify product is removed from comparison page")
	public void verify_product_is_removed_from_comparison_page() {
		ProductPage.verifyProductRemoved();
	}
	
	@Then("go to add to cart button on comparison page")
	public void go_to_add_to_cart_button_on_comparison_page() {
		ProductPage.goToAddButton();
	}

	@Then("click add to cart button")
	public void click_add_to_cart_button() {
		ProductPage.clickAddButton();
	}

	@Then("verify product is added to cart")
	public void verify_product_is_added_to_cart() {
		ProductPage.verifyProductAddedToCart();
	}
}
