package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ElearningStudentCoursesubscribePOM {
	private WebDriver driver;

	public ElearningStudentCoursesubscribePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[contains(text(),'Course catalog')]")
	private WebElement studentCourseSub;
	
	@FindBy(xpath="//input[@name='search_term']")
	private WebElement studentSearchCourseSub;
	
	@FindBy(xpath="//div[@class='input-group']//button[1]")
	private WebElement studentSearchCourseClickSub;
	
	@FindBy(xpath="//a[@class='btn btn-success btn-sm']")
	private WebElement studentSubforCourse;

	@FindBy(xpath="//a[contains(text(),'My courses')]")  
	private WebElement studentClickedforMyCourses;
	
	
	@FindBy(xpath="//a[contains(text(),'Account')]")  
	private WebElement studentClickedonSelectedCourses;
	
	@FindBy(css="#toolimage_19697")
	private WebElement studentClickonProject;
	
	@FindBy(xpath="//a[contains(text(),'design')]")
	private WebElement studentClickedonassignedtask;
	
	@FindBy(xpath="//input[@id='add_post_title']")
	private WebElement studentaddTitle;
	
	@FindBy(xpath="//button[@id='add_post_save']")
	private WebElement clickonSave;
	
	public void studentCourseSub() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(1000);
		this.studentCourseSub.click();
	}
	public void studentSearchCourseSub(String course) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(0500);
		this.studentSearchCourseSub.clear();
		Thread.sleep(1000);
		this.studentSearchCourseSub.sendKeys(course);
		}
	public void studentSearchCourseClickSub() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(1000);
		this.studentSearchCourseClickSub.click();
	}
	public void studentSubforCourse() throws InterruptedException {
		Thread.sleep(0500);
		this.studentSubforCourse.click();
}
	public void studentClickedforMyCourses() {
		// TODO Auto-generated method stub
		this.studentClickedforMyCourses.click();
	}
	public void studentClickedonSelectedCourses() {
		// TODO Auto-generated method stub
		this.studentClickedonSelectedCourses.click();
	}
	public void studentClickonProject() {
		// TODO Auto-generated method stub
		this.studentClickonProject.click();
	}
	public void studentClickedonassignedtask() {
		// TODO Auto-generated method stub
		this.studentClickedonassignedtask.click();
	}
	public void studentaddTitle(String title) throws InterruptedException {
		// TODO Auto-generated method stub
		this.studentaddTitle.clear();
		Thread.sleep(0500);
		this.studentaddTitle.sendKeys(title);
				
	}
	public void clickonSave() {
		// TODO Auto-generated method stub
		this.clickonSave.click();
			}


}
