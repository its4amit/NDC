Feature:  Payment Functionality


@regression
Scenario:  successfull order creation
When user enter username "standard_user" and password "secret_sauce"
And user clicks on login button
And user click on add to cart button
And verify cart count "1" 
And user click on Mini Cart 
And user navigate to checkout page
And user enter information firstName "Amit"  lastName "singh" postalCode "1234"
And user click on checkout button 
And user navigate to checkout overview
Then validate successful order with heading "Thank you for your order!"



