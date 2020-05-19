package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElearningAdminCreateCoursePOM {
	private WebDriver driver;

	public ElearningAdminCreateCoursePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*@FindBy(xpath = "//input[@id='course_category_code']")
	private WebElement categoryCode;
	
	@FindBy(xpath = "//input[@id='course_category_name']")
	private WebElement categoryName;*/
	
	@FindBy(xpath ="//input[@id='visual_code']")
	private WebElement code;
	
	@FindBy(xpath ="//input[@id='update_course_title']")
	private WebElement title;
	
	@FindBy(xpath=("//a[contains(text(),'Create a course')]"))
	private WebElement createCourse;
	@FindBy(xpath=("//button[@id='update_course_submit']"))
	private WebElement createcoursebtn;
	//@FindBy(xpath=("//button[@id='update_course_submit']"))
	//private WebElement createcoursebtn;
	
	/*public void categoryName(String categoryName) {
		// TODO Auto-generated method stub
		this.categoryName.clear();
		this.categoryName.sendKeys(categoryName);
		
	}
	public void categoryCode(String categoryCode) {
		// TODO Auto-generated method stub
		this.categoryCode.clear();
		this.categoryCode.sendKeys(categoryCode);
	}


	public void clickCheckBox() {
		// TODO Auto-generated method stub
		this.clickCheckBox.isEnabled();
	}

	public void addCatBtn() {
		// TODO Auto-generated method stub
		this.addCatBtn.click();
	}

	public void adminAddCategory() {
		// TODO Auto-generated method stub
		this.adminAddCategory.click();
	}*/
	public void createCourse() {
		// TODO Auto-generated method stub
		this.createCourse.click();
	}

	public void title(String title) {
		// TODO Auto-generated method stub
		this.title.sendKeys(title);
		
	}

	public void code(String code) {
		// TODO Auto-generated method stub
		this.code.sendKeys(code);
	}

	public void createcoursebtn() {
		// TODO Auto-generated method stub
		this.createcoursebtn.click();
	}


	}


