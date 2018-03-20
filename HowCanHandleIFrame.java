package pack1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HowCanHandleIFrame {
WebDriver driver;
@BeforeTest
public void OpenBrowser() {
	driver = new FirefoxDriver();
	driver.manage().window().setSize(new Dimension(800,900));
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
}
@Test
public void IFrameHandling() {
	driver.get("file:///C:/WebSite/SuperTech.html");
	driver.switchTo().frame("LoginForm");//using String
	driver.findElement(By.name("first_name")).sendKeys("Israt");
	driver.findElement(By.name("last_name")).sendKeys("Jahan");
	driver.findElement(By.name("pass")).sendKeys("1231");
	
	WebElement FN =driver.findElement(By.name("first_name"));
	JavascriptExecutor js = ((JavascriptExecutor)driver);
	js.executeScript("arguments[0].style.border='5px solid yellow'",FN);
	 
	driver.switchTo().defaultContent();
	
	//driver.switchTo().frame("Ruet");
	//driver.findElement(By.xpath("//*[@id='usermenu']/div/a[2]")).click();
	//driver.findElement(By.xpath("//*[@id='fos_user_registration_form_firstName']")).sendKeys("Israt");
	
	//driver.switchTo().defaultContent();
}
@AfterTest
 public void CloseDriver() throws IOException {
	File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(f,new File("C:\\Oyshi\\IFrame.jpg"));
	driver.close();

	
}
}
