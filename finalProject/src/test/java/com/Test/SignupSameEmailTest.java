package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.basic.SignupSameEmail;

public class SignupSameEmailTest {
	SignupSameEmail sue;
	WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		sue = new SignupSameEmail(driver);
	}

	@Test(priority = 1)
	public void verifySignupSameEmail() {
		sue.checkSignupSameEmail();
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("emailerr")));
		String actError=driver.findElement(By.id("emailerr")).getText();
		System.out.println(actError);
		String expError="Email Address already exists, please login with mobile number associated with this email. [check your inbox for welcome email]";
		Assert.assertEquals(actError, expError);
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
