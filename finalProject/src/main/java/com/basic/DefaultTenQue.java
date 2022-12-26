package com.basic;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class DefaultTenQue {
WebDriver driver;
	
	public DefaultTenQue(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	
	}
	public  void verifyDefault10Que() {
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("1134567890");
		driver.findElement(By.id("loginbtn")).click();
		List<WebElement> stl=new ArrayList<WebElement>(); 
		stl.addAll(driver.findElements(By.xpath("//div[@class='pull-left pp' and text()='A']")));
	
		for(int i=0;i<=8;i++){
			stl.get(i).click();
					Actions act=new Actions(driver);
					act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).build().perform();
					driver.findElement(By.partialLinkText("Next")).click();
				
		}
	}
}
