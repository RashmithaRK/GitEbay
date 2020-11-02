package PageObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import java.time.Duration;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class GoToCart  extends DesiredCapability{

	 public AndroidDriver driver;
	public GoToCart(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}



	 @FindBy(xpath = "//android.widget.Button[@text='Go to Cart']")
	 private WebElement gotocart;
	 
	 
	
	 public WebElement gotocartebay() {
			
		 return gotocart;
		 
	}
	 
}
	 