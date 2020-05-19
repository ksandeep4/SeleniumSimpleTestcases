package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ElearningAdminAddCategoryPOM;
import com.training.pom.ElearningAdminCreateCoursePOM;
import com.training.pom.ElearningAdminpageCourseCategoriesPOM;
import com.training.pom.ElearningAdminpagePOM;
import com.training.pom.ElearningLoginPOM;
import com.training.pom.ElearningSearchCoursePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Eltc047ElearningAdminCreateCourseandCategoryforUser {

	private WebDriver driver;
	private String baseUrl;
	private ElearningLoginPOM elearningloginPOM;
	private ElearningAdminpagePOM elearningadminpagePOM;
	private ElearningAdminAddCategoryPOM elearningadminaddcategoryPOM;
	private ElearningAdminpageCourseCategoriesPOM elearningadminpagecoursecategoriesPOM;
	private ElearningAdminCreateCoursePOM elearningadmincreatecoursePOM;
	private ElearningSearchCoursePOM elearningsearchcoursePOM;
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
		elearningadminaddcategoryPOM = new ElearningAdminAddCategoryPOM(driver);
		elearningadminpagecoursecategoriesPOM = new ElearningAdminpageCourseCategoriesPOM(driver);
		elearningadmincreatecoursePOM = new ElearningAdminCreateCoursePOM(driver);
		elearningsearchcoursePOM = new ElearningSearchCoursePOM(driver);
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
		screenShot.captureScreenShot("ELTC047_Login");
		elearningadminpagePOM.adminPage();
		// driver.findElement(By.xpath("//a[contains(text(),'Administration')]")).click();
		Thread.sleep(1000);
		System.out.println("AdminPAge");
		screenShot.captureScreenShot("ELTC047_Adminpage");
	}

	@Test(priority = 1)
	public void coursesCategories() throws InterruptedException {
		
		elearningadminpagecoursecategoriesPOM.courseCatClick();
		
		elearningadminaddcategoryPOM.adminAddCategory();
		Thread.sleep(1000);
		elearningadminaddcategoryPOM.categoryCode("BL");
		elearningadminaddcategoryPOM.categoryName("Blended Learning");
		System.out.println("Yes Radio button should be get selected in Allow adding courses in this category");
		elearningadminaddcategoryPOM.addCatBtn(); 
		Thread.sleep(0500);
		screenShot.captureScreenShot("ELTC047_After Click Add CAtegory Button");
		elearningadminpagePOM.adminPage();
	}
	@Test(priority = 2)
	public void createCourse() throws InterruptedException {
		
		elearningadmincreatecoursePOM.createCourse();
		elearningadmincreatecoursePOM.title("BL");
		elearningadmincreatecoursePOM.code("bel");

		elearningadmincreatecoursePOM.createcoursebtn();
		System.out.println("Final");
}
	@Test(priority = 3)
	public void searchSelectedCourse() throws InterruptedException {
		
		elearningsearchcoursePOM.searchTitle("BL");
		elearningsearchcoursePOM.searchcoursesubmit();
		screenShot.captureScreenShot("ELTC047_Selected Couse displayed");
}
}