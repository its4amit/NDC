package pages;

import org.openqa.selenium.By;

import helper.Base;

public class LoginPage extends Base {

	By userName = By.xpath("//input[@id='user-name']");
	By password = By.xpath("//input[@id='password']");
	By loginBtn = By.xpath("//input[@id='login-button']");
	By homePageHeading = By.xpath("//span[@class='title']");
	By errorHeading = By.xpath("//h3[@data-test='error']");

//	public void launchApllication() {
//		launchUrl();
//	}
	
//	when we use hooks in base class  there is no need to write code for launch url 

	public void enterUserNameAndPass(String uname, String pass) {

		clearAndEnter(userName, uname);
		clearAndEnter(password, pass);

	}

	public void clickOnLoginBtn() {

		clickOnElement(loginBtn);

	}

	public void validatehomePageHeading(String text) {
		validateText(homePageHeading, text);
	}

	public void validatErrorHeading() {

		waitForExpectedElement(errorHeading).isDisplayed();

	}

}
