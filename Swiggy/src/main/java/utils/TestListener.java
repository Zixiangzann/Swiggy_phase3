package utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListener implements ITestListener {

	ExtentManager em = new ExtentManager();
	ExtentReports extent = em.createInstance();

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onFinish(ITestContext context) {
		if (extent != null) {
			extent.flush();
		}
	}

	public void onTestStart(ITestResult result) {
		String logText = "*** Running test method" + result.getMethod().getMethodName() + "***";
		// Markup m = MarkupHelper.createLabel(logText, ExtentColor.BLACK);
		// extentTest.get().log(Status.INFO, m);
		ExtentTest test = extent
				.createTest(result.getTestClass().getName() + " :: " + result.getMethod().getMethodName());
		extentTest.set(test);
		ITestContext context = result.getTestContext();
		ReadProperties config = new ReadProperties();
		try {
			config.loadProperties("config.properties");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String browser = config.get("browser");
		extent.setSystemInfo("Browser", browser);
	}

	public void onTestSuccess(ITestResult result) {
		String logText = "PASS";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extentTest.get().log(Status.PASS, m);
	}

	public void onTestFailure(ITestResult result) {
		String logText = "FAILED";

		String errMessage = result.getThrowable().getMessage();
		extentTest.get().fail("Exception Occured:: " + errMessage);

		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		extentTest.get().log(Status.FAIL, m);

	}

	public void onTestSkipped(ITestResult result) {
		String logText = "SKIPPED";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		extentTest.get().log(Status.SKIP, m);
	}

	public static void logInfo(String message) {
		extentTest.get().info(message);
	}
}
