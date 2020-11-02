package PageObjects;



	import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.AndroidElement;

	public class LoginPage  extends DesiredCapability{

		 public AndroidDriver driver;
		public LoginPage(AndroidDriver driver) {
			// TODO Auto-generated constructor stub
			 this.driver=driver;
			 PageFactory.initElements(driver, this);
		}



		 @FindBy(id = "com.ebay.mobile:id/search_box")
		 private WebElement searchbox;
		 
		 @FindBy(id = "com.ebay.mobile:id/search_src_text")
		 private WebElement searchboxenter;
		 
		 @FindBy(id = "com.ebay.mobile:id/text")
		 private List<WebElement> dropdownoptions;
		 
		 
	

		 public WebElement searchanything() {
				
			 return searchbox;
			 
		}
		 
		 public WebElement searchboxebay() {
				
			 return searchboxenter;
			 
		}
		 
		public void dropboxvalues() throws InterruptedException
		{
			List<WebElement> options = driver.findElements(By.id("com.ebay.mobile:id/text"));	
			System.out.println("check1");
			for (WebElement webElement : options) {
				System.out.println(webElement.getText());
				if(webElement.getText().equalsIgnoreCase("samsung 65 inch qled tv"))
						{
					webElement.click();
					Thread.sleep(10000);
					       break;
						}
				
			}
		}
		 
		
		 }

