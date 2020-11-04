package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class AddItemsToCart extends DesiredCapability {

	public AndroidDriver driver;
	double productPrice;
	String productName;

	public AddItemsToCart(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.ebay.mobile:id/cell_collection_item")
	private WebElement itemClick;

	@FindBy(id = "com.ebay.mobile:id/text_slot_1")
	private WebElement popOverClose;

	@FindBy(id = "com.ebay.mobile:id/textview_item_name")
	private WebElement itemName;

	@FindBy(id = "com.ebay.mobile:id/textview_item_price")
	private WebElement itemPrice;

	@FindBy(id = "com.ebay.mobile:id/vertical_container_inner_viewgroup")
	private WebElement itemDesc;

	@FindBy(xpath = "//android.widget.Button[@text='Add to cart']")
	private WebElement addToCart;

	public WebElement itemToBeClicked() {

		return itemClick;

	}

	public WebElement verifyItemName() {

		return itemName;

	}

	public WebElement verifyItemPrice() {

		return itemPrice;

	}

	public WebElement verifyItemDesc() {

		return itemDesc;

	}

	public void closePopover() {

		new TouchAction(driver).tap(element(driver.findElementById("com.ebay.mobile:id/text_slot_1"))).perform();
	}

	public WebElement addItemToCart() {
		String screenData = driver.getOrientation().value();
		if (screenData.toLowerCase() == "landscape") {
			driver.findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + "Add to cart" + "\"));");
		}
		return addToCart;

	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void scrollToText(String text) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
	}

	public WebElement gettextafterscroll() {
		return itemDesc;
	}

	public void scrollToCartBtn(String text) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true))" + ".scrollToBeginning(55);");
	}

	public double getPrice(String itemPriceProductPage) {
		String tempString = "";
		if(itemPriceProductPage.contains("US")) {
			tempString = itemPriceProductPage.substring(4);
		}else {
			tempString = itemPriceProductPage.substring(1);
		}
		
		double itemPriceProductPageCheck = Double.parseDouble(tempString);
		return itemPriceProductPageCheck;
	}
}
