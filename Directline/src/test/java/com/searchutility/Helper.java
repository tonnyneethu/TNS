package com.searchutility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public static String captureScreenshot(WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screen=System.getProperty("user.dir")+"/Screenshot/Regsearch_"+getDateTime()+".png";

		try {

			FileHandler.copy(src, new File(screen));
			System.out.println("Screenshot Captured");

		} catch (IOException e) {

			System.out.println("Unable Capture Screenshot" + e.getMessage());
		}
		return screen;

	}

	/*
	 * public static String getScreenshot(WebDriver driver) {
	 * 
	 * TakesScreenshot ts = (TakesScreenshot) driver;
	 * 
	 * File src = ts.getScreenshotAs(OutputType.FILE);
	 * 
	 * String path = System.getProperty("./Screenshot/pic.png");
	 * 
	 * File destination = new File(path);
	 * 
	 * try { FileUtils.copyFile(src,destination);
	 * 
	 * } catch (Exception e) {
	 * 
	 * System.out.println("Capture Failed " + e.getMessage()); }
	 * 
	 * return path;
	 * 
	 * }
	 */

	// Current Date and Time

	public static String getDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");

		Date currentDate = new Date();

		return customFormat.format(currentDate);

	}

}
