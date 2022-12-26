package com.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class SignUp {
WebDriver driver;
	
	public SignUp(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	
	}
	
	public void checkSignUp() {
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
		driver.findElement(By.id("emailbtn")).click();
	}

}
