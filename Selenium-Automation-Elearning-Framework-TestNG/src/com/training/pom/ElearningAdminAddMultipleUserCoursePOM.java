package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ElearningAdminAddMultipleUserCoursePOM {
	private WebDriver driver;

	public ElearningAdminAddMultipleUserCoursePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//option[contains(text(),'/lname/')]")
	private WebElement addnametext;

	@FindBy(xpath = "//select[@name='firstLetterUser']")
	private WebElement lastLetter;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement addUserCoursebtn;

	@FindBy(xpath = "//select[@name='firstLetterCourse']")
	private WebElement firstcourseLetter;

	@FindBy(xpath = "//select[@name='firstLetterCourse']")
	private WebElement sendfirstcourseLetter;

	@FindBy(xpath = "//option[contains(text(),'/+scourse+/')]")
	private WebElement selectedcoursetext;

	@FindBy(xpath = "//select[@name='UserList[]']")
	private WebElement searchaddnameBox;

	public void lastLetter() {
		// TODO Auto-generated method stub
		this.lastLetter.click();
	}

	public void sendlastLetter(String lletter) throws InterruptedException {
		// TODO Auto-generated method stub

		Thread.sleep(0500);
		this.lastLetter.sendKeys(lletter);
		Thread.sleep(0500);
		this.lastLetter.sendKeys(Keys.ENTER);
	}
	
	public void searchaddnameBox() {
		// TODO Auto-generated method stub
		this.searchaddnameBox.isSelected();
	}
	
	public void addnametext(String lname) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(0500);
		this.addnametext.sendKeys(lname);
		}

	public void firstcourseLetter() {
		// TODO Auto-generated method stub
		this.firstcourseLetter.click();
	}

	public void sendfirstcourseLetter(String fcourseletter) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(0500);
		this.sendfirstcourseLetter.sendKeys(fcourseletter);
		Thread.sleep(0500);
		this.sendfirstcourseLetter.sendKeys(Keys.ENTER);
	}
	

	public void selectedcoursetext(String scourse) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(0500);
		this.selectedcoursetext.sendKeys(scourse);
		Thread.sleep(0500);
		this.selectedcoursetext.isSelected();
	}

	}