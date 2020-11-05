package PageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class DesiredCapability {
	public static AndroidDriver<AndroidElement> driver;

	public static AndroidDriver<AndroidElement> Capabilities(String apkfile) throws IOException {

		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\PageObjects\\base.properties");
		Properties p = new Properties();
		p.load(fs);
		File appDir = new File("src/main/java/PageObjects");
		File app = new File(appDir, (String) p.get(apkfile));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		String device = (String) p.get("device");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
//		capabilities.setCapability(MobileCapabilityType.ORIENTATION, ScreenOrientation.LANDSCAPE);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		return driver;

	}

	public void failed(String testMethodName) {
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir") + "Git\\test-output\\Screenshots" + testMethodName + "_" + ".jpg"));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
