package BaseClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Baseclass {
	
	public static AppiumDriver<MobileElement> driver;

	

	public static AppiumDriver<MobileElement> getDriver()  {
		try {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
	    capabilities.setCapability(MobileCapabilityType.UDID, "R9ZT601B81D");
	    capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	    capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.hhaexchange.uma");
	    capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "crc64b783fcfd1529e85a.SplashActivity");
	    
	    URL url = new URL("http://0.0.0.0:4723/wd/hub");
	    driver = new AppiumDriver<MobileElement>(url,capabilities);
	    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}
	
	public Baseclass(AppiumDriver<MobileElement> driver) {
		this.driver=driver;
	}
	
}
