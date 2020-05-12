package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ElearningLoginPOM;
import com.training.pom.ElearningLogoutPOM;
import com.training.pom.ElearninggetWelcomemessagePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import junit.framework.Assert;

public class Eltc016Elearning {

	private WebDriver driver;
	private String baseUrl;
	private ElearningLoginPOM elearningloginPOM;
	private ElearningLogoutPOM elearninglogoutPOM;
	//private ElearninggetWelcomemessagePOM elearningwelcomemessagePOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		elearningloginPOM = new ElearningLoginPOM(driver);
		elearninglogoutPOM = new ElearningLogoutPOM(driver);
		//elearningwelcomemessagePOM = new ElearninggetWelcomemessagePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}

	@Test(priority = 1)
	public void validLoginTest() throws InterruptedException {
		elearningloginPOM.sendUserName("kksandeep");
		elearningloginPOM.sendPassword("kelearning@2020");
		screenShot.captureScreenShot("ELTC016_BeforeLogin");
		elearningloginPOM.clickLoginBtn();
		Thread.sleep(1000);
		screenShot.captureScreenShot("ELTC016_Login");
		System.out.println("Successfully Login");
	}

	@Test(priority = 2)
	public void Welcomemessage() throws InterruptedException {
		String welcomemsg = driver.findElement(By.xpath("//section[@id='cm-content']//p[1]")).getText();
		//elearningwelcomemessagePOM.welcomemessage("welcomemsg");
		Thread.sleep(1000);
		screenShot.captureScreenShot("ELTC016_Welcomemessage");
		Assert.assertEquals(welcomemsg, "Hello kksandeep kkachneria and welcome,");
		System.out.println("Home Page Welcome message :" +welcomemsg);
	}

	@Test(priority = 3)
		public void logout() throws InterruptedException {
		
		elearninglogoutPOM.logout();
		System.out.println("logout");
		screenShot.captureScreenShot("ELTC016_Logout");
	}
}
