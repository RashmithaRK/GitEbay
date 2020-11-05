package TestProgram;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import PageObjects.DesiredCapability;
import PageObjects.ShoppingCartElementVerification;
import TestData.Constants;
import TestData.ExcelUtils;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import BaseFunctions.Utils;

@Listeners(Utils.class)
public class ShoppingCartTest extends DesiredCapability {
	public AndroidDriver driver;	
	ShoppingCartElementVerification sce = new ShoppingCartElementVerification(driver);
	
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
