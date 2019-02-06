package com.searchpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Searchobjects {

	WebDriver driver;

	public Searchobjects(WebDriver Ddriver) {
		this.driver = Ddriver;

	}

	@FindBy(xpath = "//input[@id='vehicleReg']")
	WebElement Vregno;
	@FindBy(xpath = "//button[@name='btnfind']")
	WebElement searchbtn;

	public void searchvehicle(String Vehiclereg) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}

		Vregno.sendKeys(Vehiclereg);
		searchbtn.click();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {

		}
	}

}
