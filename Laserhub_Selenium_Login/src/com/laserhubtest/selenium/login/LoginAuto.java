package com.laserhubtest.selenium.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginAuto {

	WebDriver driver;
	
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/amalaaugustus/Desktop/Selenium/chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			
			driver.get("https://app.laserhub.com/login");
			login();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void login() {
		try {
			driver.findElement(By.id("onetrust-accept-btn-handler")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("email")).sendKeys("e.ioannidis+testing_worktask@laserhub.com");
			Thread.sleep(3000);
			driver.findElement(By.id("password")).sendKeys("l0vet3sting@");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);
			
			String expURL = "https://app.laserhub.com/product";
			String actURL = driver.getCurrentUrl();
			
			driver.close();
			
			if(expURL.equalsIgnoreCase(actURL))
			{
				System.out.println("Test Successful");
			}
			else
			{
				System.out.println("Test Failed");
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		LoginAuto autoObj = new LoginAuto();
		autoObj.invokeBrowser();

	}

}
