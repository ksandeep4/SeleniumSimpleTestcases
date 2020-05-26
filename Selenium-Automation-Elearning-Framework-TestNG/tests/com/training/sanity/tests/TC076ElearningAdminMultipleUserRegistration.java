package com.training.sanity.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.ElearningAddUserPOM;
import com.training.pom.ElearningAdminAddMultipleUserCoursePOM;
import com.training.pom.ElearningAdminAddUserCoursePOM;
import com.training.pom.ElearningAdminpagePOM;
import com.training.pom.ElearningLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TC076ElearningAdminMultipleUserRegistration {
	private WebDriver driver;
	private String baseUrl;
	// private LoginPOM loginPOM;
	private ElearningLoginPOM elearningloginPOM;
	private ElearningAdminpagePOM elearningadminpagePOM;
	private ElearningAddUserPOM elearningadduserPOM;
	private ElearningAdminAddUserCoursePOM elearningadminaddusercoursePOM;
	private ElearningAdminAddMultipleUserCoursePOM elearningadminaddmultipleusercoursePOM;
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
		// loginPOM = new LoginPOM(driver);
		elearningloginPOM = new ElearningLoginPOM(driver);
		elearningadminpagePOM = new ElearningAdminpagePOM(driver);
		elearningadduserPOM = new ElearningAddUserPOM(driver);
		elearningadminaddusercoursePOM = new ElearningAdminAddUserCoursePOM(driver);
		elearningadminaddmultipleusercoursePOM = new ElearningAdminAddMultipleUserCoursePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test(priority = 0)
	public void validLoginTest() throws InterruptedException {
		elearningloginPOM.sendUserName("admin");
		elearningloginPOM.sendPassword("admin@123");
		elearningloginPOM.clickLoginBtn();

		elearningadminpagePOM.adminPage();
		Thread.sleep(1000);
		System.out.println("AdminPAge");
		screenShot.captureScreenShot("ELTC076_Adminpage");
	}


	@Test(priority = 1, dataProvider = "excel-inputsadduser", dataProviderClass = LoginDataProviders.class)
	public void maddUserDetails(String firstName, String lastName, String email, String phone, String userName,String password, String role) throws InterruptedException {
		elearningadduserPOM.addUserLink();
		Thread.sleep(0500);
		screenShot.captureScreenShot("ELTC076_AddUserPage");
		System.out.println("Add User Page displayed");
		elearningadduserPOM.fName(firstName);
		elearningadduserPOM.lastName(lastName);
		elearningadduserPOM.email(email);
		elearningadduserPOM.phoneNumber(phone);
		elearningadduserPOM.login(userName);

		elearningadduserPOM.selectPassword();
		elearningadduserPOM.sendPassword(password);
		// elearningadduserPOM.profileList(); // ("Trainer");
		System.out.println("Send PAssword");
		
		elearningadduserPOM.selectRole();
		System.out.println("Select Role");
		elearningadduserPOM.sendRole(role);
		
	
		elearningadduserPOM.clickAddBtn();
		System.out.println("Click on Add Button");

		String useraddmsg = driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
		// elearningwelcomemessagePOM.welcomemessage("welcomemsg");
		Thread.sleep(0500);
		screenShot.captureScreenShot("ELTC076_Welcomemessage");
		// Assert.assertEquals(welcomemsg, "Hello sandeep kachneria and welcome,");
		System.out.println("Home Page Welcome message :" + useraddmsg);
		elearningadminpagePOM.adminPage();
	}
	
	 @Test(priority = 2, dataProvider = "excel-inputsaddcourse", dataProviderClass = LoginDataProviders.class) 
	  public void maddUsertoCourse(String lletter,String lname,String fcourseletter,String scourse)throws InterruptedException
	  { 
		 elearningadminaddusercoursePOM.addUserCourse();
		 System.out.println("Clicked on Add User Course");
     		Thread.sleep(0500);
			
     		elearningadminaddmultipleusercoursePOM.lastLetter();
     		elearningadminaddmultipleusercoursePOM.sendlastLetter(lletter);
    	
    		System.out.println("Send lastLetter");
     		
    		
    		elearningadminaddmultipleusercoursePOM.searchaddnameBox();
    		elearningadminaddmultipleusercoursePOM.addnametext(lname);
    		
    		System.out.println("selected username");
     		
     		elearningadminaddmultipleusercoursePOM.firstcourseLetter();
     		//elearningadminaddmultipleusercoursePOM.sendfirstcourseLetter(fcourseletter);
     		
			driver.findElement(By.xpath("//option[contains(text(),'+lname+')]")).click();
			Thread.sleep(1000);
			//elearningadminaddusercoursePOM.fullname(lname);
			//driver.findElement(By.xpath("//option[contains(text(),'kachneria sandeep (sandeep)')]")).isSelected();
			//driver.findElement(By.xpath("//option[contains(text(),'kachneria sandeep (sandeep)')]")).click();
     		
     		
    	
    		System.out.println("Send lastLetter");
     		
    		elearningadminaddmultipleusercoursePOM.selectedcoursetext(scourse);

			System.out.println("Selected Course");

			elearningadminaddusercoursePOM.addUserCoursebtn();
			//driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
							
			 String coursesubsmsg = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
			 Thread.sleep(0500); 
			 AssertJUnit.assertEquals(coursesubsmsg, "The selected users are subscribed to the selected course");
			 System.out.println("Home Page Welcome message :" +coursesubsmsg);
			 screenShot.captureScreenShot("ELTC076_Course Subscription message");
			
		}
	
	
}
