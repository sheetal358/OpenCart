$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/com.OpenCart.Feature/Browses.feature");
formatter.feature({
  "name": "To check the browse functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "For the scenarios in the feature file, user is expected to be on home page",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "open browser and enter the url",
  "keyword": "Given "
});
formatter.match({
  "location": "com.OpenCart.StepDefinition.BrowseProduct.open_browser_and_enter_the_url()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click on Login in My Account",
  "keyword": "When "
});
formatter.match({
  "location": "com.OpenCart.StepDefinition.BrowseProduct.click_on_Login_in_My_Account()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters \"puniasheetal@gmail.com\" and \"asd123\"",
  "keyword": "When "
});
formatter.match({
  "location": "com.OpenCart.StepDefinition.BrowseProduct.user_enters_and(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks login button",
  "keyword": "And "
});
formatter.match({
  "location": "com.OpenCart.StepDefinition.BrowseProduct.user_clicks_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "To verify the functionality that search field accepts alphabets and numbers when customer enter product detail",
  "description": "     and whether a user is able to navigate to product description page when clicks on a product",
  "keyword": "Scenario"
});
formatter.step({
  "name": "navigate to home page",
  "keyword": "And "
});
formatter.match({
  "location": "com.OpenCart.StepDefinition.BrowseProduct.navigate_to_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters the product name in search field",
  "keyword": "When "
});
formatter.match({
  "location": "com.OpenCart.StepDefinition.BrowseProduct.user_enters_the_product_name_in_search_field()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clicks on search icon",
  "keyword": "And "
});
formatter.match({
  "location": "com.OpenCart.StepDefinition.BrowseProduct.clicks_on_search_icon()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify search field shows relevant result page.",
  "keyword": "Then "
});
formatter.match({
  "location": "com.OpenCart.StepDefinition.BrowseProduct.verify_search_field_shows_relevant_product_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on a product",
  "keyword": "When "
});
formatter.match({
  "location": "com.OpenCart.StepDefinition.BrowseProduct.user_clicks_on_a_product()"
});
