package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ElearningAddUserPOM {
	private WebDriver driver;

	public ElearningAddUserPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='firstname']")
	private WebElement firstName;
	@FindBy(xpath = "//input[@id='lastname']")
	private WebElement lastName;
	@FindBy(xpath = "//input[@id='email']")
	private WebElement email;
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phone;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userName;
	// @FindBy(xpath = "//input[@id='qf_ee776d']") private WebElement
	// passwordRadioButton;
	// @FindBy(css = "#qf_ee776d") private WebElement passwordRadioButton;
	@FindBy(css = "main.section-platform_admin:nth-child(1) div.container div.row div.col-xs-12.col-md-12 form.form-horizontal fieldset:nth-child(1) div.form-group:nth-child(10) div.col-sm-8:nth-child(2) > div.radio:nth-child(2)")  
	private WebElement passwordRadioButton;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	@FindBy(css = "main.section-platform_admin:nth-child(1) div.container div.row div.col-xs-12.col-md-12 form.form-horizontal fieldset:nth-child(1) div.form-group:nth-child(11) div.col-sm-8:nth-child(2) div.dropdown.bootstrap-select.form-control > button.btn.dropdown-toggle.btn-default")
	private WebElement profileList;
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement addBtn;

	@FindBy(xpath = "//a[contains(text(),'Add a user')]")
	private WebElement addUserLink;
	
	@FindBy(xpath = "//div[10]//div[1]//div[1]//button[1]//span[1]//span[1]")
	private WebElement selectRole;
	
	@FindBy(xpath = "//div[@class='dropdown bootstrap-select form-control dropup open']//input[@class='form-control']")
	private WebElement sendRole;
	

	public void lastName(String lastName) throws InterruptedException {
		Thread.sleep(0500);
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
	}

	public void email(String email) throws InterruptedException {
		Thread.sleep(0500);
		this.email.clear();
		this.email.sendKeys(email);
	}

	public void phoneNumber(String phone) throws InterruptedException {
		Thread.sleep(0500);
		this.phone.clear();
		this.phone.sendKeys(phone);
	}

	public void login(String userName) throws InterruptedException {
		Thread.sleep(0500);
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void selectPassword() throws InterruptedException{
/*	 * 
	 * Actions actions = new Actions(driver);
	 * actions.moveToElement(this.passwordRadioButton).perform();
	 * */
/*
 * this.passwordRadioButton.isSelected(); Thread.sleep(1000);
 */
	 this.passwordRadioButton.click(); }
	

	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	/*
	 * public void profileList() { // (String profileList) this.profileList.clear();
	 * this.profileList(); //this.profileList.sendKeys(profileList); }
	 */
	
	 public void profileList() {
	 Select objSel=new Select(driver.findElement(By.xpath("//div[10]//div[1]//div[1]//button[1]")));
	 objSel.selectByVisibleText("Trainer");
}

	public void clickAddBtn() {
		this.addBtn.click();
	}

	public void addUserLink() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(0500);
		this.addUserLink.click();
	}

	public void fName(String firstName) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(0500);
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
	}

	public void selectRole() {
		// TODO Auto-generated method stub
		this.selectRole.click();
	}

	public void sendRole(String role) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Thread.sleep(0500);
		this.sendRole.sendKeys(role);
		Thread.sleep(0500);
		this.sendRole.sendKeys(Keys.ENTER);
	}

}
