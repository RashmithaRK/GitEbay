package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;

public class ShoppingCartPage extends DesiredCapability {

	String price;
	String name;
	public AndroidDriver driver;

	public ShoppingCartPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.ebay.mobile:id/item_details")
	private WebElement shoppingcartitem;

	@FindBy(id = "com.ebay.mobile:id/item_title")
	private WebElement itemnamecart;

	@FindBy(id = "com.ebay.mobile:id/item_price")
	private WebElement itempricecart;

	public WebElement shoppingcartitemclick() {

		return shoppingcartitem;

	}

	public WebElement verifyitemnameincart() {

		return itemnamecart;

	}

	public WebElement verifyitempriceincart() {

		return itempricecart;

	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
}
