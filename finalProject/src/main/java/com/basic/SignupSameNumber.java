package com.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupSameNumber {
WebDriver driver;
	
	public SignupSameNumber(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	
	}
	public void checkSignupSameNumber() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.xpath("//*[text()='Sign Up']")).click();
		driver.findElement(By.id("name")).sendKeys("226SELCP");
		driver.findElement(By.id("emailid")).sendKeys("226SELCP@gmail.com");
		driver.findElement(By.id("mobile")).sendKeys("1234567890");
		driver.findElement(By.id("agree")).click();
		Actions act=new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("emailbtn")));
		driver.findElement(By.id("emailbtn")).click();
	}

}
