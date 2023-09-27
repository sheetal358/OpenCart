package com.OpenCart.StepDefinition;

import com.OpenCart.pages.Home;

import io.cucumber.java.en.*;

public class HomePage {

	@When("verify slider option is working fine for hero image")
	public void verify_slider_option_is_working_fine_for_hero_image() {
		Home.checkHeroImageSlider();
	}

	@Then("clicking on hero image")
	public void clicking_on_hero_image() {
		Home.clickHeroImage();
	}

	@Then("takes user to respective product page")
	public void takes_user_to_respective_product_page() {
		Home.clickHeroImageProductPage();
	}

	@Then("verify all links in footer section is working properly")
	public void verify_all_links_in_footer_section_is_working_properly() {
		// Write code here that turns the phrase above into concrete actions
		Home.checkFooterLinks();
	}

	@When("clicks on home icon")
	public void clicks_on_home_icon() {
		Home.clickHomeIcon();
	}

	@Then("verify all links in header section is working properly")
	public void verify_all_links_in_header_section_is_working_properly() {
		Home.checkHeaderLinks();
	}

	@And("clicks on application logo")
	public void clicks_on_application_logo() {
		Home.clickAppLogo();
	}

	@Then("user should be directed to home page")
	public void user_should_be_directed_to_home_page() {
		Home.navigationToHomePage();
	}

//--------------------------------------------
	@When("scroll downs to the partner section")
	public void scroll_downs_to_the_partner_section() {
		Home.goToPartnerSection();
	}

	@Then("verify slider option is working fine for partner section")
	public void verify_slider_option_is_working_fine_for_partner_section() {
		Home.checkPartnerSectionImageSlider();
	}

	@Then("user goes to wishlist page")
	public void user_goes_to_wishlist_page() {
		Home.goToWishlistSection();
	}

	@Then("user goes to footer section")
	public void user_goes_to_footer_section() {
		Home.goToFooterSection();
	}

	@Then("user goes to featured section")
	public void user_goes_to_featured_section() {
		Home.goToFeaturedSection();
	}

	@Then("verify four featured product is displayed on home page")
	public void verify_four_featured_product_is_displayed_on_home_page() {
		Home.verifyTotalFeaturedProduct();
	}

	@Then("check hero image is displayed")
	public void check_hero_image_is_displayed() {
		Home.checkHeroImage();
	}

}
