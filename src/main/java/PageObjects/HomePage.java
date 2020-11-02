package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class HomePage extends DesiredCapability{

	 public WebDriver driver;
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}



	 @FindBy(id = "com.ebay.mobile:id/button_sign_in")
	 private WebElement signinbtn;

	 public WebElement getSigninbtn() {
		// WebDriverWait w = new WebDriverWait(driver,10);
		// w.until(ExpectedConditions.visibilityOf(signinbtn));
		 return signinbtn;
	}

	 
	 
	
	 


}
