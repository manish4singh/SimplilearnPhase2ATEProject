
package StepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.LibraryDriver;

public class PizzaPagePOM {

	WebDriver driver;

	public String PizzaTab() {

		this.driver = LibraryDriver.driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjRepo.pizzaTab2));
			driver.findElement(PageObjRepo.pizzaTab2).click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjRepo.tab_Pizza));
			driver.findElement(PageObjRepo.tab_Pizza).click();
			e.printStackTrace();
		}

		String pizzastatus = "Pass";
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(2));
		try {
			wait1.until(ExpectedConditions.presenceOfElementLocated(PageObjRepo.tab_PizzaRed));
		} catch (Exception e) {
			pizzastatus = "Fail";
			e.printStackTrace();
		}
		return pizzastatus;
	}

	public String addPizza() {
		String pizzaAdd_status = "Pass";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,420)");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjRepo.btn_Add_TandooriPaneer));
			driver.findElement(PageObjRepo.btn_Add_TandooriPaneer).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		} catch (Exception e) {
			pizzaAdd_status = "Fail";
			e.printStackTrace();
		}
		return pizzaAdd_status;
	}

	public String itemBasket() {
		String basketStatus = "Pass";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjRepo.lnk_TandooriInBasket));
		} catch (Exception e) {
			basketStatus = "Fail";
			e.printStackTrace();
		}
		return basketStatus;
	}

	public String CalculatingTotalPrice() {
		// Fetching SubTotal
		String textSubTotalString = driver.findElement(PageObjRepo.lbl_Subtotal).getText();
		System.out.println("Subtotal from getetxt:" + textSubTotalString);
		String subtotString = textSubTotalString.trim().substring(1);
		System.out.println("Sustotal String: " + subtotString);
		float subTotal = Float.parseFloat(subtotString);
		System.out.println("Float SubTotal: " + subTotal);

		// Fetching Tax
		String textTaxString = driver.findElement(PageObjRepo.lbl_TotTax).getText();
		System.out.println("Tax from GetText: " + textTaxString);
		String taxString = textTaxString.trim().substring(1);
		System.out.println("Tax String: " + taxString);
		float tax = Float.parseFloat(taxString);
		System.out.println(" Float tax: " + tax);

		// Restaurant Handling Charges
		String rhcString = driver.findElement(PageObjRepo.lbl_RHCharges).getText();
		System.out.println("Restaurant Handling Charges from GetText:" + rhcString);
		String chargesString = rhcString.trim().substring(1);
		System.out.println("RHS String: " + chargesString);
		float rhs = Float.parseFloat(chargesString);
		System.out.println("Float RHS: " + rhs);

		// Fetching FinalAmount
		String textTotalAmountString = driver.findElement(PageObjRepo.lbl_TotAmount).getText();
		System.out.println("Total Amount from GetText: " + textTotalAmountString);
		String AmountString = textTotalAmountString.trim().substring(1);
		System.out.println("Amount String: " + AmountString);
		float totalAmount = Float.parseFloat(AmountString);
		System.out.println("Float Amount: " + totalAmount);

		// Validating Pizza Price + tax = checkout price
		String totalPriceStatus;
		float calcFinalPrice = subTotal + tax + rhs;
		System.out.println("Calculated Final Price: " + calcFinalPrice);

		if (calcFinalPrice == totalAmount) {
			System.out.println("Total Price Matching with Calc price");
			totalPriceStatus = "Pass";
		} else {
			System.out.println("Total Price Not Matching with Calc Price");
			totalPriceStatus = "Fail";
		}
		return totalPriceStatus;
	}

	public String valItemCountInCheckoutBtn() {

		// Getting size of basket items
		List<WebElement> BasketItems = driver.findElements(PageObjRepo.basket_size);
		int basketSize = BasketItems.size();
		System.out.println("Items in Basket: " + basketSize);

		// Getting item count in checkout button
		String itmCntChktBtnString = driver.findElement(PageObjRepo.itemCount_chkout).getText();
		System.out.println("Item Count in Checkout: " + itmCntChktBtnString);
		String itcCntString = itmCntChktBtnString.replace("item", "").trim();
		System.out.println("Count String: " + itcCntString);
		int countPizza = Integer.parseInt(itcCntString);
		System.out.println("Int Checkout Item Count: " + countPizza);

		// Validating basket size is checkout item count
		String chktItemCntStatus;
		if (countPizza == basketSize) {
			System.out.println("Total items Matching with items count in Checkout button");
			chktItemCntStatus = "Pass";
		} else {
			System.out.println("Total items Not Matching with items count in Checkout button");
			chktItemCntStatus = "Fail";
		}
		return chktItemCntStatus;
	}

	public String valPriceInCheckoutBtn() {

		// Fetching FinalAmount
		String textTotalAmountString = driver.findElement(PageObjRepo.lbl_TotAmount).getText();
		System.out.println("Total Amount from GetText: " + textTotalAmountString);
		String AmountString = textTotalAmountString.trim().substring(1);
		System.out.println("Amount String: " + AmountString);
		float totalAmount = Float.parseFloat(AmountString);
		System.out.println("Float Amount: " + totalAmount);

		// Validating total price in checkout button
		String totalPricechkoutString = driver.findElement(PageObjRepo.totPrice_chkout).getText();
		System.out.println("Total Amount in checkout button:" + totalPricechkoutString);
		String tpString = totalPricechkoutString.trim().substring(1);
		System.out.println("Total amount String: " + tpString);
		float pricePizza = Float.parseFloat(tpString);
		System.out.println("Float Total amount: " + pricePizza);
		String chktPriceStatus;
		if (pricePizza == totalAmount) {
			System.out.println("Total price is Matching with Price in checkout Button");
			chktPriceStatus = "Pass";
		} else {
			System.out.println("Total price is Not Matching with Price in checkout Button");
			chktPriceStatus = "Fail";
		}
		return chktPriceStatus;
	}

}
