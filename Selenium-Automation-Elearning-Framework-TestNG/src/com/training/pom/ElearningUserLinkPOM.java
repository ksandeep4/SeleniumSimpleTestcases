package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElearningUserLinkPOM {
	private WebDriver driver;

	public ElearningUserLinkPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//div[@class='panel panel-default block-admin-users']//a[contains(text(),'User list')]")
	private WebElement userLink;
	


	public void userLink() {
		// TODO Auto-generated method stub
		this.userLink.click();
	}


		
	}


