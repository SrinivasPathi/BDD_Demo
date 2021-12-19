package PageObjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

public class eggtimerehomepage {

	WebDriver driver;
	@FindBy(xpath="//input[@id='EggTimer-start-time-input-text']")
	public WebElement timerStartTimer;
	
	@FindBy(xpath="//button[text()='Start']")
	public WebElement startBtn;
	
	@FindBy(xpath="//p[@class='ClassicTimer-time']/span")
	public WebElement classicTimerLbl;
	
	public eggtimerehomepage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		//waitHelper.WaitForElement(userName, 60);
	}
	
	public void OpenUrl(String url) throws InterruptedException{ 
		driver.get(url);
		Thread.sleep(1000);

	  }
	public void entertime(String iseconds){ 
		timerStartTimer.sendKeys(iseconds);
	  }
	
	
	public void clickStartButton(){
		startBtn.click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='ClassicTimer-time']/span")));
	}
	
	public  void verifyTheCountDownTimer(int  iSeconds) 
	{
		try {
		while(iSeconds>0)
		{	 
				
			
			long millis = System.currentTimeMillis();
			String time=classicTimerLbl.getText();
		int	result= Integer.parseInt(time.split(" ")[0]);
			System.out.println("user time:"+iSeconds);
			System.out.println("app time:"+time);
			Assert.assertEquals(Integer.toString(iSeconds),Integer.toString(result));
			
			/*
			 * if(time.contains(Integer.toString(iSeconds))) { //
			 * Reporter.addStepLog("value form UI and timer:"+time+":"+iSeconds);
			 * 
			 * System.out.println("value form UI and iSeconds:"+time+":"+iSeconds);
			 * Assert.assertTrue(true); } else { Assert.assertFalse(false); }
			 */
			 Thread.sleep(1000 - millis % 1000);
			 isAlertPresent();
			 iSeconds-=1;	
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
	public  void isAlertPresent(){
	    try{
	    Alert alert = driver.switchTo().alert();
	    alert.accept();
	    System.out.println(alert.getText()+" Alert is Displayed"); 
	    }
	    catch(NoAlertPresentException ex){
	    System.out.println("Alert is NOT Displayed");
	    }
	    }
}
