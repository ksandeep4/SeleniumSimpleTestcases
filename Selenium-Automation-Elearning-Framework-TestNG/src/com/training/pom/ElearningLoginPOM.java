package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElearningLoginPOM {
	private WebDriver driver;

	public ElearningLoginPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='login']")
	private WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;

	@FindBy(xpath = "//button[@id='form-login_submitAuth']")
	private WebElement loginBtn;

	public void sendUserName(String userName) {

		/*
		 * Actions actions = new Actions(driver);
		 * actions.moveToElement(this.userName).perform();
		 */
		/* Thread.sleep(4000); */
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password){
		/*
		 * Actions actions = new Actions(driver);
		 * actions.moveToElement(this.password).perform(); Thread.sleep(4000);
		 */
		this.password.clear();
		this.password.sendKeys(password);
	}

	public void clickLoginBtn() {
		/*
		 * Actions actions = new Actions(driver);
		 * actions.moveToElement(this.loginBtn).perform();
		 */
		this.loginBtn.click();

	}


		
	}


