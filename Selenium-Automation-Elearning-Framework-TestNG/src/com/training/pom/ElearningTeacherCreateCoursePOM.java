package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElearningTeacherCreateCoursePOM {
	private WebDriver driver;

	public ElearningTeacherCreateCoursePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=("//a[contains(text(),'Create a course')]"))
	private WebElement createaCourse;
	
	@FindBy(xpath=("//a[@class='btn btn-primary btn-large'])"))
	private WebElement courseCatalog;
	
	@FindBy(xpath=("//a[contains(text(),'santest')]"))
	private WebElement clickonCourseLink;

	@FindBy(xpath=("//img[@id='toolimage_19703']"))
	private WebElement clickontestIcon;

	@FindBy(xpath=("//div[@class='actions']//a[1]//img[1]"))
	private WebElement clickoncreateanewTest;

	@FindBy(xpath=("//input[@id='exercise_title']"))
	private WebElement giveTestName;
	
	@FindBy(xpath=("//button[@id='advanced_params']"))
	private WebElement clickonadvancedSetting;

	@FindBy(xpath=("//input[@id='qf_356e6d']"))
	private WebElement clickonenableStarttime;

	@FindBy(xpath=("//p[@id='start_time_alt_text']"))
	private WebElement selectStarttime;
	
	@FindBy(xpath=("//button[@class='ui-datepicker-current ui-state-default ui-priority-secondary ui-corner-all ui-state-hover']"))
	private WebElement timeSelected;

	@FindBy(xpath=("//button[@class='ui-datepicker-close ui-state-default ui-priority-primary ui-corner-all ui-state-hover']"))
	private WebElement timeSelectedClose;

	@FindBy(xpath=("//input[@id='pass_percentage']"))
	private WebElement passPercentage;

	@FindBy(xpath=("//button[@id='exercise_admin_submitExercise']"))
	private WebElement proceedtoQ;

	@FindBy(xpath=("//section[@id='cm-content']//li[1]//div[1]//a[1]//img[1]"))
	private WebElement clickonMultiQIcon;

	@FindBy(xpath=("//input[@id='question_admin_form_questionName']"))
	private WebElement AddQ;
	
	@FindBy(xpath=("//input[@id='question_admin_form_questionName']"))
	private WebElement Ans1;

	@FindBy(xpath=("//button[@id='submit-question']"))
	private WebElement Addthis;

	@FindBy(xpath=("//a[2]//img[1]"))
	private WebElement clickPreviewbtn;

	@FindBy(xpath="//li[@class='my-space active']//a[contains(text(),'Reporting')]")
	private WebElement reporting;
			
	public void courseCatalog() {
		// TODO Auto-generated method stub
		this.courseCatalog.click();
	} 

	public void clickonCourseLink() {
		// TODO Auto-generated method stub
		this.clickonCourseLink.click();
	}
	public void createaCourse() {
	this.createaCourse.click();
	}

	public void clickontestIcon() {
		// TODO Auto-generated method stub
		this.clickontestIcon.click();
	}

	public void clickoncreateanewTest() {
		// TODO Auto-generated method stub
		this.clickoncreateanewTest.click();
	}

	public void giveTestName(String test) {
		// TODO Auto-generated method stub
		this.giveTestName.sendKeys(test);
	}

	public void clickonadvancedSetting() {
		// TODO Auto-generated method stub
		this.clickonadvancedSetting.click();
	}

	public void clickonenableStarttime() {
		// TODO Auto-generated method stub
		this.clickonenableStarttime.click();
	}

	public void selectStarttime() {
		// TODO Auto-generated method stub
		this.selectStarttime.click();
		}

	public void timeSelected() throws InterruptedException {
		// TODO Auto-generated method stub
		this.timeSelected.click();
		Thread.sleep(0500);
		this.timeSelectedClose.click();
	}

	public void passPercentage(String per) {
		// TODO Auto-generated method stub
		this.passPercentage.sendKeys(per);
	}

	public void proceedtoQ() {
		// TODO Auto-generated method stub
		this.proceedtoQ.click();
	}

	public void clickonMultiQIcon() {
		// TODO Auto-generated method stub
		this.clickonMultiQIcon.click();
	}

	public void AddQ(String firstQ) {
		// TODO Auto-generated method stub
		this.AddQ.sendKeys(firstQ);
	}

	public void Ans1(String Ans1) {
		// TODO Auto-generated method stub
		this.Ans1(Ans1);
	}

	public void AddthisQ() {
		// TODO Auto-generated method stub
		this.Addthis.click();
	}

	public void clickPreviewbtn() {
		// TODO Auto-generated method stub
		this.clickPreviewbtn.click();
	}

	public void reporting() {
		// TODO Auto-generated method stub
		this.reporting.click();
	}
	
	}


