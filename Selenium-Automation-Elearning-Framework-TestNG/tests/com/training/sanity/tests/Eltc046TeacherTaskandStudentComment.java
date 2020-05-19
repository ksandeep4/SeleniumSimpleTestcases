package com.training.sanity.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ElearningLoginPOM;
import com.training.pom.ElearningStudentCoursesubscribePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Eltc046TeacherTaskandStudentComment {

	private WebDriver driver;
	private String baseUrl;
	private ElearningLoginPOM elearningloginPOM;
	private ElearningStudentCoursesubscribePOM elearningstudentcoursesubscribePOM;
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
		elearningstudentcoursesubscribePOM = new ElearningStudentCoursesubscribePOM(driver);
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
		elearningloginPOM.sendUserName("sstudent");
		elearningloginPOM.sendPassword("sstudent");
		elearningloginPOM.clickLoginBtn();
		Thread.sleep(5000);
		screenShot.captureScreenShot("ELTC046_Login");

	}

	@Test(priority=1)
	public void studentSubscribe() throws InterruptedException {
		elearningstudentcoursesubscribePOM.studentCourseSub();
		elearningstudentcoursesubscribePOM.studentSearchCourseSub("account");
		elearningstudentcoursesubscribePOM.studentSearchCourseClickSub();
		try
		{
		elearningstudentcoursesubscribePOM.studentSubforCourse();    

		String subscriptionmsg = driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
		Thread.sleep(1000);
		screenShot.captureScreenShot("ELTC046_subscriptionmsg");
		Assert.assertEquals(subscriptionmsg, "User sstudent sstudent (sstudent) has been registered to course account");
		System.out.println("Course Subscription message :" + subscriptionmsg);
	}
		catch (NoSuchElementException e)
		{
			System.out.println("Already subscribed for the course");
		}
	}
	@Test(priority=2)
	public void studentaddComment() throws InterruptedException {
		elearningstudentcoursesubscribePOM.studentClickedforMyCourses();
		elearningstudentcoursesubscribePOM.studentClickedonSelectedCourses();
		elearningstudentcoursesubscribePOM.studentClickonProject();
		elearningstudentcoursesubscribePOM.studentClickedonassignedtask();
		elearningstudentcoursesubscribePOM.studentaddTitle("Completed");

		elearningstudentcoursesubscribePOM.clickonSave();

		String addcommentmsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		Thread.sleep(1000);
		screenShot.captureScreenShot("ELTC046_addcommentmsg");
		Assert.assertEquals(addcommentmsg, "You comment has been added");
		System.out.println("Add Comment message :" + addcommentmsg);

	}
}