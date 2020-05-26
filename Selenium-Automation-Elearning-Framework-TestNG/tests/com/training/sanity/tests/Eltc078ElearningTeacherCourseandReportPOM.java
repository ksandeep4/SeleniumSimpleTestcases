package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ElearningLoginPOM;
import com.training.pom.ElearningLogoutPOM;
import com.training.pom.ElearningStudenttestPOM;
import com.training.pom.ElearningTeacherCreateCoursePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Eltc078ElearningTeacherCourseandReportPOM {

	private WebDriver driver;
	private String baseUrl;
	private ElearningLoginPOM elearningloginPOM;
	private ElearningTeacherCreateCoursePOM elearningteachercreatecoursePOM;
	private ElearningLogoutPOM elearninglogoutPOM;
	private ElearningStudenttestPOM elearningstudenttestPOM;
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
		elearningteachercreatecoursePOM = new ElearningTeacherCreateCoursePOM(driver);
		elearninglogoutPOM = new ElearningLogoutPOM(driver);
		elearningstudenttestPOM = new ElearningStudenttestPOM(driver);
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
	@Test(priority=0)
	public void validLoginTest() throws InterruptedException {
		elearningloginPOM.sendUserName("steacher");
		elearningloginPOM.sendPassword("steacher");
		elearningloginPOM.clickLoginBtn(); 
		Thread.sleep(5000);
		screenShot.captureScreenShot("ELTC078");
	}
	@Test(priority=1)
	public void createTest() throws InterruptedException {
	 //  elearningteachercreatecoursePOM.courseCatalog();  //  course catalog method
		//elearningteachercreatecoursePOM.createaCourse();
		
		
		elearningteachercreatecoursePOM.clickonCourseLink();
		elearningteachercreatecoursePOM.clickontestIcon();
		elearningteachercreatecoursePOM.clickoncreateanewTest(); 
		elearningteachercreatecoursePOM.giveTestName("Test Quiz");
		elearningteachercreatecoursePOM.clickonadvancedSetting();  
		elearningteachercreatecoursePOM.clickonenableStarttime();
		elearningteachercreatecoursePOM.selectStarttime();  
		elearningteachercreatecoursePOM.timeSelected();
		elearningteachercreatecoursePOM.passPercentage("60");
		elearningteachercreatecoursePOM.proceedtoQ();
		elearningteachercreatecoursePOM.clickonMultiQIcon();   
		elearningteachercreatecoursePOM.AddQ("Course name");
		
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='cke_2_contents']//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		driver.findElement(By.xpath("//div[@id='cke_2_contents']//iframe[@class='cke_wysiwyg_frame cke_reset']")).sendKeys("Selenium");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='cke_4_contents']//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		driver.findElement(By.xpath("//div[@id='cke_4_contents']//iframe[@class='cke_wysiwyg_frame cke_reset']")).sendKeys("Java");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='cke_6_contents']//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		driver.findElement(By.xpath("//div[@id='cke_6_contents']//iframe[@class='cke_wysiwyg_frame cke_reset']")).sendKeys("C");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='cke_8_contents']//iframe[@class='cke_wysiwyg_frame cke_reset']")));
		driver.findElement(By.xpath("//div[@id='cke_8_contents']//iframe[@class='cke_wysiwyg_frame cke_reset']")).sendKeys("PHP");
		driver.switchTo().defaultContent();
		
		elearningteachercreatecoursePOM.AddthisQ();
		elearningteachercreatecoursePOM.clickPreviewbtn();
		elearninglogoutPOM.logout();
		} 
	@Test(priority=2)
	public void studentLogin() throws InterruptedException {
		elearningloginPOM.sendUserName("sstudent");
		elearningloginPOM.sendPassword("sstudent");
		elearningloginPOM.clickLoginBtn(); 
		Thread.sleep(5000);
		screenShot.captureScreenShot("ELTC078_studentlogin");
		
		elearningstudenttestPOM.studentSelectCourse();
		elearningstudenttestPOM.studentClickonTest();
		elearningstudenttestPOM.studentClickonQuiz();
		
		String addcommentmsg = driver.findElement(By.xpath("//div[@class='alert alert-warning']")).getText();
		Thread.sleep(1000);
		screenShot.captureScreenShot("ELTC078_addcommentmsg");
		Assert.assertEquals(addcommentmsg, "Exercise available from May 26, 2020 at 07:39 AM");
		System.out.println("Add Comment message :" + addcommentmsg);
			
	}
	@Test(priority=3)
	public void teacherLogin() throws InterruptedException {
		elearningloginPOM.sendUserName("steacher");
		elearningloginPOM.sendPassword("steacher");
		elearningloginPOM.clickLoginBtn(); 
		Thread.sleep(5000);
		screenShot.captureScreenShot("ELTC078_teacherlogin");
	
		elearningteachercreatecoursePOM.reporting(); 
	}
}