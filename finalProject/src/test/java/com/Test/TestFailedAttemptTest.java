package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.basic.TestFailedAttempt;

public class TestFailedAttemptTest {
	TestFailedAttempt tfa;
	WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		tfa = new TestFailedAttempt(driver);
	}

	@Test(priority = 1)
	public void verifyTestFailedAttemptFunc() {
		tfa.checkTestFailedAttempt();
		String actRes = driver.findElement(By.xpath("//*[@class='text-right']")).getText();
		System.out.println(actRes);
		String expRes = "Failed Attempt";
		Assert.assertEquals(actRes, expRes);

	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
