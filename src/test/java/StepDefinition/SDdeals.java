package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SDdeals {

	WebDriver driver;
	DealsPagePOM deals = new DealsPagePOM();

	@When("User navigate to deals page")
	public void user_navigate_to_deals_page() {
		String dealsstatus = deals.dealsPage();
		Assert.assertEquals("Pass", dealsstatus);
	}

	@Then("User validate vegetarian radio button flag is off")
	public void user_validate_vegetarian_radio_button_flag_is_off() {
		String vegStatus = deals.vegRadioBtn();
		Assert.assertEquals("Pass", vegStatus);
	}

}
