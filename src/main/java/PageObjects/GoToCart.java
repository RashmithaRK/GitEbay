package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class GoToCart extends DesiredCapability {

	public AndroidDriver driver;
	private WebDriverWait wait;

	public GoToCart(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new WebDriverWait(driver, 15, 50);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.Button[@text='Go to Cart']")
	private WebElement gotocart;

	public WebElement gotocartebay() {
		wait.until(ExpectedConditions.visibilityOf(gotocart));
		return gotocart;

	}

}
