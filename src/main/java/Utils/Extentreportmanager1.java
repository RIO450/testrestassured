package Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentreportmanager1 implements ITestListener{
	
	public static ExtentSparkReporter ESR;
	public static ExtentReports ER;
	public ExtentTest ET;

	
	
	public  void onStart(ITestContext context) {
		
	    String reportDirPath = System.getenv("user.dir");

		ESR=new ExtentSparkReporter(reportDirPath+"/myreports.html");
				ESR.config().setDocumentTitle("Restassured");
		ESR.config().setReportName("postivetestcases");
		ESR.config().setTheme(Theme.DARK);
		ER= new ExtentReports();
		ER.attachReporter(ESR);
		ER.setSystemInfo("COMPUTERBANE","WINODWNS");
		ER.setSystemInfo("author", "raji");
		
	}
	public  void onTestSuccess(ITestResult result) {
		ET=ER.createTest(result.getName());
		ET.log(Status.PASS,"test cae passed"+result.getName());
	  }
	public  void onTestFailure(ITestResult result) {
		ET=ER.createTest(result.getName());
		ET.log(Status.FAIL,"testcase failed"+result.getThrowable());
		ET.log(Status.FAIL,"testcase failed"+result.getName());
	  }
	public  void onFinsh(ITestContext context) {
		 ER.flush();
		
	}

}
