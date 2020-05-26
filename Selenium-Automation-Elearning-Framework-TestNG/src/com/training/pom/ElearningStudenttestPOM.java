package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ElearningStudenttestPOM {
	private WebDriver driver;

	public ElearningStudenttestPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'santest')]")  
	private WebElement studentSelectCourse;
	
	@FindBy(css="#toolimage_19703")
	private WebElement studentClickonTest;

	@FindBy(xpath="//a[contains(text(),'Test Quiz')]")
	private WebElement studentClickonQuiz;
	
	
	public void studentSelectCourse() {
		// TODO Auto-generated method stub
		this.studentSelectCourse.click();
	}


	public void studentClickonTest() {
		// TODO Auto-generated method stub
		this.studentClickonTest.click();
	}


	public void studentClickonQuiz() {
		// TODO Auto-generated method stub
		this.studentClickonQuiz.click();
	}




}
