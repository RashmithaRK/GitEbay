package BaseFunctions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import PageObjects.DesiredCapability;
import PageObjects.ShoppingCartElementVerification;
import io.appium.java_client.android.AndroidDriver;

public class Utils extends DesiredCapability implements ITestListener {

	public AndroidDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("failed test");
		failed(result.getMethod().getMethodName());

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
