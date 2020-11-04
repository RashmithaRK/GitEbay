package PageObjects;

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

import BaseFunctions.Utils;

public class ShoppingCartElementVerificationPage extends DesiredCapability {
	public WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	public void setLogConfig() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\Reports\\logs.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		test = extent.createTest("logsGeneration");
	}

	public void ebayTest(String sUserName, String sPassword) throws Exception {
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\PageObjects\\base.properties");
		Properties p = new Properties();
		p.load(fs);
		

		AndroidDriver<AndroidElement> driver = Capabilities("ebaybuyapp");
		HomePage hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		test.log(Status.INFO, MarkupHelper.createLabel("Clicking on Sigin button", ExtentColor.ORANGE));
		hp.getSignInBtn().click();

		Signinpage sp = new Signinpage(driver);
		// test.log(Status.INFO, MarkupHelper.createLabel("Sending email and password
		// values", ExtentColor.GREY));
		sp.emailId().sendKeys(sUserName);
		sp.passwordEnter().sendKeys(sPassword);
		test.log(Status.INFO, MarkupHelper.createLabel("Clicking on login button", ExtentColor.ORANGE));
		sp.logInBtnEbay().click();
		sp.mayBeLaterBtn().click();

		LoginPage lp = new LoginPage(driver);
		lp.searchAnything().click();
		test.log(Status.INFO, MarkupHelper.createLabel("Sending search text", ExtentColor.GREY));
		lp.searchBoxEbay().sendKeys(lp.getSearchTextFromBaseProps());
		lp.dropBoxValues();

		AddItemsToCart ad = new AddItemsToCart(driver);
		ad.closePopover();
		test.log(Status.INFO, MarkupHelper.createLabel("Clicking on item which was searched", ExtentColor.ORANGE));
		ad.itemToBeClicked().click();
		ad.setProductName(ad.verifyItemName().getText());
		ad.setProductPrice(ad.getPrice(ad.verifyItemPrice().getText()));
		System.out.println(ad.getProductName());
		System.out.println(ad.getProductPrice());
		test.log(Status.INFO, MarkupHelper.createLabel("Verifying product name and price", ExtentColor.BROWN));
//		Assert.assertEquals(ad.getProductName(), itemNameTemp);
//		Assert.assertEquals(ad.getProductPrice(), itemPriceTemp);
//		ad.scrollToText("Item description");
//		ad.scrollToCartBtn("Add to cart");
		ad.addItemToCart().click();

		GoToCart go = new GoToCart(driver);
		Thread.sleep(5000);
		test.log(Status.INFO, MarkupHelper.createLabel("Clicking on gocartbtn", ExtentColor.ORANGE));
		go.goToCartEbay().click();

		ShoppingCartPage sc = new ShoppingCartPage(driver);
		sc.setName(sc.verifyitemnameincart().getText());
		sc.setPrice(ad.getPrice(sc.verifyitempriceincart().getText()));
		System.out.println(sc.getName());
		System.out.println(sc.getPrice());
//		Assert.assertEquals(sc.getName(), sc.verifyitemnameincart().getText());
//		Assert.assertEquals(sc.getPrice(), sc.verifyitempriceincart().getText());
		test.log(Status.INFO, MarkupHelper
				.createLabel("Verifying product name and price between cart and product screen", ExtentColor.BROWN));
		
		Utils util = new Utils();
		util.assertStringItems(sc.getName(), ad.getProductName());
		util.assertDoubleItems(sc.getPrice(), ad.getProductPrice());
		//Assert.assertEquals(sc.getName(), ad.getProductName());
		//Assert.assertEquals(sc.getPrice(), ad.getProductPrice());

	}

	public void tearDown() {
		extent.flush();
	}
}
