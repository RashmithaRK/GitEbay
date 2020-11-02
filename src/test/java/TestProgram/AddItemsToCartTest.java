package TestProgram;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import PageObjects.AddItemsToCart;
import PageObjects.DesiredCapability;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.Signinpage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

public class AddItemsToCartTest extends DesiredCapability {
	public WebDriver driver;

	@Test
	public static void main(String[] args) throws InterruptedException, IOException {
		

		AndroidDriver<AndroidElement> driver = Capabilities("ebaybuyapp");
		
		HomePage hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		hp.getSigninbtn().click();
		
		Signinpage sp = new Signinpage(driver);
		sp.emailid().sendKeys("rashrkp92@gmail.com");
		sp.passwordenter().sendKeys("checkebay0!");
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
		AssertJUnit.assertEquals(ad.getProductName(), ad.verifyitemname().getText());
		AssertJUnit.assertEquals(ad.getProductPrice(), ad.verifyitemprice().getText());
		ad.additemtocart().click();

	}

}
