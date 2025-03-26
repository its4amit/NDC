package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageSteps {

	LoginPage login = new LoginPage();
	
//	@Given("user launch site url")
//	public void user_launch_site_url() {
//		login.launchApllication();
	   
	//}

	@When("user enter username {string} and password {string}")
	public void user_enter_username_test_and_password(String username, String password) {
		
		login.enterUserNameAndPass(username, password);
		
		
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		
	 login.clickOnLoginBtn();
	   
	}

	@Then("validate successful login with heading {string}")
	public void validate_successful_login(String text) {
		
		login.validatehomePageHeading(text);
		
	}
	
	@Then("validate error is displayed")
	
	public void validateErrorIsDisplayed() {
		
		login.validatErrorHeading();
		
	}
	
	

	
	
	
	
}
