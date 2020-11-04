package TestProgram;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import PageObjects.DesiredCapability;
import PageObjects.HomePage;
import PageObjects.SignInPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SignInTest extends DesiredCapability {
	public WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		

		AndroidDriver<AndroidElement> driver = Capabilities("ebaybuyapp");
		
		HomePage hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		hp.getSignInBtn().click();
		
		SignInPage sp = new SignInPage(driver);
		sp.emailId().sendKeys("rashrkp92@gmail.com");
		sp.passwordEnter().sendKeys("checkebay0!");
		sp.logInBtnEbay().click();
		sp.mayBeLaterBtn().click();

	}

}
