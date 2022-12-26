package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.basic.SignUp;

public class SignUpTest {
	SignUp siu;
	WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		siu = new SignUp(driver);
	}

	@Test(priority=1)
	public void verifySignUpFunctionallity() {
		siu.checkSignUp();
		String actRes = driver.findElement(By.xpath("(//*[@id='quizheading'])[4]")).getText();
		String expRes = "Manual Testing(ISTQB) Quiz";
		Assert.assertEquals(actRes, expRes);
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
