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

public class AddItemsToCart extends DesiredCapability {

	public AndroidDriver driver;
	String productPrice;
	String productName;

	public AddItemsToCart(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.ebay.mobile:id/cell_collection_item")
	private WebElement itemclick;

	@FindBy(id = "com.ebay.mobile:id/text_slot_1")
	private WebElement popoverclose;

	@FindBy(id = "com.ebay.mobile:id/textview_item_name")
	private WebElement itemname;

	@FindBy(id = "com.ebay.mobile:id/textview_item_price")
	private WebElement itemprice;

	@FindBy(xpath = "//android.widget.TextView[@text='Item description from the seller']")
	private WebElement itemdesc;

	@FindBy(xpath = "//android.widget.Button[@text='Add to cart']")
	private WebElement addtocart;

	public WebElement itemtobeclicked() {

		return itemclick;

	}

	public WebElement verifyitemname() {

		return itemname;

	}

	public WebElement verifyitemprice() {

		return itemprice;

	}

	public WebElement verifyitemdesc() {

		return itemdesc;

	}

	public void closepopover() {

		new TouchAction(driver).tap(element(driver.findElementById("com.ebay.mobile:id/text_slot_1"))).perform();
	}

	public WebElement additemtocart() {

		return addtocart;

	}
	
	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	// Tap to an element for 250 milliseconds

	/*
	 * public void scrolltodesc() { try{
	 * driver.findElement(MobileBy.AndroidUIAutomator(new UiScrollable(new
	 * UiSelector().
	 * resourceId("//android.widget.TextView[@text='Item description from the seller']"
	 * )).scrollForward())); }catch(Exception exception){ //ignore error }
	 * driver.findElement(MobileBy.
	 * AndroidUIAutomator("new UiScrollable(new UiSelector().description(\""
	 * +parentScrollViewId+"\")).scrollForward()"));
	 */
// new TouchAction(driver).
	// .scroll(driver.findElementByXPath("//android.widget.TextView[@text='Item
	// description from the seller']"), 10, 100);
	// .perform();

}
