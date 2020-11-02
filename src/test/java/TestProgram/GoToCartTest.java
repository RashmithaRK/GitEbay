package TestProgram;

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
import PageObjects.Signinpage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

public class GoToCartTest extends DesiredCapability {
	public WebDriver driver;

	@Test
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

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
//            Thread.sleep(5000);
		// driver.switchTo().alert().dismiss();
		// System.out.println("source : "+ driver.getPageSource());
		ad.itemtobeclicked().click();
		ad.verifyitemname();
		ad.verifyitemname();
		ad.additemtocart().click();
		GoToCart go = new GoToCart(driver);
		go.gotocartebay();

	}

}