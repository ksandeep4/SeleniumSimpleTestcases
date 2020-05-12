package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ElearningAdminpagePOM;
import com.training.pom.ElearningEditIconPOM;
import com.training.pom.ElearningLoginPOM;
import com.training.pom.ElearningUNameSearchPOM;
import com.training.pom.ElearningUserLinkPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Eltc019ElearningAdminViewDetails {

	private WebDriver driver;
	private String baseUrl;
	private ElearningLoginPOM elearningloginPOM;
	private ElearningAdminpagePOM elearningadminpagePOM;
	private ElearningUserLinkPOM elearninguserlinkPOM;
	private ElearningUNameSearchPOM elearningunamesearchPOM;
	private ElearningEditIconPOM elearningediticonPOM;
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
		elearningadminpagePOM = new ElearningAdminpagePOM(driver);
		elearninguserlinkPOM = new ElearningUserLinkPOM(driver);
		elearningediticonPOM = new ElearningEditIconPOM(driver);
		elearningunamesearchPOM = new ElearningUNameSearchPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.close();
	}

	@Test(priority = 0)
	public void validLoginTest() throws InterruptedException {
		elearningloginPOM.sendUserName("admin");
		elearningloginPOM.sendPassword("admin@123");
		elearningloginPOM.clickLoginBtn();
		Thread.sleep(5000);
		screenShot.captureScreenShot("ELTC019_Login");
	}

	@Test(priority = 1)
	public void adminPage() throws InterruptedException {
		elearningadminpagePOM.adminPage();
		// driver.findElement(By.xpath("//a[contains(text(),'Administration')]")).click();
		Thread.sleep(1000);
		System.out.println("AdminPAge");
		screenShot.captureScreenShot("ELTC019_Adminpage");
	}

	@Test(priority = 2)
	public void userLink() throws InterruptedException {
		// driver.findElement(By.xpath("//div[@class='panel panel-default
		// block-admin-users']//a[contains(text(),'User list')]")).click();
		elearninguserlinkPOM.userLink();
		Thread.sleep(1000);
		screenShot.captureScreenShot("ELTC019_Userlink");
		System.out.println("Userlink");
	}

	@Test(priority = 3)
	public void uName() throws InterruptedException {
		elearningunamesearchPOM.uName("admin");
		Thread.sleep(0500);
		// driver.findElement(By.xpath("//input[@id='search_simple_keyword']")).sendKeys("admin");
		screenShot.captureScreenShot("ELTC019_BeforeSearch");

		elearningunamesearchPOM.searchText();
		// driver.findElement(By.xpath("//button[@id='search_simple_submit']")).click();
		screenShot.captureScreenShot("ELTC019_AfterSearch");
	}

	@Test(priority = 4) 
	public void editIcon() throws InterruptedException {
	elearningediticonPOM.editIcon(); 
		//driver.findElement(By.  cssSelector("main.section-platform_admin:nth-child(1) div.container div.row div.col-xs-12.col-md-12 form.form-search div.table-responsive:nth-child(1) table.table.table-bordered.data_table tbody:nth-child(1) tr.row_odd:nth-child(3) td:nth-child(11) a:nth-child(6) > img:nth-child(1)")).click(); 
  Thread.sleep(0500);
  screenShot.captureScreenShot("ELTC019_EditIcon");
  System.out.println("EditIcon");
  }
}
 