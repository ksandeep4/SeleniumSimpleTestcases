package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ElearningLoginPOM;
import com.training.pom.ElearningTeacherCreateCoursePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Eltc078ElearningTeacherCourseandReportPOM {

	private WebDriver driver;
	private String baseUrl;
	private ElearningLoginPOM elearningloginPOM;
	private ElearningTeacherCreateCoursePOM elearningteachercreatecoursePOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		elearningloginPOM = new ElearningLoginPOM(driver); 
		elearningteachercreatecoursePOM = new ElearningTeacherCreateCoursePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.close();
	}
	@Test(priority=0)
	public void validLoginTest() throws InterruptedException {
		elearningloginPOM.sendUserName("steacher2");
		elearningloginPOM.sendPassword("steacher2");
		elearningloginPOM.clickLoginBtn(); 
		Thread.sleep(5000);
		screenShot.captureScreenShot("ELTC078");
	}
	@Test(priority=1)
	public void createTest() {
	 //  elearningteachercreatecoursePOM.courseCatalog();  //  course catalog method
		elearningteachercreatecoursePOM.clickonCourseLink();
		//a[@class='btn btn-lg btn-success btn-block']  // click on subscribe.click
		#toolimage_19474                                //click on tests icon (CSS).click
	}  
	
}