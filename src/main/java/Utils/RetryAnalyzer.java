package Utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.IRetryAnalyzer;

public class RetryAnalyzer implements IRetryAnalyzer {
	 public int count=0;
	 
	 public static final int maxRetryCount=3;
	


	@Override
	public boolean retry(ITestResult result) {
		if (count< maxRetryCount) {
			count++;
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}
