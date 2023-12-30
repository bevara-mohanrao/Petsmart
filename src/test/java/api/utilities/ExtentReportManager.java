package api.utilities;

//import java.text.SimpleDatFormat();

import com.aventstack.extentreports.annotations.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Date;
import java.text.SimpleDateFormat;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.ExtentReports;

public class ExtentReportManager implements ITestListener{

	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext testContext)
	{
		
 //	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	//	repName = "Test-Report-"+timeStamp+".html";
		//repName = "Test-Report.html";
	//	sparkReporter = new ExtentSparkReporter("C://Mohan//Automation//eclipse//Workspace//JavaProgrammingPractice//Petsmart//report//"+repName);
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") +"/test-output/Test-Report.html");
		

		System.out.println("Report Path: " + sparkReporter.getFile());

		sparkReporter.config().setDocumentTitle("RestAssureAutomatioProject");
		sparkReporter.config().setReportName("Pet Store user API");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "Pet Store user API");
		extent.setSystemInfo("Operating System",System.getProperty("os.name"));
		extent.setSystemInfo("User Name",System.getProperty("user.name"));
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("user","Mohan");

	}
	
	public void onTestSuccess(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName()); 
		test.log(Status.PASS, "Test Passed");
	}
	
	public void onTestFailure(ITestResult result)
	{
	test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName()); 
		test.log(Status.FAIL, "Test Failed"); 
		test.log(Status.FAIL, result.getThrowable().getMessage());
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.createNode(result.getName()); 
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}
	
	public void onFinish(ITestResult testContext)
	{
		extent.flush();
	}
	
	
}
