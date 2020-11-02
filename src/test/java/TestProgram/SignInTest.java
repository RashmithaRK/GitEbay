package TestProgram;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import PageObjects.DesiredCapability;
import PageObjects.HomePage;
import PageObjects.Signinpage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SignInTest extends DesiredCapability {
	public WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		

		AndroidDriver<AndroidElement> driver = Capabilities("ebaybuyapp");
		
		HomePage hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		hp.getSigninbtn().click();
		
		Signinpage sp = new Signinpage(driver);
		sp.emailid().sendKeys("rashrkp92@gmail.com");
		sp.passwordenter().sendKeys("checkebay0!");
		sp.loginbtnebay().click();
		sp.maybelaterbtn().click();

	}

}
