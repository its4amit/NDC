package stepDefinition;

import io.cucumber.java.en.And;
import pages.CheckOutPage;

public class PaymentPageSteps {

	CheckOutPage checkout = new CheckOutPage();

	@And("user enter information firstName {string}  lastName {string} postalCode {string}")

	public void enterInformation(String fname, String lname, String pcode) {

		checkout.enterUserInformation(fname, lname, pcode);

	}

	@And("user click on checkout button")

	public void userClickOnCheckOut() {

		checkout.clickOncontinueBtn();
	}

}
