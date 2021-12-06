package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;

public class Hooks extends DriverFactory {
	
	@Before
	public void beforeScenario() throws InterruptedException {
		// driver = getDriver();
		DriverFactory.setDriver();
	}

	@After
	public void afterScenario() throws InterruptedException {
		getDriver().quit();

	}
	
}
