package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.basic.LogoutFunction;

public class LogoutFunctionTest {
	WebDriver driver;
	LogoutFunction lf;

	
	@BeforeClass
	public void openBrowser(){
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lf =new  LogoutFunction(driver);
	}
  @Test(priority=1)
  public void verifyLogoutFunction() {
	  lf.checkLogoutFunction();
	  String actRes=driver.getTitle();
	  String expRes="Online Quiz to test your skills in Java,Python,MySQL,Testing";
	  Assert.assertEquals(actRes, expRes);
  }
  @AfterClass
  public void closeBrowser(){
	  driver.close();
  }
}
