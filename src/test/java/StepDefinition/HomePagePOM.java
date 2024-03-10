package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.LibraryDriver;

public class HomePagePOM extends LibraryDriver {

	WebDriver driver;

	public void urlLaunch(String phUrl) {
		this.driver = LibraryDriver.driver;
		driver.get(phUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	public String locationDiv() {

		String Locpopup = "Pass";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(PageObjRepo.div_Location));
		} catch (Exception e) {
			Locpopup = "Fail";
		}
		return Locpopup;
	}

	public void closePopup() {

		System.out.println("ClosePopup");
	}

	public void typeAddress(String Location) {

		driver.findElement(PageObjRepo.txt_location).sendKeys(Location);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectLocation() {
		driver.findElement(PageObjRepo.txt_location).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(PageObjRepo.txt_location).sendKeys(Keys.ENTER);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
