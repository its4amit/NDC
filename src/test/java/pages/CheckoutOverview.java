package pages;

import org.openqa.selenium.By;

import helper.Base;

public class CheckoutOverview extends Base {

	By finishBtn = By.xpath("//button[@id='finish']");

	By completeHeader = By.xpath("//h2[@class='complete-header']");

	public void clickOnFinishBtn() {

		clickOnElement(finishBtn);

	}

	public void ValidateOrder(String text) {

		validateText(completeHeader, text);

	}
}
