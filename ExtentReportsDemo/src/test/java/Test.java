import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Test {
	
	public static void main(String[]args) throws IOException {
		
		ExtentReports extentreports = new ExtentReports(); // engine
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(".\\reports\\Testreport.html"); // spark type of report
		extentreports.attachReporter(sparkreporter); // attaching report to engine
		ExtentTest extenttest = extentreports.createTest("Test");//start execution of the mentioned test
		
		//extenttest.pass("this test passed");
		//extenttest.fail("this test is failed");
		//extenttest.info("this test is passed");
		extenttest.log(Status.PASS, "test is passed");
		extenttest.assignAuthor("Upender");
		
		
		extentreports.flush(); // it overwrites the existing information in the generated extent report and inserts new data.
		//Desktop.getDesktop().browse(new File(".\\reports\\Testreport.html").toURI());
	}

}
