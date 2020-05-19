package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ElearningAdminAddUserCoursePOM;
import com.training.pom.ElearningAddUserPOM;
import com.training.pom.ElearningAdminpagePOM;
import com.training.pom.ElearningLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import junit.framework.Assert;

public class Eltc048ElearningAdminCreateandRegisterUser {

	private WebDriver driver;
	private String baseUrl;
	private ElearningLoginPOM elearningloginPOM;
	private ElearningAdminpagePOM elearningadminpagePOM;
	private ElearningAddUserPOM elearningadduserPOM;
	private ElearningAdminAddUserCoursePOM elearningadminaddusercoursePOM;
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
		elearningadduserPOM = new ElearningAddUserPOM(driver);
		elearningadminaddusercoursePOM = new ElearningAdminAddUserCoursePOM(driver);
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
		Thread.sleep(1000);
		screenShot.captureScreenShot("ELTC048_Login");
		elearningadminpagePOM.adminPage();
		// driver.findElement(By.xpath("//a[contains(text(),'Administration')]")).click();
		Thread.sleep(1000);
		System.out.println("AdminPAge");
		screenShot.captureScreenShot("ELTC048_Adminpage");
	}

	@Test(priority = 1) 
	public void addUser() throws InterruptedException {
	  //driver.findElement(By.xpath("//a[contains(text(),'Add a user')]")).click();
	  elearningadduserPOM.addUserLink(); 
	  Thread.sleep(1000);
	  screenShot.captureScreenShot("ELTC048_AddUserPage");
	  System.out.println("Add User Page displayed"); // Working fine 
	  }

	@Test(priority = 2) 
	public void addUserDetails() throws InterruptedException
	  { 
	  elearningadduserPOM.fName("sandeep");
	  elearningadduserPOM.lastName("kachneria");
	  elearningadduserPOM.email("ssaranshk@yahoo.com");
	  elearningadduserPOM.phoneNumber("7776443211");
	  elearningadduserPOM.login("ssaransh");
	  
	  //System.out.println("Element Selected Radio1="+driver.findElement(By.xpath("//div//input[@id='qf_ee776d']")).isSelected());
	  //driver.findElement(By.xpath("//div//input[@id='qf_ee776d']")).click();
	  elearningadduserPOM.selectPassword();
	  elearningadduserPOM.sendPassword("ssaransh");
	  //elearningadduserPOM.profileList(); // ("Trainer");
	  	  
	  Select objSel=new Select(driver.findElement(By.xpath("//select[@id='status_select']")));
	 
	  Thread.sleep(0500);
	  objSel.selectByVisibleText("Trainer"); 
	  
	  System.out.println("Select Role as Trainer"); 
	  elearningadduserPOM.clickAddBtn(); 
	  System.out.println("Click on Add Button"); 
	  
	  String welcomemsg = driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
	  //elearningwelcomemessagePOM.welcomemessage("welcomemsg");
	  Thread.sleep(0500); 
	  screenShot.captureScreenShot("ELTC048_Welcomemessage");
	  Assert.assertEquals(welcomemsg, "Hello sandeep kachneria and welcome,");
	  System.out.println("Home Page Welcome message :" +welcomemsg);
	  elearningadminpagePOM.adminPage();
	  screenShot.captureScreenShot("ELTC048_Adminpage2"); }

	@Test(priority = 3)
	public void addUsertoCourse() throws InterruptedException {
		elearningadminaddusercoursePOM.addUserCourse();
			//driver.findElement(By.xpath("//a[contains(text(),'Add users to course')]")).click();
		System.out.println("Clicked on Add User Course");

		Select objSel = new Select(driver.findElement(By.xpath("//select[@name='firstLetterUser']")));
		objSel.selectByVisibleText("K");
		System.out.println("Search user with first letter");
		driver.findElement(By.xpath("//option[contains(text(),'kachneria sandeep (sandeep)')]")).isSelected();
		driver.findElement(By.xpath("//option[contains(text(),'kachneria sandeep (sandeep)')]")).click();
		System.out.println("Select user");

		Select objSelcd = new Select(driver.findElement(By.xpath("//select[@name='firstLetterCourse']")));
		objSelcd.selectByVisibleText("S");
		System.out.println("Search course with first letter");
		driver.findElement(By.xpath("//option[contains(text(),'(S1) selenium')]")).isSelected();
		driver.findElement(By.xpath("//option[contains(text(),'(S1) selenium')]")).click();

		System.out.println("Selected Selenium Course");

		elearningadminaddusercoursePOM.addUserCoursebtn();
		//driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
						
		 String coursesubsmsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		 Thread.sleep(0500); 
		 Assert.assertEquals(coursesubsmsg, "The selected users are subscribed to the selected course");
		 System.out.println("Home Page Welcome message :" +coursesubsmsg);
		 screenShot.captureScreenShot("ELTC048_Course Subscription message");
		
	}
}
