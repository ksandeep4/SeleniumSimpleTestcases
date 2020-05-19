package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ElearningSearchCoursePOM {
	private WebDriver driver;

	public ElearningSearchCoursePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//input[@id='course-search-keyword']")
	private WebElement searchTitle;

	@FindBy(xpath ="//button[@id='search_simple_submit']")
	private WebElement searchcoursesubmit;
	

	public void searchcoursesubmit() {
		// TODO Auto-generated method stub
		this.searchcoursesubmit.click();
	}
	public void searchTitle(String searchtitle) {
		// TODO Auto-generated method stub
		this.searchTitle.clear();
		this.searchTitle.sendKeys(searchtitle);
	}

}
