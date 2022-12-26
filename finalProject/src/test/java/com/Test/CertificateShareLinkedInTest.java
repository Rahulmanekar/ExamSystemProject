package com.Test;

import java.util.Iterator;
import java.util.Set;
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

import com.basic.CertificateShareLinkedIn;

public class CertificateShareLinkedInTest {
	CertificateShareLinkedIn csl;
	WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		csl = new CertificateShareLinkedIn(driver);
	}

	@Test(priority = 1)
	public void verifyCertificateShareLinkedIn() {
		csl.checkCertificateShareLinkeIn();
		try {
			driver.findElement(By.xpath("//*[@src='images/in.png']")).click();

			// To handle parent window
			String MainWindow = driver.getWindowHandle();

			// To handle child window
			Set<String> s1 = driver.getWindowHandles();

			Iterator<String> i1 = s1.iterator();
			while (i1.hasNext()) {
				String ChildWindow = i1.next();
				if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
					driver.switchTo().window(ChildWindow);
					new WebDriverWait(driver,20).until(ExpectedConditions.titleContains("Sign Up | LinkedIn"));
					String pageTitle = driver.getTitle();
					String expPageTitle = "Sign Up | LinkedIn";
					Assert.assertEquals(pageTitle, expPageTitle);
					System.out.println("The web page title of child window is:" + pageTitle);
					driver.close();
					System.out.println("Child window closed");
				}
			}

		} catch (Exception e) {

		}
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();

	}
		
	
}
