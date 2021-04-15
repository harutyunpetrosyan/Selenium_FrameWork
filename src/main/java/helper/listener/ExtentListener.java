package helper.listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import helper.logger.LoggerHelper;

public class ExtentListener implements ITestListener{
    private Logger log = LoggerHelper.getLogger(ExtentListener.class);
    
	public static ExtentReports extent;
	public static ExtentTest test;

	public void onFinish(ITestContext arg0) {
        log.info(arg0.getName()+" Test Finished..");
	}

	public void onStart(ITestContext arg0) {
		log.info(arg0.getCurrentXmlTest().getName()+" Class Started..");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	public void onTestFailure(ITestResult arg0) {

		log.error(arg0.getMethod().getMethodName()+" Test Failed.."+arg0.getThrowable());
	}

	public void onTestSkipped(ITestResult arg0) {
		log.warn(arg0.getMethod().getMethodName()+" Test Skipped.."+arg0.getThrowable());
	}

	public void onTestStart(ITestResult arg0) {
		log.info(arg0.getMethod().getMethodName()+" Test Started..");
	}

	public void onTestSuccess(ITestResult arg0) {
		log.info(arg0.getMethod().getMethodName()+" Test Passed..");
	}

}
