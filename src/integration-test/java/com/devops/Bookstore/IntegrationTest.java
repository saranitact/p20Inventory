package com.devops.Bookstore;

//Integration Test Cases
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;
import static org.junit.Assert.*;
import java.lang.*;

import java.util.concurrent.TimeUnit;

import org.junit.experimental.categories.Category;
import com.devops.Bookstore.IntegrationTest;

@Category(IntegrationTest.class)
public class IntegrationTest {

	static WebDriver driver;
	

	@BeforeClass
	public static void setup() {
		//Chrome webdriver
		System.setProperty("webdriver.chrome.driver", "E:\\Users\\SARAN\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//Firefox webdriver
		//System.setProperty("webdriver.gecko.driver", "E:\\sarhuhu\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");

		
		//driver = new FirefoxDriver();
		
		driver = new ChromeDriver();
	
	}

	@AfterClass
	public static void cleanUp() {
		driver.quit();
	}

	@Test
	public void shouldLogin() {
		
		driver.get("http://localhost:5080/Bookstore/");
		//Thread.sleep(9000000);
		try {
			Thread.sleep(80000);
		} catch (InterruptedException e) {}	
		Boolean bool = false;
/*		driver.findElement(By.name("email")).sendKeys("a@b.com");
		driver.findElement(By.name("password")).sendKeys("pass");
		driver.findElement(By.name("btnlogin")).click();*/
		
		System.out.println(driver.getTitle());
		Assert.assertTrue((driver.getTitle().equals("DevOps BookStore")));
		

		}
	
	}
