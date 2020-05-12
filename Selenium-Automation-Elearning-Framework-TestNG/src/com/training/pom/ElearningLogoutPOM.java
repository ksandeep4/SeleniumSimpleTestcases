package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElearningLogoutPOM {
	private WebDriver driver;

	public ElearningLogoutPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//span[@class='caret']")
	private WebElement logouthover;

	@FindBy(xpath = "//a[@id='logout_button']")
	private WebElement logout;



	public void logout() throws InterruptedException {
	
		this.logouthover.click();
		Thread.sleep(1000);
		this.logout.click();

	}

}
