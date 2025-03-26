package pages;

import org.openqa.selenium.By;

import helper.Base;

public class BasketPage extends Base {

	By checkoutBtn = By.xpath("//button[@id='checkout']");

	public void clickONCheckoutBtn() {

		clickOnElement(checkoutBtn);

	}
      
	
	
	
	
}
	
	

