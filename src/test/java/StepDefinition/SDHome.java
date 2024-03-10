package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SDHome {
	WebDriver driver;
	HomePagePOM home = new HomePagePOM();

	@Given("User launch Pizzahut application with {string}")
	public void user_launch_pizzahut_application_with(String phUrl) {
		home.urlLaunch(phUrl);
	}

	@When("User wait for auto location black pop up screen")
	public void user_wait_for_auto_location_black_pop_up_screen() {
		String Locpopup = home.locationDiv();
		Assert.assertEquals("Pass", Locpopup);
	}

	@Then("User close the pop up screen")
	public void user_close_the_pop_up_screen() {
		home.closePopup();
	}

	@Then("User see pop up for delivery asking for enter location")
	public void user_see_pop_up_for_delivery_asking_for_enter_location() {
		home.locationDiv();
	}

	@Then("User type address as {string}")
	public void user_type_address_as(String Location) {
		home.typeAddress(Location);
	}

	@Then("User select first auto populate drop down option")
	public void user_select_first_auto_populate_drop_down_option() {
		home.selectLocation();
	}

}
