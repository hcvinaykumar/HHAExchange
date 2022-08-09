package StepDefinitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Apphooks.Applicationhooks;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Apphooks.Applicationhooks;
import org.testng.Assert;

public class StepDefinitions {	
	
	AppiumDriver<MobileElement> driver;
	
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() throws MalformedURLException, InterruptedException {
	    System.out.println("I am inside Given");
	    
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
	    capabilities.setCapability(MobileCapabilityType.UDID, "R9ZT601B81D");
	    capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	    capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
	    capabilities.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES,true);	    
	    capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.hhaexchange.uma");
	    capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "crc64b783fcfd1529e85a.SplashActivity");
	    
	    URL url = new URL("http://0.0.0.0:4723/wd/hub");
	   
	    driver =  new AppiumDriver<MobileElement>(url,capabilities);
	    System.out.println("Application Launched");
	    Thread.sleep(3000);
	    //driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
	    Thread.sleep(5000);
	    Boolean Apply=driver.findElement(By.xpath("//android.widget.Button[@text ='Apply']")).isDisplayed();
	    System.out.println(Apply);
	    if(Apply = true) {
	    MobileElement   mobileElement =  (MobileElement) driver.findElement(By.xpath("//android.widget.Button[@text ='Apply']"));
	    WebDriverWait wait = new WebDriverWait(driver, 50);
	    wait.until(ExpectedConditions.visibilityOf(mobileElement));
		mobileElement.click();
	    }
	    
	    else
	    {
	    	System.out.println(Apply);
	    }
	    }

	
	@When("user reset app")
	public void user_reset_app() throws InterruptedException {
		driver.resetApp();
	}
	@When("user enters credentials")
	public void user_enters_credentials() throws InterruptedException {
		System.out.println("I am inside When");
		Thread.sleep(8000);
//		WebDriverWait wait = new WebDriverWait(driver, 50);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.view.ViewGroup[3]//android.widget.EditText"))));
		//MobileElement username=driver.findElement(By.xpath("//android.view.ViewGroup[3]//android.widget.EditText"));
		driver.findElement(By.xpath("//android.view.ViewGroup[3]//android.widget.EditText")).sendKeys("a@a.com");
		driver.findElement(By.xpath("//android.view.ViewGroup[3]//android.widget.EditText")).click();
		driver.findElement(By.xpath("//android.view.ViewGroup[4]//android.widget.EditText")).sendKeys("vinay");
		
	}

	@When("user clicks on Login")
	public void user_clicks_on_login() {
		System.out.println("I am inside when");		
		driver.findElement(By.xpath("//android.widget.Button[@text = 'Log In']")).click();		
	}

	@Then("user is on homepage")
	public void user_is_on_homepage() throws InterruptedException {
		System.out.println("I am inside Then");
		Thread.sleep(8000);
		MobileElement element = (MobileElement) driver.findElement(By.xpath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]"));		
		String value= element.getText();
		System.out.println(value);
		Boolean Enable = driver.findElement(By.xpath("//android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]")).isEnabled();
		System.out.println("Schedule is present in Homepage :"+Enable);
		
	}
	
	
	@When("user clicks on Sign_Up_Here button")
	public void user_clicks_on_Sign_Up_Here_button() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.Button[@text = 'Sign Up Here']")).click();
	}
	
	@When("user fills Email Address Password Confirm Password Fields")
	public void user_fills_Email_Address_Password_Confirm_Password_Fields() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.FrameLayout//android.widget.EditText")).sendKeys("a@a.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.FrameLayout//android.widget.EditText")).sendKeys("Test@1234");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.widget.FrameLayout//android.widget.EditText")).sendKeys("Test@1234");
	}
	
	@When("user clicks on Signup button")
	public void user_clicks_on_Sign_Up__button() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@text = 'Sign Up']")).click();
	}
	
	@When("user clicks on Email button for verification")
	public void user_clicks_on_Email_button_for_verification() throws InterruptedException {
		Thread.sleep(4000);
		//android.widget.Button[@text = '']
		driver.findElement(By.xpath("//android.widget.Button[@text = '']")).click();
	}
	
	@When("user selects Perfom EVV option")
	public void user_selects_Perfom_EVV_option() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Perform Electronic Visit Verification (EVV)']")).click();
	}
	
	@When("user enters verification code and click submit code")
	public void user_enters_verification_code_and_click_submit_code() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("1000S1");
		Thread.sleep(5000);
		 driver.findElement(By.xpath("//android.widget.Button[@text = 'Submit Code']")).click();
	}
	
	@When("user enter mandatory fields")
	public void user_enters_mandatory_fields() throws InterruptedException {
		Thread.sleep(5000);
		 driver.findElement(By.xpath("//android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.FrameLayout//android.widget.EditText")).sendKeys("Vinay");
		Thread.sleep(5000);
		 driver.findElement(By.xpath("//android.view.ViewGroup[2]//android.widget.EditText")).sendKeys("Kumar");
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.widget.FrameLayout//android.widget.EditText")).sendKeys("1234");
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//android.widget.Button[@text = '']")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.id("android:id/prev")).click();
		 driver.findElement(By.id("android:id/prev")).click();
		 driver.findElement(By.id("android:id/prev")).click();
		 driver.findElement(By.id("android:id/prev")).click();
		 driver.findElement(By.id("android:id/prev")).click();
		 driver.findElement(By.id("android:id/prev")).click();
		 driver.findElement(By.id("android:id/prev")).click();
		 driver.findElement(By.xpath("//android.view.View[@content-desc = '01 January 2022']")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.id("android:id/button1")).click();
		 }
	
	@When("user clicks on continue button")
	public void user_clicks_on_continue_button() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.Button[@text = 'Continue']")).click();
	}
	
	@When("user clicks on enable biometric ID")
	public void user_clicks_on_enable_biometric_ID() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.Button[@text = 'Enable Biometric ID']")).click();
	}
	
	@When("user clicks on Patients")
	public void user_clicks_on_Patients() throws InterruptedException {
		Thread.sleep(8000);
		 driver.findElement(By.xpath("//android.widget.TextView[@text = 'Patients']")).click();
	}
	
	@When("user enters patient name which is not in the list")
	public void user_enters_patient_name_which_is_not_in_the_list() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.EditText[@text = 'Search by Name or Address']")).sendKeys("abcd");
	}
	
	@Then("the page should contain patient is not in list")
	public void the_page_should_contain_patient_is_not_in_list() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text = 'No patients found for this search.']")).getText().contains("No patients found for this search."));
	}
	
	@When("user enters proper patient name")
	public void user_enters_proper_patient_name() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.Button[@text = '']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.EditText[@text = 'Search by Name or Address']")).sendKeys("Peters");
	}
	
	@Then("the result should contains patient name")
	public void the_result_should_contains_patient_name() throws InterruptedException {
		Thread.sleep(5000);
		   Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text = 'Peters Hobbs']")).getText().contains("Peters Hobbs"));
	}
}

