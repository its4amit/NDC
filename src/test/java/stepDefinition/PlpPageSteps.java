package stepDefinition;

import io.cucumber.java.en.And;
import pages.PlpPage;

public class PlpPageSteps {

	PlpPage plp = new PlpPage();

	@And("user click on add to cart button")
	public void clickOnAddToCart() {

		plp.addProductInCart();

	}

	@And("verify cart count {string}")

	public void cartCount(String count) {

		plp.verifyMiniCartCount(count);

	}

	@And("user click on Mini Cart")

	public void userClickOnMiniCart() {
		plp.clickOnMiniCart();

	}

}
