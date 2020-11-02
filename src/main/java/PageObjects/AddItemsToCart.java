package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
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

	@FindBy(id =  "com.ebay.mobile:id/vertical_container_inner_viewgroup")
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

	public void scrollToText(String text)
	{
	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
	}

	public WebElement gettextafterscroll()
	{
		return itemdesc;
	}
	
	public void scrollToCartBtn(String text)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"+".scrollToBeginning(55);");
	}
}

