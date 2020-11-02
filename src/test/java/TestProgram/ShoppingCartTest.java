package TestProgram;

import org.testng.annotations.DataProvider;
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

public class ShoppingCartTest extends DesiredCapability {
	public WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;

	@BeforeTest
	public void config() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\Reports\\logs.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@Test(dataProvider = "Authentication")
	public void ebayTest(String sUserName, String sPassword) throws Exception {
		test = extent.createTest("logsGeneration");
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\PageObjects\\base.properties");
		Properties p = new Properties();
		p.load(fs);

		AndroidDriver<AndroidElement> driver = Capabilities("ebaybuyapp");

		HomePage hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		test.log(Status.INFO, MarkupHelper.createLabel("Clicking on Sigin button", ExtentColor.ORANGE));
		hp.getSigninbtn().click();

		Signinpage sp = new Signinpage(driver);
		test.log(Status.INFO, MarkupHelper.createLabel("Sending email and password values", ExtentColor.GREY));
		sp.emailid().sendKeys(sUserName);
		sp.passwordenter().sendKeys(sPassword);
		test.log(Status.INFO, MarkupHelper.createLabel("Clicking on login button", ExtentColor.ORANGE));
		sp.loginbtnebay().click();
		sp.maybelaterbtn().click();

		LoginPage lp = new LoginPage(driver);
		lp.searchanything().click();
		test.log(Status.INFO, MarkupHelper.createLabel("Sending search text", ExtentColor.GREY));
		lp.searchboxebay().sendKeys(lp.getSearchTextFromBaseProps());
		lp.dropboxvalues();

		AddItemsToCart ad = new AddItemsToCart(driver);
		ad.closepopover();
		test.log(Status.INFO, MarkupHelper.createLabel("Clicking on item which was searched", ExtentColor.ORANGE));
		ad.itemtobeclicked().click();
		ad.setProductName(ad.verifyitemname().getText());
		ad.setProductPrice(ad.verifyitemprice().getText());
		System.out.println(ad.getProductName());
		System.out.println(ad.getProductPrice());
		test.log(Status.INFO, MarkupHelper.createLabel("Verifying product name and price", ExtentColor.BROWN));
		AssertJUnit.assertEquals(ad.getProductName(), ad.verifyitemname().getText());
		AssertJUnit.assertEquals(ad.getProductPrice(), ad.verifyitemprice().getText());
//		ad.scrollToText("Item description");
//		ad.scrollToCartBtn("Add to cart");
//		Thread.sleep(5000);
		ad.additemtocart().click();

		GoToCart go = new GoToCart(driver);
		Thread.sleep(5000);
		test.log(Status.INFO, MarkupHelper.createLabel("Clicking on gocartbtn", ExtentColor.ORANGE));
		go.gotocartebay().click();

		ShoppingCartPage sc = new ShoppingCartPage(driver);
		sc.setName(sc.verifyitemnameincart().getText());
		sc.setPrice(sc.verifyitempriceincart().getText());
		System.out.println(sc.getName());
		System.out.println(sc.getPrice());
		Assert.assertEquals(sc.getName(), sc.verifyitemnameincart().getText());
		Assert.assertEquals(sc.getPrice(), sc.verifyitempriceincart().getText());
		test.log(Status.INFO, MarkupHelper
				.createLabel("Verifying product name and price between cart and product screen", ExtentColor.BROWN));
		Assert.assertEquals(sc.getName(), ad.getProductName());
		Assert.assertEquals(sc.getPrice(), ad.getProductPrice());

	}

	@DataProvider(name = "Authentication")

	public Object[][] Authentication() throws Exception {

		Object[][] testObjArray = ExcelUtils.getTableArray(Constants.Path_TestData, "Sheet1");

		return (testObjArray);

	}

	@AfterTest
	public void tearDown() {
		extent.flush();
	}
}
