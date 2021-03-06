package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;

public class ShoppingCartPage extends DesiredCapability {

	double price;
	String name;
	public AndroidDriver driver;

	public ShoppingCartPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.ebay.mobile:id/item_details")
	private WebElement shoppingCartItem;

	@FindBy(id = "com.ebay.mobile:id/item_title")
	private WebElement itemNameCart;

	@FindBy(id = "com.ebay.mobile:id/item_price")
	private WebElement itemPriceCart;

	public WebElement shoppingcartitemclick() {

		return shoppingCartItem;

	}

	public WebElement verifyitemnameincart() {

		return itemNameCart;

	}

	public WebElement verifyitempriceincart() {

		return itemPriceCart;

	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
}
