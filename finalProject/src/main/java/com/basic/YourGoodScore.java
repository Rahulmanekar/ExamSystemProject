package com.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class YourGoodScore {
WebDriver driver;
	
	public YourGoodScore(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public void checkYourGoodScore() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("1134567890");
		driver.findElement(By.id("loginbtn")).click();
		driver.findElement(By.partialLinkText("Account")).click();
		driver.findElement(By.xpath("//*[@href='https://www.qa.jbktest.com/test/good-score']")).click();
		String s=driver.findElement(By.partialLinkText("Back")).getText();
		System.out.println(s);
	}
}
