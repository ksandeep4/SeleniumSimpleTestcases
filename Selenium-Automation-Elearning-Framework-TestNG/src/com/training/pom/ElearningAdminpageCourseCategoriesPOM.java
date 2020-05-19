package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElearningAdminpageCourseCategoriesPOM {
	private WebDriver driver;

	public ElearningAdminpageCourseCategoriesPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Courses categories')]")
	private WebElement courseCatClick;
	

	public void courseCatClick() {
		// TODO Auto-generated method stub
		this.courseCatClick.click();
	}


		
	}


