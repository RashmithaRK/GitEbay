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
		

		AndroidDriver<AndroidElement> driver = Capabilities("ebaybuyapp");

		HomePage hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		hp.getSigninbtn().click();
		
		Signinpage sp = new Signinpage(driver);
		sp.emailid().sendKeys(sUserName);
		sp.passwordenter().sendKeys(sPassword);
		sp.loginbtnebay().click();
		sp.maybelaterbtn().click();

		LoginPage lp = new LoginPage(driver);
		lp.searchanything().click();
		lp.searchboxebay().sendKeys("65 inch tv samsung");
		lp.dropboxvalues();

		AddItemsToCart ad = new AddItemsToCart(driver);
		ad.closepopover();
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

		ShoppingCartPage sc = new ShoppingCartPage(driver);
		sc.setName(sc.verifyitemnameincart().getText());
		sc.setPrice(sc.verifyitempriceincart().getText());
		System.out.println(sc.getName());
		System.out.println(sc.getPrice());
		Assert.assertEquals(sc.getName(), sc.verifyitemnameincart().getText());
		Assert.assertEquals(sc.getPrice(), sc.verifyitempriceincart().getText());

		Assert.assertEquals(sc.getName(), ad.getProductName());
		Assert.assertEquals(sc.getPrice(), ad.getProductPrice());

	}

	@DataProvider(name = "Authentication")

	public Object[][] Authentication() throws Exception {

		Object[][] testObjArray = ExcelUtils.getTableArray(Constants.Path_TestData, "Sheet1");

		return (testObjArray);

	}

}
