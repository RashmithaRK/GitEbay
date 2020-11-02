package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Signinpage extends DesiredCapability {

	public AndroidDriver driver;
	private WebDriverWait wait;

	public Signinpage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new WebDriverWait(driver, 15, 50);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.EditText[@text='Email or username']")
	private WebElement email;

	@FindBy(xpath = "//android.widget.EditText[@text='Password']")
	private WebElement password;

	@FindBy(xpath = "//android.widget.Button[@text='Sign in']")
	private WebElement loginbtn;

	@FindBy(xpath = "//android.widget.Button[@text='Maybe later']")
	private WebElement maybelater;

	public WebElement emailid() {
		wait.until(ExpectedConditions.visibilityOf(email));
		return email;
	}

	public WebElement passwordenter() {
		wait.until(ExpectedConditions.visibilityOf(password));
		return password;
	}

	public WebElement loginbtnebay() {
		return loginbtn;
	}

	public WebElement maybelaterbtn() {
		return maybelater;
	}
}
