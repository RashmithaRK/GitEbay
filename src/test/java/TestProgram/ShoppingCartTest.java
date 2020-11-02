package TestProgram;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.net.MalformedURLException;
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

public class ShoppingCartTest extends DesiredCapability {
	public WebDriver driver;

	@Test(dataProvider = "Authentication")
	public void ebayTest(String sUserName, String sPassword) throws Exception {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement> driver = Capabilities("ebaybuyapp");
//		String sUserName = ExcelUtils.getCellData(1, 0);
//		String sPassword = ExcelUtils.getCellData(1, 1);
		HomePage hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		hp.getSigninbtn().click();
		Signinpage sp = new Signinpage(driver);
//		String sUserName = ExcelUtils.getCellData(1, 0);
//		String sPassword = ExcelUtils.getCellData(1, 1);
//		System.out.println(sUserName);
		sp.emailid().sendKeys(sUserName);
		sp.passwordenter().sendKeys(sPassword);
//		sp.emailid().sendKeys("rashrkp92@gmail.com");
//		sp.passwordenter().sendKeys("checkebay0!");
		sp.loginbtnebay().click();
		sp.maybelaterbtn().click();
		LoginPage lp = new LoginPage(driver);
		lp.searchanything().click();
		lp.searchboxebay().sendKeys("65 inch tv samsung");
		lp.dropboxvalues();

		AddItemsToCart ad = new AddItemsToCart(driver);

		ad.closepopover();
//            Thread.sleep(5000);
		// driver.switchTo().alert().dismiss();
		// System.out.println("source : "+ driver.getPageSource());
		ad.itemtobeclicked().click();

		ad.setProductName(ad.verifyitemname().getText());
		ad.setProductPrice(ad.verifyitemprice().getText());
		System.out.println(ad.getProductName());
		System.out.println(ad.getProductPrice());
		AssertJUnit.assertEquals(ad.getProductName(), ad.verifyitemname().getText());
		AssertJUnit.assertEquals(ad.getProductPrice(), ad.verifyitemprice().getText());

		ad.additemtocart().click();
		GoToCart go = new GoToCart(driver);
		Thread.sleep(5000);
		go.gotocartebay().click();
		ShoppingCartPage s = new ShoppingCartPage(driver);
		s.setName(s.verifyitemnameincart().getText());
		s.setPrice(s.verifyitempriceincart().getText());
		System.out.println(s.getName());
		System.out.println(s.getPrice());
		Assert.assertEquals(s.getName(), s.verifyitemnameincart().getText());
		AssertJUnit.assertEquals(s.getPrice(), s.verifyitempriceincart().getText());

		AssertJUnit.assertEquals(s.getName(), ad.getProductName());
		AssertJUnit.assertEquals(s.getPrice(), ad.getProductPrice());

	}

//	@DataProvider(name = "Authentication")
//
//	public static Object[][] credentials() {
//
//		return new Object[][] { { "rashrkp92@gmail.com", "checkebay0!" } };
//
//	}

	@DataProvider(name = "Authentication")

	public Object[][] Authentication() throws Exception {

		Object[][] testObjArray = ExcelUtils.getTableArray(Constants.Path_TestData, "Sheet1");

		return (testObjArray);

	}

}
