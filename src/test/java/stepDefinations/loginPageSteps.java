package stepDefinations;

import org.testng.Assert;

import driverFactory.driverUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;
import utility.CONSTANTS;

public class loginPageSteps 
{
	loginPage login = new loginPage(driverUtility.getDriver());
	String status;
	
	@Given("User is already on login page")
	public void user_is_already_on_login_page() 
	{
	   String actualLoginPageTitle= login.validateLoginPageTitle();
	   String expectedLoginPageTitle = CONSTANTS.LOGIN_PAGE_TITLE;
	   Assert.assertTrue(actualLoginPageTitle.equals(expectedLoginPageTitle));
	}

	@When("User enters email address as {string}")
	public void user_enters_email_address_as(String emailAddress) throws InterruptedException {
		status = login.enterEmailAddress(emailAddress);
		System.out.println("Status of box is" +status);
	}

	@Then("Email Address box should be highlighted with {string}")
	public void email_address_box_should_be_highlighted_with(String status) {
	    String newStatus = this.status;
	    Assert.assertTrue(newStatus.contains(status));
	   
	}

}
