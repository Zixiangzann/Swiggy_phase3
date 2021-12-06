package steps;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.DriverFactory;

public class LocationSearchStepsDefinitions extends DriverFactory {

	@Given("User at main menu page")
	public void user_at_main_menu_page() {
		basePage.goToUrl("https://www.swiggy.com");
	}

	@Given("User enter first few word of {string}")
	public void user_enter_first_few_word_of(String location) throws InterruptedException, IOException {
		mainPage.searchMessage(location);
		Thread.sleep(1000);
	}

	@Then("search bar should have {string}")
	public void search_bar_should_have(String suggestion) throws IOException, InterruptedException {
		boolean haveSuggestion = Boolean.parseBoolean(suggestion);
		Thread.sleep(500);
		mainPage.assertResults(mainPage.getNumberOfSuggestion() > 0, haveSuggestion);
	}

	@And("User clicked on clear button")
	public void user_clicked_on_clear_button() throws IOException, InterruptedException {
		mainPage.clearBtnClick();
	}

	@Then("text in the searchbar should be cleared")
	public void text_in_the_searchbar_should_be_cleared() throws IOException {
		String searchBarValue = mainPage.getSearchBarValue();
		Assert.assertEquals(searchBarValue, "");

	}

	@Given("User enter {string} in the searchbar")
	public void user_enter_in_the_searchbar(String string) throws IOException, InterruptedException {
		mainPage.searchMessage("New Delhi");

	}

	@Given("User click on the suggested location")
	public void user_click_on_the_suggested_location() throws InterruptedException, IOException {
		mainPage.clickOnSearchSuggestion(1);

	}

	@Then("User should be directed to url {string}")
	public void user_should_be_directed_to_url(String expectedUrl) {
		String actualUrl = mainPage.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

	}

	@Given("User click on FIND FOOD button without searching or clicking on any suggested location")
	public void user_click_on_find_food_button_without_searching_or_clicking_on_any_suggested_location()
			throws IOException, InterruptedException {
			Thread.sleep(10000);
			mainPage.searchMessage("clear me");
			Thread.sleep(1000);
			mainPage.clearBtnClick();
			mainPage.findFoodBtnClick();
			String searchBarValue = mainPage.getSearchBarValue();
			Assert.assertEquals(searchBarValue, "");
			mainPage.findFoodBtnClick();

	}

	@Then("There should be a message prompt {string}")
	public void there_should_be_a_message_prompt(String expectedMessage) throws IOException {
		String actualMessage = mainPage.getSearchMessage();
		Assert.assertEquals(actualMessage, expectedMessage);
	}

}
