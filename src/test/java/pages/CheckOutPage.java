package pages;

import org.openqa.selenium.By;

import helper.Base;

public class CheckOutPage extends Base {

	By firstName = By.xpath("//input[@id='first-name']");
	By lastName = By.xpath("//input[@id='last-name']");
	By postalCode = By.xpath("//input[@id='postal-code']");
	By continueBtn = By.xpath("//input[@id='continue']");

	public void enterUserInformation(String fname, String lname, String pcode) {

		clearAndEnter(firstName, fname);
		clearAndEnter(lastName, lname);
		clearAndEnter(postalCode, pcode);

	}

	public void clickOncontinueBtn() {
		clickOnElement(continueBtn);

	}
}
