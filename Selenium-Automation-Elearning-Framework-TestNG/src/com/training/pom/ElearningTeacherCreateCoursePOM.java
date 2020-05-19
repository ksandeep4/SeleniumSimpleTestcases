package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElearningTeacherCreateCoursePOM {
	private WebDriver driver;

	public ElearningTeacherCreateCoursePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath=("//a[@class='btn btn-primary btn-large'])"))
	private WebElement courseCatalog;
	
	@FindBy(xpath=("//a[contains(text(),'Security')]"))
	private WebElement clickonCourseLink;

	public void courseCatalog() {
		// TODO Auto-generated method stub
		this.courseCatalog.click();
	}

	public void clickonCourseLink() {
		// TODO Auto-generated method stub
		this.clickonCourseLink.click();
	}


	}


