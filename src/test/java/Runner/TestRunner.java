package Runner;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.cucumber.gherkin.internal.com.eclipsesource.json.ParseException;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Test Runner file to run the test cases based on given parameters.
 */

@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"StepDefinitions","Apphooks"},
		dryRun = false,
		plugin = {"pretty", "html:target/cucumber-reports",				
				"timeline:test-output-thread/"
		},
		monochrome = true
		)

@Test
public class TestRunner extends AbstractTestNGCucumberTests {
	
	

}
