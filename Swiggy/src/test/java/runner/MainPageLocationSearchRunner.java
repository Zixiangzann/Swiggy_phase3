package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\featureFiles\\MainPage", glue = "steps", dryRun=false, plugin = {
		"pretty",
		"json:target/cucumber-reports/Cucumber.json",
		"html:target/cucumber-report.html",
		})

public class MainPageLocationSearchRunner extends AbstractTestNGCucumberTests{
	
	@DataProvider
	@Override
	public Object[][] scenarios() {
		// TODO Auto-generated method stub
		return super.scenarios();
	}

}
