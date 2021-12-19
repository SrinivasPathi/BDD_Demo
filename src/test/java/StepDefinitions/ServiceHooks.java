package StepDefinitions;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.cucumber.listener.Reporter;

import enums.Browsers;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.messages.types.Source.MediaType;
import testBase.TestBase;






public class ServiceHooks {

	TestBase testBase;

	
	@Before
	public void initializeTest() {
		testBase = new TestBase();
		testBase.selectBrowser(Browsers.CHROME.name());
	}

	
	@After
	public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {

				try {
					
					final byte[] screenshot = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES);
				//	scenario.embed(screenshot, "image/png"); // ... and embed it in
					scenario.attach(screenshot, "image/png", "Failed step");
				} catch (WebDriverException e) {
					e.printStackTrace();
				}

			} else {
				try {
					
					scenario.attach(((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES), "image/png","Pass");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			TestBase.driver.quit();
	}
	
}
