package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjRepo {

	WebDriver driver;
	// Home Page objects
	public static final By div_Location = By.xpath("//div[contains(@class,'localisation-form')]");
	public static final By txt_location = By.xpath("//input[@placeholder='Enter your location for delivery']");

	// Deals Page Objects
	public static final By tab_Deals = By.xpath(
			"//div[contains(@class,'menu-item-wrapper')]//a[@href='/order/deals/'][contains(@class,'inline-block bg-red')]");
	public static final By rbtn_Veg = By.xpath("//span[contains(@class,'bg-grey-light border-grey-light')]");

	// Pizza Page Objects
	public static final By tab_Pizza = By
			.xpath("//a[contains(@class,'inline-block')][@href='/order/pizzas/']//span[text()='Pizzas']");
	public static final By pizzaTab2 = By
			.xpath("//a[contains(@class,'typography-4')][@href='/order/pizzas/']//span[text()='Pizzas']");
	public static final By tab_PizzaRed = By.xpath("//a[@href='/order/pizzas/'][contains(@class,'text-red')]");

	public static final By btn_Add_TandooriPaneer = By.xpath(
			"//button[contains(@class,'green flex')][contains(@data-synth,'button--tandoori-paneer')]/span/span[text()='Add']");
	public static final By lnk_TandooriInBasket = By
			.xpath("//a[text()='Click to make changes'][contains(@href,'tandoori-paneer')]");

	public static final By lbl_Subtotal = By.xpath("//span[@class='subtotal']");
	public static final By lbl_TotTax = By.xpath(
			"//span[text()='Total Tax']/parent::span/parent::div//following-sibling::span[contains(text(),'₹')]");
	public static final By lbl_TotAmount = By.xpath(
			"//span[text()='Amount payable']/parent::span/parent::div//following-sibling::span[@class='amountdue']");
	public static final By lbl_RHCharges = By.xpath("//div[@class='display-supplement-value']");

	public static final By basket_size = By.xpath("//div[@data-synth='basket-deal-item']");
	public static final By itemCount_chkout = By
			.xpath("//span[@class='mr-auto text-left']//span[contains(text(),'item')]");
	public static final By totPrice_chkout = By
			.xpath("//span[@class='ml-auto text-right']//span[@data-synth='basket-value']");

	// Drinks Page Objects
	public static final By tab_Drinks = By
			.xpath("//a[contains(@class,'link--drinks')][@href='/order/drinks/']//span[text()='Drinks']");
	public static final By tab_drinksRed = By
			.xpath("//a[contains(@class,'text-red')][@href=\"/order/drinks/\"]//span[text()='Drinks']");

	public static final By btn_Pepsi = By
			.xpath("//span[text()='Add']/parent::span/parent::button[contains(@data-synth,'pepsi-600ml')]");
	public static final By btn_ClosePizza = By.xpath(
			"//button[contains(@class,'icon-close')][contains(@data-synth,'basket-item-remove--tandoori-paneer')]");
	public static final By btn_Checkout = By.xpath("//button[@data-synth='link--checkout']");
	public static final By btn_ContinueShopping = By.xpath("//button[@data-synth='link--continue-shopping']");

}
