package TestProgram;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.annotations.Test;

import PageObjects.AddItemsToCart;
import PageObjects.DesiredCapability;
import PageObjects.GoToCart;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.ShoppingCartElementVerificationPage;
import PageObjects.ShoppingCartPage;
import PageObjects.Signinpage;
import TestData.Constants;
import TestData.ExcelUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseFunctions.Utils;

@Listeners(Utils.class)
public class ShoppingCartTest extends DesiredCapability {
	public WebDriver driver;
	
	ShoppingCartElementVerificationPage sce = new ShoppingCartElementVerificationPage();
	
	@BeforeTest
	public void config() {
		sce.setLogConfig();
	}

	@Test(dataProvider = "Authentication")
	public void ElementAdd(String sUserName, String sPassword) throws Exception {
		
		sce.ebayTest(sUserName, sPassword);
	}



	@AfterTest
	public void tearDown() {
		sce.tearDown();
	}

	@DataProvider(name = "Authentication")

	public Object[][] Authentication() throws Exception {

		Object[][] testObjArray = ExcelUtils.getTableArray(Constants.Path_TestData, "Sheet1");

		return (testObjArray);

	}
}
