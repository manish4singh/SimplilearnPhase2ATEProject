package StepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.LibraryDriver;

public class DrinksPOM {

	WebDriver driver;

	public String drinksTab() {

		this.driver = LibraryDriver.driver;
		driver.findElement(PageObjRepo.tab_Drinks).click();

		String drinkstatus = "Pass";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjRepo.tab_drinksRed));
		} catch (Exception e) {
			drinkstatus = "Fail";
			e.printStackTrace();
		}
		return drinkstatus;
	}

	public String addPepsi() {

		String pepsiBtnStatus = "Pass";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjRepo.btn_Pepsi));
			driver.findElement(PageObjRepo.btn_Pepsi).click();
		} catch (Exception e) {
			pepsiBtnStatus = "Fail";
			e.printStackTrace();
		}
		return pepsiBtnStatus;
	}

	public String valItmCntInChcktBtn() {

		// count of items in Basket
		List<WebElement> BasketItemsPepsi = driver.findElements(PageObjRepo.basket_size);
		int basketSizePepsi = BasketItemsPepsi.size();
		System.out.println("Items in Basket(Pepsi): " + basketSizePepsi);

		// Validating item count in checkout button
		String iCntChktPepString = driver.findElement(PageObjRepo.itemCount_chkout).getText();
		System.out.println("Item Count Checkout(Pepsi): " + iCntChktPepString);
		String CntPepString = iCntChktPepString.replace("item", "").trim();
		CntPepString = CntPepString.replace("s", "").trim();
		System.out.println("Count String: " + CntPepString);
		int chktItmCnt = Integer.parseInt(CntPepString);
		System.out.println("Int Checkout Item Count: " + chktItmCnt);

		String chktItmCntStatus;
		if (chktItmCnt == basketSizePepsi) {
			chktItmCntStatus = "Pass";
			System.out.println("Basket count Matching with Item Count in Checkout Button");
		} else {
			chktItmCntStatus = "Fail";
			System.out.println("Basket count Not Matching with Item Count in Checkout Button");
		}
		return chktItmCntStatus;
	}

	public String valPriceInChcktBtn() {

		// Fetching FinalAmount
		String textTotalAmountString = driver.findElement(PageObjRepo.lbl_TotAmount).getText();
		System.out.println("Total Amount from GetText: " + textTotalAmountString);
		String AmountString = textTotalAmountString.trim().substring(1);
		System.out.println("Amount String: " + AmountString);
		float totalAmount = Float.parseFloat(AmountString);
		System.out.println("Float Amount: " + totalAmount);

		// Validating total price in checkout button
		String totPricechktPepString = driver.findElement(PageObjRepo.totPrice_chkout).getText();
		System.out.println("Total Amount in checkout button:" + totPricechktPepString);
		String tpPepString = totPricechktPepString.trim().substring(1);
		System.out.println("Total String: " + tpPepString);
		float chktPrice = Float.parseFloat(tpPepString);
		System.out.println("Float Total Price: " + chktPrice);

		String chktPriceStatus;
		if (totalAmount == chktPrice) {
			chktPriceStatus = "Pass";
			System.out.println("Price added for Pepsi");
		} else {
			chktPriceStatus = "Fail";
			System.out.println("Price not added for Pepsi");
		}
		return chktPriceStatus;
	}

	public String removePizza() {

		String closePizzaStatus = "Pass";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjRepo.btn_ClosePizza));
			driver.findElement(PageObjRepo.btn_ClosePizza).click();
		} catch (Exception e) {
			closePizzaStatus = "Fail";
			e.printStackTrace();
		}
		return closePizzaStatus;
	}

	public String priceTagRemoved() {
		String priceRemovedStatus = "Pass";

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(PageObjRepo.totPrice_chkout));
			System.out.println("Price Tag is removed");
		} catch (Exception e) {
			System.out.println("Price tag not removed");
			priceRemovedStatus = "Fail";
			e.printStackTrace();
		}
		return priceRemovedStatus;
	}

	public String valItmInChkBtn() {

		// Validating item count in checkout button
		String countPepsiRemoved = driver.findElement(PageObjRepo.itemCount_chkout).getText();
		System.out.println("Item Count from GetText: " + countPepsiRemoved);
		String countPepChktRem = countPepsiRemoved.replace("item", "").trim();
		countPepChktRem = countPepChktRem.replace("s", "").trim();
		System.out.println("Item count String: " + countPepChktRem);
		int itemCount = Integer.parseInt(countPepChktRem);
		System.out.println("Int Item Count: " + itemCount);

		String itemCountStatus;
		if (itemCount == 1) {
			System.out.println("1 item in checkout button");
			itemCountStatus = "Pass";
		} else {
			System.out.println("Item count not matching");
			itemCountStatus = "Fail";
		}
		return itemCountStatus;
	}

	public String checkoutBtn() {

		String chcktBtnStatus = "Pass";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjRepo.btn_Checkout));
			driver.findElement(PageObjRepo.btn_Checkout).click();
		} catch (Exception e) {
			chcktBtnStatus = "Fail";
			e.printStackTrace();
		}
		return chcktBtnStatus;
	}

	public String errorPopup() {

		String errorStatus = "Pass";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjRepo.btn_ContinueShopping));
			System.out.println("Success");
		} catch (Exception e) {
			System.out.println("Failed");
			errorStatus = "Fail";
			e.printStackTrace();
		}
		return errorStatus;
	}

}
