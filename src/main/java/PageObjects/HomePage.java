package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends DesiredCapability{

	 public WebDriver driver;
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	}



	 @FindBy(id = "com.ebay.mobile:id/button_sign_in")
	 private WebElement signInBtn;

	 public WebElement getSignInBtn() {
		 return signInBtn;
	}

	 
	 
	
	 


}
