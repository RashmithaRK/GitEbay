package TestProgram;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PageObjects.DesiredCapability;
import PageObjects.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HomePageTest extends DesiredCapability{
	public WebDriver driver;


	@Test
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		 
		AndroidDriver<AndroidElement>  driver = Capabilities("ebaybuyapp");
		HomePage hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		hp.getSigninbtn().click();
	    System.out.println(driver.getContextHandles());
	    System.out.println("source : "+ driver.getPageSource());
		
	}

}
