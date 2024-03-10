
package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.LibraryDriver;

public class DealsPagePOM {

	WebDriver driver;

	public String dealsPage() {
		this.driver = LibraryDriver.driver;

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dealPageStatus;
		String cURL = driver.getCurrentUrl();
		System.out.println(cURL);
		if (cURL.endsWith("/order/deals/")) {
			System.out.println("In Deals Page");
			dealPageStatus = "Pass";
		} else {
			System.out.println("Not in Deals page");
			dealPageStatus = "Fail";
		}
		return dealPageStatus;
	}

	public String vegRadioBtn() {
		String vegStatus = "Pass";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjRepo.rbtn_Veg));
		} catch (Exception e) {
			vegStatus = "Fail";
			e.printStackTrace();
		}
		return vegStatus;
	}
}
