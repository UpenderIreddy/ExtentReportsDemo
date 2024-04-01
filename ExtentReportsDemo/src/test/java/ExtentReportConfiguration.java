import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportConfiguration {
	
	static WebDriver driver;
	
//	public static String captureScreenshot(String fileName) {
//
//		TakesScreenshot ts = (TakesScreenshot) driver;
//
//		File sourcefile1 = ts.getScreenshotAs(OutputType.FILE);
//
//		File destfile1 = new File(".\\Screenshots" + fileName);
//
//		try {
//			FileHandler.copy(sourcefile1, destfile1);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return destfile1.getAbsolutePath();
//
//	}

	public static void main(String[]args) {
		
		//String path1 = captureScreenshot("Test2.jpg");
		
		ExtentReports extentreports = new ExtentReports(); // engine
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(".\\reports\\Testreport.html"); // spark type of
																									// report
		extentreports.attachReporter(sparkreporter);// attaching report to engine
		
		sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setReportName("configTestReport");
		sparkreporter.config().setDocumentTitle("configTestTitle");
		sparkreporter.config().setTimeStampFormat("HH::MM:SS,DD-MM-YYYY");
		sparkreporter.config().setCss(".badge-primary {background-color: #d91527}");
		ExtentTest extenttest;
		
		extentreports
		.createTest("ConfigurationTest 1")
		.assignAuthor("Upender")
		.assignCategory("Regular")
		.assignDevice("Windows")
		.log(Status.PASS," The config Test is passed");
		
		
		
		extentreports
		.createTest("ConfigurationTest 2 ")
		.assignAuthor("Upender")
		.assignCategory("Regular")
		.assignDevice("Windows")
		.log(Status.FAIL," The config Test is Failed");
		//.addScreenCaptureFromPath(path1);
		
		extentreports.flush();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\uireddy\\Seleniumdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");

		driver.quit();
		
	}

		
	
	}
	

