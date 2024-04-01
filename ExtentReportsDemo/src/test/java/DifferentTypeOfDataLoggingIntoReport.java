import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DifferentTypeOfDataLoggingIntoReport {

	public static void main(String[] args) throws IOException {

		ExtentReports extentreports = new ExtentReports(); // engine
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(".\\reports\\Testreport.html"); // spark type of
																									// report
		extentreports.attachReporter(sparkreporter); // attaching report to engine
		ExtentTest extenttest;

		// Bold Text based
		extentreports.createTest(" bold text based Test")
		.log(Status.INFO, "<b> test is passed </b>");

		// Italic text based
		extentreports.createTest(" Italic text based Test").log(Status.INFO, "<i> test is passed </i>");

		// Bold and Italic text based
		extentreports.createTest("bold and Italic based Text").log(Status.INFO, "<b><i> test is passed </b></i>");

		// XML text based

		String xmldata = "</book>\r\n" + "   <book id=\"bk112\">\r\n" + "      <author>Galos, Mike</author>\r\n"
				+ "      <title>Visual Studio 7: A Comprehensive Guide</title>\r\n"
				+ "      <genre>Computer</genre>\r\n" + "      <price>49.95</price>\r\n"
				+ "      <publish_date>2001-04-16</publish_date>\r\n"
				+ "      <description>Microsoft Visual Studio 7 is explored in depth,\r\n"
				+ "      looking at how Visual Basic, Visual C++, C#, and ASP+ are \r\n"
				+ "      integrated into a comprehensive development \r\n" + "      environment.</description>\r\n"
				+ "   </book>";

		extentreports
		.createTest("XML Based test")
		.log(Status.PASS, "XML Test is Passed")
		.log(Status.INFO,MarkupHelper.createCodeBlock(xmldata, CodeLanguage.XML));

		// JSON Text Based test

		String JSONData = " [\r\n" + "	{\r\n" + "		color: \"red\",\r\n" + "		value: \"#f00\"\r\n"
				+ "	},\r\n" + "	{\r\n" + "		color: \"green\",\r\n" + "		value: \"#0f0\"\r\n" + "	},\r\n"
				+ "	{\r\n" + "		color: \"blue\",\r\n" + "		value: \"#00f\"\r\n" + "	},\r\n" + "	{\r\n"
				+ "		color: \"cyan\",\r\n" + "		value: \"#0ff\"\r\n" + "	},\r\n" + "	{\r\n"
				+ "		color: \"magenta\",\r\n" + "		value: \"#f0f\"\r\n" + "	},\r\n" + "	{\r\n"
				+ "		color: \"yellow\",\r\n" + "		value: \"#ff0\"\r\n" + "	},\r\n" + "	{\r\n"
				+ "		color: \"black\",\r\n" + "		value: \"#000\"\r\n" + "	}\r\n" + "]";

		extentreports

				.createTest("Json based data")
				.log(Status.PASS, "JSON test is passed")
				.generateLog(Status.INFO, MarkupHelper.createCodeBlock(JSONData, CodeLanguage.JSON));

		// collection based data

		ArrayList list = new ArrayList();
		list.add("Upender");
		list.add("reddy");

		extentreports.createTest("List based text")
		.log(Status.INFO, MarkupHelper.createOrderedList(list))
		.log(Status.INFO, MarkupHelper.createUnorderedList(list))
		.log(Status.PASS, "Test is Passed");

		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "Upender");
		map.put(101, "Reddy");
		extentreports.createTest("MAP based text").log(Status.INFO, MarkupHelper.createOrderedList(map))
				.log(Status.INFO, MarkupHelper.createUnorderedList(map)).log(Status.PASS, "Test is Passed");

		Set<String> set = new HashSet<String>();
		
		set.add("Upender");
		set.add("Reddy");
		extentreports
		.createTest("Set based text")
		.log(Status.INFO, MarkupHelper.createOrderedList(set))
		.log(Status.INFO, MarkupHelper.createUnorderedList(set))
		.log(Status.FAIL, "Test is Failed");
		
		
		// HighLight any message
		 
		extentreports
		.createTest("highlight text based test")
		.log(Status.INFO,MarkupHelper.createLabel("Log info text",ExtentColor.YELLOW))
		.info(MarkupHelper.createLabel("This is highlighted", ExtentColor.RED));
		
		
		//Exception based
		
	try {
		
		int i = 5/0;
	}catch (Exception e) {
		
		extentreports
		.createTest("Exception based test")
		.log(Status.INFO,e);
	}
	
		

		extentreports.flush();
		//Desktop.getDesktop().browse(new File(".\\reports\\Testreport.html").toURI());

	}
}
