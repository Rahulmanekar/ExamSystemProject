package com.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class ResultSorry {
	WebDriver driver;

	public ResultSorry(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;

	}

	public void checkResultSorry() {
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("1134567890");
		driver.findElement(By.id("loginbtn")).click();
		for (int i = 0; i <= 8; i++) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if (driver.findElement(By.partialLinkText("Next")).isDisplayed()) {
				driver.findElement(By.partialLinkText("Next")).click();
			} else {

				Actions act = new Actions(driver);
				act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).build().perform();
				driver.findElement(By.partialLinkText("Next")).click();
			}

		}
		driver.findElement(By.id("qsubmit")).click();

	}
}
