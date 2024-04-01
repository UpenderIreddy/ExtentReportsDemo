import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AttachScreenshotatTestandLogLevel {
	static WebDriver driver;
	
	
	public static void getReport() {
		
		ExtentReports extentreports = new ExtentReports(); // engine
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(".\\reports\\Testreport.html"); // spark type of
																									// report
		extentreports.attachReporter(sparkreporter); // attaching report to engine
		ExtentTest extenttest;
		
		String base64code = captureScreenshot();
		String path = captureScreenshot("Test1.jpg");
		
		// adding screenshots to report in the test Level
		extentreports
		
		.createTest("Screenshot1 with base64")
		.info("screenshot1 is passed")
		.addScreenCaptureFromBase64String(base64code);
		
		extentreports
		
		.createTest("Screenshot2 with base64")
		.info("screenshot1 is passed")
		.addScreenCaptureFromBase64String(base64code, "googleHomepage");
		
		
		extentreports
		
		.createTest("Screenshot3 with path")
		.info("screenshot 3 is with info passed")
		.log(Status.INFO,"screenshot3 is passed")
		.addScreenCaptureFromPath(path);

		extentreports

		.createTest("Screenshot4 with path")
		.info("screenshot 3 is with info passed")
		.log(Status.INFO,"screenshot3 is passed")
		.addScreenCaptureFromPath(path,"googleHomePage");
		
		
		// screenshot to add in the report at log level
		
       extentreports
		
		.createTest("Screenshot5 with path")
		.info("screenshot5 is failed")
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
       
       extentreports
		
   		.createTest("Screenshot6 with path")
   		.info("screenshot 6 is failed")
   		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64code).build());
		
		
		extentreports.flush();
		
	}

	public static void launchBrowser() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\uireddy\\Seleniumdrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");

	}

	public static String captureScreenshot(String fileName) {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File sourcefile = ts.getScreenshotAs(OutputType.FILE);

		File destfile = new File(".\\Screenshots" + fileName);

		try {
			FileHandler.copy(sourcefile, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destfile.getAbsolutePath();

	}
	
	
	public static String captureScreenshot() {
		
		TakesScreenshot ts = (TakesScreenshot) driver;

		String base64code = ts.getScreenshotAs(OutputType.BASE64);
		
		//System.out.println(sourcefile);
		return base64code;

	}

	public static void main(String[] args) {
		
		launchBrowser();
//		captureScreenshot();
//		captureScreenShot("test1.jpg");
		getReport();

	}

}