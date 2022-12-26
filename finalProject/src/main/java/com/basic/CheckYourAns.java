package com.basic;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckYourAns {
	WebDriver driver;
	
	public CheckYourAns(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	
	}
	public void checkAnswer() {
		driver.findElement(By.xpath("//*[text()='Manual Testing(ISTQB)']")).click();
		driver.findElement(By.id("countbtn")).click();
		driver.findElement(By.id("loginmobile")).sendKeys("1134567890");
		driver.findElement(By.id("loginbtn")).click();
		
	
		for(int i=0;i<=8;i++){
				Actions act=new Actions(driver);
				act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).build().perform();
				driver.findElement(By.partialLinkText("Next")).click();
			
		}
		driver.findElement(By.id("qsubmit")).click();
                WebDriverWait wait = new WebDriverWait(driver,30);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='View Answer']")));
	
		driver.findElement(By.xpath("//*[text()='View Answer']")).click();
		
	}

}
