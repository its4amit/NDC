package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CheckoutOverview;


public class CheckOutOverviewSteps {

	CheckoutOverview overview = new CheckoutOverview();

	@And("user navigate to checkout overview")
	public void navigateToCheckoutOverview() {

		overview.clickOnFinishBtn();
	}

	

	@Then("validate successful order with heading {string}")

	public void validatesuccessfullHeading(String text) {

		overview.ValidateOrder(text);
	}

}
