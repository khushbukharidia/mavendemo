package testcase;

import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.baseTest;

public class MyFirstTestFW extends baseTest {
	
	@Test
	public static void LoginTest()
	{
	driver.findElement(By.linkText(loc.getProperty("signin_link"))).click();
	driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys("ishaniroma123@gmail.com");
	driver.findElement(By.xpath(loc.getProperty("next_button"))).click();
	
	WebElement password = driver.findElement(By.id(loc.getProperty("pwd_field")));
	new Actions(driver).moveToElement(password).perform();
	//driver.findElement(By.cssSelector("#password")).sendKeys("khushbu123A@");
	driver.findElement(By.id(loc.getProperty("pwd_field"))).sendKeys("khushbu123A@");
	driver.findElement(By.xpath(loc.getProperty("login_next_button"))).click();
	

	
	
}
	
}