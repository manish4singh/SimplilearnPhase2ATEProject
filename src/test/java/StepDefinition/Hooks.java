package StepDefinition;

import org.openqa.selenium.WebDriver;

import Utils.LibraryDriver;
import io.cucumber.java.Before;

public class Hooks extends LibraryDriver {

	WebDriver driver;

	@Before
	public void BeforeMethod() {
//		this.driver = LibraryDriver.driver;
		getDriver();
	}

//	@After
//	public void AfterMethod() {
//		driver.close();
//	}

}
