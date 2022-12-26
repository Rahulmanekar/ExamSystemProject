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

public class DownloadCetificate {
WebDriver driver;
	
	public DownloadCetificate(WebDriver driver) {
	// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
		this.driver=driver;
}
	public  void checkDownloadCertificate() {
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("1134567890");
		driver.findElement(By.id("loginbtn")).click();
		List<WebElement> stl=new ArrayList<WebElement>(); 
		stl.addAll(driver.findElements(By.xpath("//div[@class='pull-left pp' and text()='A']")));
	
		for(int i=0;i<=8;i++){
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
		driver.findElement(By.id("qsubmit")).click();
		driver.findElement(By.partialLinkText("Certificate")).click();
	}

}
