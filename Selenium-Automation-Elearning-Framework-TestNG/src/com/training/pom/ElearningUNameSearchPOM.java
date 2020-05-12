package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElearningUNameSearchPOM {
	private WebDriver driver;

	public ElearningUNameSearchPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='search_simple_keyword']")
	private WebElement uName;
	
	@FindBy(xpath = "//button[@id='search_simple_submit']")
	private WebElement searchUser;
	
	public void uName(String uName) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(1000);
		this.uName.clear(); 
		Thread.sleep(5000);
		this.uName.sendKeys(uName);
	}
	public void searchText() {
		// TODO Auto-generated method stub
		this.searchUser.click();
	}
}

