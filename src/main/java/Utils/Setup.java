package Utils;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Setup implements ITestListener {
	public static ExtentReports extentreports;
    static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	@Override
	 public void onStart(ITestContext context) {
		 String filename=System.getProperty("user.dir") + "//Extentreport//"  + "filename.html";
		 extentreports=Exreport.createinstance(filename, "report", "testingreport");
		    // not implemented
		  }
	
	@Override
	public void onFinish(ITestContext context) {
		if(extentreports!=null) {
		
			extentreports.flush();
		try {
			Desktop.getDesktop().browse(new File("fullReportPath").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
	}
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test=extentreports.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	
		}
	@Override
	public void onTestSuccess(ITestResult result) {
		if(extentTest.get()!=null) {
			extentTest.get().pass("Test passed");
		}
		}
		@Override
		public void onTestFailure(ITestResult result) {
			if(extentTest.get()!=null) {
				extentTest.get().fail(result.getThrowable());
				
			}
		
		}
	
}
