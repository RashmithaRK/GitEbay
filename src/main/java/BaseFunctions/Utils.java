package BaseFunctions;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import PageObjects.DesiredCapability;

public class Utils extends DesiredCapability implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		/*
		 * if (iTestResult != null) { String testName = iTestResult.getName();
		 * Log.addLog(testName + " is Passed..."); ExtentTest extent =
		 * ExtentReport.shared().getExtentTest(testName); ExtentReport.Log(extent,1); }
		 */
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("failed test");
		System.out.println(result);

		failed();

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Listeners.onStart()");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void assertStringItems(String actual, String expected) {
		Assert.assertEquals(actual, expected);
	}

	public void assertDoubleItems(double actual, double expected) {
		Assert.assertEquals(actual, expected);
	}

}
