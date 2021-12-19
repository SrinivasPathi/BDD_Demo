package StepDefinitions;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.eggtimerehomepage;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testBase.TestBase;

public class eggtimercountdownStepdefinition extends TestBase {
//WebDriver driver=null;
eggtimerehomepage et= new eggtimerehomepage(driver);
/*
 * @Before public void browsersetup() throws InterruptedException {
 * System.out.println("browser is open"); String projectPath=
 * System.getProperty("user.dir");
 * System.setProperty("webdriver.chrome.driver",projectPath+
 * "/src/test/resources/drivers/chromedriver.exe"); driver=new ChromeDriver();
 * 
 * driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 * driver.manage().window().maximize(); Thread.sleep(5000); }
 * 
 * @After public void teardown() { System.out.println("in tear down");
 * driver.close(); driver.quit(); }
 */
/*
 * @BeforeStep public void beforestep() { System.out.println("before steps"); }
 * 
 * 
 * @AfterStep public void afterstep() { System.out.println("After steps"); }
 */

@Given("I open the URL {string}")
public void i_open_the_url(String string) throws InterruptedException {
	System.out.println("string"+string);
    et.OpenUrl(string);
 // driver.get(string);
 // driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 // WebDriverWait wait = new WebDriverWait(driver, 20);
 // wait.until(ExpectedConditions.visibilityOf(et.timerStartTimer));
}

@When("I enter timer as {string}")
public void i_enter_timer_as(String string) {
    // Write code here that turns the phrase above into concrete actions
		 et.entertime(string);
}

@When("I click on start button")
public void i_click_on_start_button() {
    // Write code here that turns the phrase above into concrete actions
	et.clickStartButton();
}

@Then("i should see the timer count down from {string}")
public void i_should_see_the_timer_count_down_from(String string) {
    // Write code here that turns the phrase above into concrete actions
	et.verifyTheCountDownTimer(Integer.parseInt(string));
}


}
