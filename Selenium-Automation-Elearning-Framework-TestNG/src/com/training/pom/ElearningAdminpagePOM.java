package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElearningAdminpagePOM {
	private WebDriver driver;

	public ElearningAdminpagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Administration')]")
	private WebElement adminPage;
	

	public void adminPage() {
		// TODO Auto-generated method stub
		this.adminPage.click();
	}


		
	}


