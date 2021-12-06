package utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	// Create an extent report instance
	public ExtentReports createInstance() {

		//String reportFileName = "Results_" + System.currentTimeMillis() + ".html";
		String reportFileName = "ExtentReport.html";
		String fileSeperator = System.getProperty("file.separator");
		String reportFilepath = System.getProperty("user.dir") + fileSeperator + "target";
		String reportFileLocation = reportFilepath + fileSeperator + reportFileName;

		File testDirectory = new File(reportFilepath);

		if (!testDirectory.exists()) {
			if (testDirectory.mkdir()) {
				reportFileLocation = reportFilepath + fileSeperator + reportFileName;
			} else {
				System.out.println("Failed to create directory: ");
			}
		} else {
			System.out.println("Directory already exists: ");
		}

		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportFileLocation);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle(reportFileName);
		htmlReporter.config().setReportName(reportFileName);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		return extent;
	}

	public static void main(String[] args) {

		// System.out.println(reportFileName);
		// System.out.println(reportFileLocation);

	}

}
