package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.basic.TestAttemptFunc;

public class TestAttemptFuncTest {
	TestAttemptFunc taf;
	WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		taf = new TestAttemptFunc(driver);
	}

	@Test(priority = 1)
	public void verifyTestAttemptFunction() {
		taf.checkTestAttemptFunction();
		String actRes = driver.findElement(By.xpath("//*[text()='Action']")).getText();
		System.out.println(actRes);
		String expRes = "Action";
		Assert.assertEquals(actRes, expRes);
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
