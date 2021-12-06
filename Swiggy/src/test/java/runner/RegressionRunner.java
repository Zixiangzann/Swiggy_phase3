package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\featureFiles\\MainPage", tags= "@Regression", glue = "steps", dryRun=false, plugin = {
		"pretty",
		"json:target/cucumber-reports/Cucumber_Regression.json",
		"html:target/cucumber-report_Regression.html",
		})

public class RegressionRunner extends AbstractTestNGCucumberTests{
	
	@DataProvider
	@Override
	public Object[][] scenarios() {
		// TODO Auto-generated method stub
		return super.scenarios();
	}

}
