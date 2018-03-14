package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Pch {
WebDriver driver;
@BeforeTest
public void OpenBrowser() {
	driver = new FirefoxDriver();
	
}

@Test
public void Registration() {
	driver.get("http://www.pch.com/");
	driver.findElement(By.xpath("")).sendKeys("Israt");
}

}
