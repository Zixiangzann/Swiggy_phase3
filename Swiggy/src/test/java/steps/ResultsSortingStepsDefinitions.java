package steps;

import java.io.IOException;

import org.testng.Assert;

import com.google.common.collect.Comparators;
import com.google.common.collect.Ordering;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverFactory;

public class ResultsSortingStepsDefinitions extends DriverFactory{
	
	@Given("User search for a valid location")
	public void user_search_for_a_valid_location() throws IOException, InterruptedException {
		basePage.goToUrl("https://www.swiggy.com");
		mainPage.searchMessage("New Delhi");
		mainPage.clickOnSearchSuggestion(1);
	}

	@Given("have directed to restaurants page")
	public void have_directed_to_restaurants_page() throws InterruptedException {
		String actualUrl = mainPage.getCurrentUrl();
		//add some delay , wait for page to navigate
		Thread.sleep(5000);
		Assert.assertEquals(actualUrl, "https://www.swiggy.com/restaurants");
	}

	@Then("should have the following sorting tab")
	public void should_have_the_following_sorting_tab() {
		System.out.println(restaurantPage.getSortingTab());
		Assert.assertTrue(restaurantPage.getSortingTab().contains("Relevance"));
		Assert.assertTrue(restaurantPage.getSortingTab().contains("Delivery Time"));
		Assert.assertTrue(restaurantPage.getSortingTab().contains("Rating"));
		Assert.assertTrue(restaurantPage.getSortingTab().contains("Cost: Low To High"));
		Assert.assertTrue(restaurantPage.getSortingTab().contains("Cost: High To Low"));

	}

	@When("user clicked on Delivery Time tab")
	public void user_clicked_on_Delivery_Time_tab() throws InterruptedException, IOException {
		restaurantPage.clickDeliveryTimeTab();
	}

	@Then("result should be sorted ascending by delivery time")
	public void result_should_be_sorted_ascending_by_delivery_time() throws InterruptedException {
		System.out.println(restaurantPage.getDeliveryTime());
		Assert.assertTrue(Ordering.natural().isOrdered(restaurantPage.getDeliveryTime()));
	}
	
	@When("user clicked on Cost: High To Low tab")
	public void user_clicked_on_Cost_High_To_Low_tab() throws InterruptedException, IOException {
		restaurantPage.clickCostHighToLowTab();
		
	}
	
	@Then("result should be sorted by cost from high to low")
	public void result_should_be_sorted_by_cost_from_high_to_low() throws InterruptedException {
		System.out.println(restaurantPage.getCost());
		Assert.assertTrue(Ordering.natural().reverse().isOrdered(restaurantPage.getCost()));
	}

}
