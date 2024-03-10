package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;

public class SDdrinks {

	WebDriver driver;
	DrinksPOM drinks = new DrinksPOM();

	@Then("User clicks on Drinks option")
	public void user_clicks_on_drinks_option() {
		String drinkstatus = drinks.drinksTab();
		Assert.assertEquals("Pass", drinkstatus);
	}

	@Then("User select Pepsi option to add into the Basket")
	public void user_select_pepsi_option_to_add_into_the_basket() {
		String pepsiBtnStatus = drinks.addPepsi();
		Assert.assertEquals("Pass", pepsiBtnStatus);
	}

	@Then("User see 2 items are showing under checkout button")
	public void user_see_items_are_showing_under_checkout_button() {
		String chktItmCntStatus = drinks.valItmCntInChcktBtn();
		Assert.assertEquals("Pass", chktItmCntStatus);
	}

	@Then("User see total price is now more than before")
	public void user_see_total_price_is_now_more_than_before() {
		String chktPriceStatus = drinks.valPriceInChcktBtn();
		Assert.assertEquals("Pass", chktPriceStatus);
	}

	@Then("User remove the Pizza item from Basket")
	public void user_remove_the_pizza_item_from_basket() {
		String closePizzaStatus = drinks.removePizza();
		Assert.assertEquals("Pass", closePizzaStatus);
	}

	@Then("see Price tag got removed from the checkout button")
	public void see_price_tag_got_removed_from_the_checkout_button() {
		String priceRemovedStatus = drinks.priceTagRemoved();
		Assert.assertEquals("Pass", priceRemovedStatus);
	}

	@Then("User see 1 item showing in checkout button")
	public void user_see_item_showing_in_checkout_button() {
		String itemCountStatus = drinks.valItmInChkBtn();
		Assert.assertEquals("Pass", itemCountStatus);
	}

	@Then("User Clicks on Checkout button")
	public void user_clicks_on_checkout_button() {
		String chcktBtnStatus = drinks.checkoutBtn();
		Assert.assertEquals("Pass", chcktBtnStatus);
	}

	@Then("User see minimum order required pop up is getting displayed")
	public void user_see_minimum_order_required_pop_up_is_getting_displayed() {
		String errorStatus = drinks.errorPopup();
		Assert.assertEquals("Pass", errorStatus);
	}

}
