package pages;

import org.openqa.selenium.By;

import helper.Base;

public class PlpPage extends Base {

	By addToCartBtn = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
	By cartCount = By.xpath("//span[@data-test='shopping-cart-badge']");

	public void addProductInCart() {

		clickOnElement(addToCartBtn);

	}

	public void verifyMiniCartCount(String count) {
		validateText(cartCount, count);

	}

	public void clickOnMiniCart() {
		clickOnElement(cartCount);

	}

}
