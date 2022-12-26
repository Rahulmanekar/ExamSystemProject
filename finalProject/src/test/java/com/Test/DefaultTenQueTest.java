package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.basic.DefaultTenQue;

public class DefaultTenQueTest {
	WebDriver driver;
	DefaultTenQue dq;
	
	@BeforeClass
	public void openBrowser(){
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		dq =new DefaultTenQue(driver);
	}
  @Test(priority=1)
  public void VerifydefaultTenQue() {
	  dq.verifyDefault10Que();
	  String expRes="Submit";
	  String actRes=driver.findElement(By.id("qsubmit")).getText();
	  Assert.assertEquals(actRes, expRes);
  }
  @AfterClass
  public void closeBrowser(){
	  driver.close();
  }
}
