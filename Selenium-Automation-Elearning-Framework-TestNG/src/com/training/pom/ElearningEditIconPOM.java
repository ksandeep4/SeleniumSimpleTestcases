package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElearningEditIconPOM {
	private WebDriver driver;

	public ElearningEditIconPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "main.section-platform_admin:nth-child(1) div.container div.row div.col-xs-12.col-md-12 form.form-search div.table-responsive:nth-child(1) table.table.table-bordered.data_table tbody:nth-child(1) tr.row_odd:nth-child(3) td:nth-child(11) a:nth-child(6) > img:nth-child(1)")
	private WebElement editDetails;
	
	public void editIcon() throws InterruptedException {
		// TODO Auto-generated method stub
			this.editDetails.click();

	}
	}


