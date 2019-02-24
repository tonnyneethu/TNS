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
	@FindBy(xpath = "//div[@class='result']")
	WebElement result;

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
		String vehicleresult = result.getText();
		
		System.out.println("Vehicle Registration displayed:"+vehicleresult);

		if (vehicleresult.contains(Vehiclereg))
		{
			System.out.println("Vehicle Registration Found");
		}
		else {
			System.out.println("Vehicle Registration not Found");
		}
	}
}

		

