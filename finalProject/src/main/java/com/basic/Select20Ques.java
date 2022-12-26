package com.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Select20Ques {
WebDriver driver;
	
	public Select20Ques(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	
	}
	public void checkSelect20Ques() {
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.xpath("//*[@value='20']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("1134567890");
		driver.findElement(By.id("loginbtn")).click();
		List<WebElement> stl=new ArrayList<WebElement>(); 
		stl.addAll(driver.findElements(By.xpath("//div[@class='pull-left pp' and text()='A']")));
	
		for(int i=0;i<=18;i++){
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			stl.get(i).click();
				
				if(driver.findElement(By.partialLinkText("Next")).isDisplayed())
					driver.findElement(By.partialLinkText("Next")).click();
				else{
					Actions act=new Actions(driver);
					act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).build().perform();
					driver.findElement(By.partialLinkText("Next")).click();
				}
		}
	}
}
