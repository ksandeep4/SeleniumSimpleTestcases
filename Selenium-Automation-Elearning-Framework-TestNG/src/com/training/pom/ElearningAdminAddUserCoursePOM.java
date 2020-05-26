package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ElearningAdminAddUserCoursePOM {
	private WebDriver driver;

	public ElearningAdminAddUserCoursePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Add users to course')]")
	private WebElement addUserCourse;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement addUserCoursebtn;
	/*
	 * public void lastName(String lastName) throws InterruptedException {
	 * Thread.sleep(0500); this.lastName.clear(); this.lastName.sendKeys(lastName);
	 
	}*/

	
	//List<WebElement> firstLetter=driver.findElements(By.xpath("//select[@name='firstLetterUser']"));
	@FindBy(xpath = "//select[@name='firstLetterUser']")
	public WebElement lnfirstletter;
	
	//driver.findElement(By.xpath("//option[contains(text(),'"+fullname+"')]")).click();
	@FindBy(xpath = "//option[contains(text(),'\"+fullname+\"')]")
	private WebElement fullname;
	
		public void addUserCourse() {
		// TODO Auto-generated method stub
		this.addUserCourse.click();
	}
		public void addUserCoursebtn() {
		addUserCoursebtn.click();
}
/*
 * public WebElement lnfirstletter() { return this.lnfirstletter(); }
 */
		
			public void fullname(String fullname) {
			// TODO Auto-generated method stub
			this.fullname.sendKeys(fullname);
		}
			public WebElement lnfirstletter() {
				// TODO Auto-generated method stub
				return null;
			}
	
		
		
}
