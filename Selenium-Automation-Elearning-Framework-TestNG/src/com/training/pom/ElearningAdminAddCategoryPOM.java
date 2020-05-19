package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElearningAdminAddCategoryPOM {
	private WebDriver driver;

	public ElearningAdminAddCategoryPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='course_category_code']")
	private WebElement categoryCode;
	
	@FindBy(xpath = "//input[@id='course_category_name']")
	private WebElement categoryName;
	
	@FindBy(id ="qf_5184fa")
	private WebElement clickCheckBox;
	
	@FindBy(xpath ="//button[@id='course_category_submit']")
	private WebElement addCatBtn;
	
	@FindBy(xpath=("//div[@class='actions']//a//img"))
	private WebElement adminAddCategory;
	
	public void categoryName(String categoryName) {
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
	}



	
		
	}


