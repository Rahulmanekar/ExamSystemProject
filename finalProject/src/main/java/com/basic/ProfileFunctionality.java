package com.basic;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProfileFunctionality {
	WebDriver driver;
	
	public ProfileFunctionality(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	
	}
	public void checkProfileFuctionallity() {
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("1134567890");
		driver.findElement(By.id("loginbtn")).click();
		driver.findElement(By.partialLinkText("Account")).click();
		driver.findElement(By.partialLinkText("View Profile")).click();
		
	}
}
