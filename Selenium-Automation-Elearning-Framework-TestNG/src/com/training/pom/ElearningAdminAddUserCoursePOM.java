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

		public void addUserCourse() {
		// TODO Auto-generated method stub
		this.addUserCourse.click();
	}
		public void addUserCoursebtn() {
		addUserCoursebtn.click();
}
}
