package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Exreport {
	
    private static ExtentReports extentReports;
    
    public static ExtentReports createinstance(String filename,String DocumentTitle,String Reportname) {
    	ExtentSparkReporter ESR= new ExtentSparkReporter(filename);
    	ESR.config().setDocumentTitle(DocumentTitle);
    	ESR.config().setReportName(Reportname);
    	ESR.config().setTheme(Theme.DARK);
        ESR.config().setEncoding("UTF-8");

        extentReports = new ExtentReports();
        extentReports.attachReporter(ESR);
        
        
		return extentReports;
}
    
	

}
