package stepDefinition;

import io.cucumber.java.en.And;
import pages.BasketPage;

public class BasketPageSteps {

	BasketPage basket = new BasketPage();

	@And("user navigate to checkout page")
	public void navigateToCheckoutPage() {

		basket.clickONCheckoutBtn();
	}


	
	
}
