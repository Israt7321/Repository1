	package pack1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Facebook {
		WebDriver driver;
	@BeforeTest
	public void OpenBrowser() throws InterruptedException {
		driver = new FirefoxDriver();
		Thread.sleep(4000);
		String facebookTitle= driver.getTitle();
	System.out.println("Title is:"+ facebookTitle);	
	}
	@Test
	public void FacebookTest() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("firstname")).sendKeys("Israt");
		driver.findElement(By.name("lastname")).sendKeys("Jahan");
		driver.findElement(By.name("reg_email__")).sendKeys("oyshi18@yahoo.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("oyshi18@yahoo.com");
		driver.findElement(By.name("reg_passwd__" )).sendKeys("ssss");
		Thread.sleep(4000);
		Select monthSelect= new Select(driver.findElement(By.id("month")));
		monthSelect.selectByIndex(1);
		Select daySelect= new Select(driver.findElement(By.id("day")));
		daySelect.selectByIndex(26);
		Select yearSelect= new Select(driver.findElement(By.id("year")));
		yearSelect.selectByVisibleText("1990");
	}
	@AfterTest
	public void CloseBrowser() throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); 
		FileUtils.copyFile(srcFile, new File("C:\\Oyshi\\Facebook.jpg"));
		driver.close();
		
	}
	}
	
	
	
	
	
	
	
	
	
