package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SDPizza {

	WebDriver driver;
	PizzaPagePOM pizza = new PizzaPagePOM();

	@Then("User clicks on Pizzas menu bar option")
	public void user_clicks_on_pizzas_menu_bar_option() {
		String pizzastatus = pizza.PizzaTab();
		Assert.assertEquals("Pass", pizzastatus);
	}

	@When("User select add button of any pizza from Recommended")
	public void user_select_add_button_of_any_pizza_from_recommended() {
		String pizzaAdd_status = pizza.addPizza();
		Assert.assertEquals("Pass", pizzaAdd_status);
	}

	@Then("User see that the pizza is getting added under Your Basket")
	public void user_see_that_the_pizza_is_getting_added_under_your_basket() {
		String basketStatus = pizza.itemBasket();
		Assert.assertEquals("Pass", basketStatus);
	}

	@Then("User validate pizza price plus Tax is checkout price")
	public void user_validate_pizza_price_plus_tax_is_checkout_price() {
		String totalPriceStatus = pizza.CalculatingTotalPrice();
		Assert.assertEquals("Pass", totalPriceStatus);
	}

	@Then("User validate checkout button contains Item count")
	public void user_validate_checkout_button_contains_item_count() {
		String chktItemCntStatus = pizza.valItemCountInCheckoutBtn();
		Assert.assertEquals("Pass", chktItemCntStatus);

	}

	@Then("User validate checkout button contains total price count")
	public void user_validate_checkout_button_contains_total_price_count() {
		String chktPriceStatus = pizza.valPriceInCheckoutBtn();
		Assert.assertEquals("Pass", chktPriceStatus);
	}

}
