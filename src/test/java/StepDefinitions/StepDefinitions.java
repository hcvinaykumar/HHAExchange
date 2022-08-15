package StepDefinitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

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
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
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
		Thread.sleep(5000);
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
		Thread.sleep(3000);
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
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.FrameLayout//android.widget.EditText")).sendKeys("Test@1234");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.widget.FrameLayout//android.widget.EditText")).sendKeys("Test@1234");
	}
	
	@When("user enters Email Address")
	public void user_enters_Email_Address() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.FrameLayout//android.widget.EditText")).sendKeys("a@a.com");
	}
	
	@When("user enters different Password on Confirm Password field")
	public void user_enters_different_Password_on_Confirm_Password_field() throws InterruptedException {
		driver.findElement(By.xpath("//android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.FrameLayout//android.widget.EditText")).sendKeys("Test@1234");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//android.widget.ScrollView/android.view.ViewGroup")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.widget.FrameLayout//android.widget.EditText")).sendKeys("test@1234");
			}
	
	@Then("appropriate error message should appear")
	public void appropriate_error_message_should_appear() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text = 'Confirm Password must match Password']")).getText().contains("Confirm Password must match Password"));
	}
	
	@Then("User should land on Sign_Up form")
	public void User_should_land_on_Sign_Up_form() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text = 'Sign Up']")).getText().contains("Sign Up"));
	}
	
	@Then("user should land on Registration form")
	public void User_should_land_on_Registration_form() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text = 'Complete Registration']")).getText().contains("Complete Registration"));
	}
	
	@When("user clicks on Signup button")
	public void user_clicks_on_Sign_Up__button() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@text = 'Sign Up']")).click();
	}
	
	@When("user clicks on Email button for verification")
	public void user_clicks_on_Email_button_for_verification() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@text = '']")).click();
	}
	
	@When("user selects Perfom EVV option")
	public void user_selects_Perfom_EVV_option() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Perform Electronic Visit Verification (EVV)']")).click();
		//Thread.sleep(5000);
	}
	
	@When("user enters verification code and click submit code")
	public void user_enters_verification_code_and_click_submit_code() throws InterruptedException {
		//Thread.sleep(4000);
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("1000S1");
		Thread.sleep(3000);
		 driver.findElement(By.xpath("//android.widget.Button[@text = 'Submit Code']")).click();
	}
	
	@When("user enters two mandatory fields only")
	public void user_enters_two_mandatory_fields() throws InterruptedException {
		//Thread.sleep(2000);
		 driver.findElement(By.xpath("//android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.FrameLayout//android.widget.EditText")).sendKeys("Vinay");
		//Thread.sleep(2000);
		 driver.findElement(By.xpath("//android.view.ViewGroup[2]//android.widget.EditText")).sendKeys("Kumar");
		 
	}
	
	@Then("User should receive an error message")
	public void User_should_receive_an_error_message() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text = 'This field is required']")).getText().contains("This field is required"));
	}
	
	@When("user enter mandatory fields")
	public void user_enters_mandatory_fields() throws InterruptedException {
		Thread.sleep(1000);
		 driver.findElement(By.xpath("//android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.FrameLayout//android.widget.EditText")).sendKeys("Vinay");
		//Thread.sleep(1000);
		 driver.findElement(By.xpath("//android.view.ViewGroup[2]//android.widget.EditText")).sendKeys("Kumar");
		//Thread.sleep(1000);
		 driver.findElement(By.xpath("//android.view.ViewGroup[3]/android.view.ViewGroup[1]/android.widget.FrameLayout//android.widget.EditText")).sendKeys("1234");
		// Thread.sleep(1000);
		 driver.findElement(By.xpath("//android.widget.Button[@text = '']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.id("android:id/prev")).click();
		 driver.findElement(By.id("android:id/prev")).click();
		 driver.findElement(By.id("android:id/prev")).click();
		 driver.findElement(By.id("android:id/prev")).click();
		 driver.findElement(By.id("android:id/prev")).click();
		 driver.findElement(By.id("android:id/prev")).click();
		 driver.findElement(By.id("android:id/prev")).click();
		 driver.findElement(By.xpath("//android.view.View[@content-desc = '01 January 2022']")).click();
		 Thread.sleep(1000);
		 driver.findElement(By.id("android:id/button1")).click();
		 }
	
	@When("user clicks on continue button")
	public void user_clicks_on_continue_button() throws InterruptedException {
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.Button[@text = 'Continue']")).click();
	}
	
	@When("user clicks on enable biometric ID")
	public void user_clicks_on_enable_biometric_ID() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.Button[@text = 'Enable Biometric ID']")).click();
	}
	
	@When("user clicks on Patients")
	public void user_clicks_on_Patients() throws InterruptedException {
		Thread.sleep(8000);
		 driver.findElement(By.xpath("//android.widget.TextView[@text = 'Patients']")).click();
	}
	
	@When("user enters invalid patient name")
	public void user_enters_invalid_patient_name () throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.EditText[@text = 'Search by Name or Address']")).sendKeys("abcd");
	}
	
	@Then("Error message should be displayed accordingly")
	public void Error_message_should_be_displayed_accordingly() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text = 'No patients found for this search.']")).getText().contains("No patients found for this search."));
	}
	
	@When("user enters valid patient name")
	public void user_enters_valid_patient_name() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.EditText[@text = 'Search by Name or Address']")).sendKeys("Peters");
	}
	
	@Then("result should match with search criteria")
	public void result_should_match_with_search_criteria() throws InterruptedException {
		Thread.sleep(2000);
		   Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text = 'Peters Hobbs']")).getText().contains("Peters Hobbs"));
	}
	
	@When("Verify Sign_Up_Here is visible")
	public void Verify_Sign_Up_Here_is_visible() throws InterruptedException {
		Thread.sleep(2000);
		Boolean Signup=driver.findElement(By.xpath("//android.widget.Button[@text = 'Sign Up Here']")).isEnabled();
		System.out.println("Signup button Enabled:" +Signup);
		
	}
	
	
	@Then("the page should contain Email button for verification")
	public void the_page_should_contain_Email_button_for_verification() throws InterruptedException {
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text = 'Email Verification Required']")).getText().contains("Email Verification Required"));
	}
	
	@When("user Click on the patient details")
	public void user_Click_on_the_patient_details() throws InterruptedException {
		Thread.sleep(8000);
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Patient Details']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.Button[@text = '']")).click();		
	}
	
	@When("user Click on the Clock In button")
	public void user_Click_on_the_Clock_In_button() {
		driver.findElement(By.xpath("//android.widget.Button[@text = 'Clock In']")).click();		
	}
	
	@Then("user should land on Electronic Visit Verification screen")
	public void user_should_land_on_Electronic_Visit_Verification_screen() {
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[@text = 'Electronic Visit Verification']")).getText().contains("Electronic Visit Verification"));		
	}
	@When("Click on continue")
	public void Click_on_continue() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.Button[@text = 'Continue']")).click();		
	}
	
	@When("User Do the signature and Click on Submit")
	public void User_Do_the_signature_and_Click_on_Submit() throws InterruptedException {
		Thread.sleep(1000);
		(new TouchAction(driver)).press(PointOption.point(510,363))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
		.moveTo(PointOption.point(715,465)).release().perform();
		
		(new TouchAction(driver)).press(PointOption.point(448,403))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
		.moveTo(PointOption.point(608,273)).release().perform();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.Button[@text = 'Submit']")).click();
	}
	
	@When("User Do the patient signature and Click on Submit")
	public void User_Do_the_patient_signature_and_Click_on_Submit() throws InterruptedException {
		Thread.sleep(1000);
		(new TouchAction(driver)).press(PointOption.point(528,373))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
		.moveTo(PointOption.point(673,488)).release().perform();
		Thread.sleep(1000);
		(new TouchAction(driver)).press(PointOption.point(678,478))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
		.moveTo(PointOption.point(763,300)).release().perform();
		
		Thread.sleep(000);
		driver.findElement(By.xpath("//android.widget.Button[@text = 'Submit']")).click();
	}
	
	@When("User Do the caregiver signature and Click on Submit")
	public void User_Do_the_caregiver_signature_and_Click_on_Submit() throws InterruptedException {
		Thread.sleep(1000);
		(new TouchAction(driver)).press(PointOption.point(153,478))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
		.moveTo(PointOption.point(263,300)).release().perform();
		
		(new TouchAction(driver)).press(PointOption.point(678,478))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
		.moveTo(PointOption.point(763,300)).release().perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.Button[@text = 'Submit']")).click();
	}
	
	@When("User Record patient voice and click on stop recording")
	public void User_Record_patient_voice_and_click_on_stop_recording() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Record']")).click();
		//Thread.sleep(2000);
	  //  driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
	//	Thread.sleep(3000);
		//driver.findElement(By.xpath("//android.widget.Button[@text = 'Allow']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'Stop Recording']")).click();
		
	}
	
	@When("Click on done")
	public void Click_on_done() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@text = 'Done']")).click();
	}
	
	@When("User Fill the mandatory fields as well as value")
	public void User_Fill_the_mandatory_fields_as_well_as_value() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.widget.FrameLayout//android.widget.Button[@text = '']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("7");
		driver.findElement(By.xpath("//android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.FrameLayout//android.widget.Button[@text = '']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text = '']")).click();
        Thread.sleep(2000);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.xpath("//android.view.ViewGroup[3]//android.widget.Button[@text = '']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.ViewGroup[3]//android.widget.EditText")).sendKeys("7");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.RelativeLayout/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup")).click();
		
	}
	@Then("click on Clock out")
	public void click_on_Clock_out() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@text = 'Clock Out']")).click();
		
	}
	
	@When("user enters invalid credentials")
	public void user_enters_invalid_credentials() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.view.ViewGroup[3]//android.widget.EditText")).sendKeys("vinay@a.com");
		driver.findElement(By.xpath("//android.view.ViewGroup[3]//android.widget.EditText")).click();
		driver.findElement(By.xpath("//android.view.ViewGroup[4]//android.widget.EditText")).sendKeys("vinay");		
	}
	
	@Then("Appropriate Error message should come for the required fields")
	public void Appropriate_Error_message_should_come_for_the_required_fields() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.xpath("//android.view.ViewGroup[3]//android.widget.TextView[@text = 'This field is required']")).getText().contains("This field is required"));
		Assert.assertTrue(driver.findElement(By.xpath("//android.view.ViewGroup[4]//android.widget.TextView[@text = 'This field is required']")).getText().contains("This field is required"));
		
	}
	
	@Then("appropriate error must appear")
	public void appropriate_error_must_appear() throws InterruptedException {
		Thread.sleep(2000);
		MobileElement Invalid = driver.findElement(By.xpath("//android.view.ViewGroup[3]//android.widget.TextView[@text = 'Invalid credentials']"));
	    Assert.assertTrue(Invalid.getText().contains("Invalid credentials"));
		
	}
	
	@When("user click on search button")
	public void user_click_on_search_button() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@text = '']")).click();
	}
	
	@When("user enters Patient Name")
	public void user_enters_Patient_Name() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("Peters");
	}
	
	@When("user selects Date Range")
	public void user_selects_Date_Range() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView[@text = 'mm/dd/yyyy']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/prev")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.View[@content-desc = '02 July 2022']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.TextView[@text = 'mm/dd/yyyy']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.view.View[@content-desc = '02 August 2022']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(2000);		
		
	}
	
	@When("user clicks on Search")
	public void user_clicks_on_Search() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@text = 'Search']")).click();
	}
	
	@Then("Result should match with patient name")
	public void Result_should_match_with_patient_name() {
		MobileElement Patientname = driver.findElement(By.xpath("//android.widget.TextView[@text = 'Peters']"));
		
	    Assert.assertTrue(Patientname.getText().contains("Peters"));
	System.out.println("Patient Result");
	}
	
}

