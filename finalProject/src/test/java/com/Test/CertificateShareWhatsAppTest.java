package com.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.basic.CertificateShareWhatsApp;

public class CertificateShareWhatsAppTest {
	CertificateShareWhatsApp csw;
	WebDriver driver;

	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.qa.jbktest.com/online-exam#Testing");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		csw = new CertificateShareWhatsApp(driver);
	}

	@Test(priority = 1)
	public void verifyCertificateShareWhatsapp() {
		csw.checkCertificateShareWhatsapp();
		try {
			driver.findElement(By.xpath("//*[@src='images/wp.png']")).click();

			// To handle parent window
			String MainWindow = driver.getWindowHandle();

			// To handle child window
			Set<String> s1 = driver.getWindowHandles();

			Iterator<String> i1 = s1.iterator();
			while (i1.hasNext()) {
				String ChildWindow = i1.next();
				if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
					driver.switchTo().window(ChildWindow);
					String pageTitle = driver.getTitle();
					String expPageTitle = "WhatsApp Web";
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
