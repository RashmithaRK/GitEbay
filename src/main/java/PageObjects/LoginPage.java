package PageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends DesiredCapability {

	public AndroidDriver driver;

	public LoginPage(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "com.ebay.mobile:id/search_box")
	private WebElement searchBox;

	@FindBy(id = "com.ebay.mobile:id/search_src_text")
	private WebElement searchBoxEnter;

	@FindBy(id = "com.ebay.mobile:id/text")
	private List<WebElement> dropDownOptions;

	public WebElement searchAnything() {

		return searchBox;

	}

	public WebElement searchBoxEbay() {

		return searchBoxEnter;

	}

	public String getSearchTextFromBaseProps() throws IOException {
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\PageObjects\\base.properties");
		Properties p = new Properties();
		p.load(fs);

		String searchText = (String) p.get("searchText");
		String[] arrOfStr = searchText.split(",", 0);
		System.out.println(arrOfStr);
		return arrOfStr[1];

	}

	public void dropBoxValues() throws InterruptedException {
		List<WebElement> options = driver.findElements(By.id("com.ebay.mobile:id/text"));
		int listSize = options.size();
		if (listSize == 0) {
			System.out.println("No results FOUND");
		} else if (listSize < 1) {
			options.get(0).click();
			Thread.sleep(10000);
		} else {
			options.get(listSize - 2).click();
			Thread.sleep(10000);
		}

		// for (WebElement webElement : options) {
		// System.out.println(webElement.getText());
		// if (webElement.getText().equalsIgnoreCase("samsung 65 inch qled tv")) {
		// webElement.click();
		// Thread.sleep(10000);
		// break;
		// }
		//
		// }
	}

}
