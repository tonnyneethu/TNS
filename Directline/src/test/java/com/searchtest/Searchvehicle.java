package com.searchtest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.searchpageobjects.Searchbase;
import com.searchpageobjects.Searchobjects;

public class Searchvehicle extends Searchbase {

	@Test
	public void vehicle()

	{
		logger = report.createTest("Search Testcase");
		Searchobjects search = PageFactory.initElements(driver, Searchobjects.class);
		logger.info("Start Application");
		search.searchvehicle(searchexl.getStringData("Data", 0, 1));
		logger.info("Vehicle Register Number Entered");
		logger.pass("Vehicle Register Number displayed");
		
	}

}
