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

import com.basic.ResultSorry;

public class ResultSorryTest {
	ResultSorry rso;
	WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		rso = new ResultSorry(driver);
	}

	@Test(priority=1)
	public void verifyResultSorry() {
		rso.checkResultSorry();
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("score")));
		String result=driver.findElement(By.id("score")).getText();
		System.out.println(result);
		int i=Integer.parseInt(result);
		if(i==0){
			String actRes=driver.findElement(By.xpath("//*[@class='text-danger text-center']")).getText();
			String expRes="Sorry!!!";
			Assert.assertEquals(actRes, expRes);
		}
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
