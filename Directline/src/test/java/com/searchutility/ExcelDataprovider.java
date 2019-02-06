package com.searchutility;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataprovider {
	
	XSSFWorkbook wb;
	
	
	public ExcelDataprovider()
	{
		
	File src = new File("./Regdata/testdata.xlsx");
	
	try {
		FileInputStream fis = new FileInputStream(src);
		
		wb = new XSSFWorkbook(fis);
	}  catch (Exception e) {
		
		System.out.println("Unable to read Excel File" +e.getMessage());
		
	}
   }
	public String getStringData(int sheetindex,int row,int column)
	{
		return wb.getSheetAt(sheetindex).getRow(row).getCell(column).getStringCellValue();
		
	}
	
	public String getStringData(String sheetname,int row,int column)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		
	}
	
	public double getNumericData(String sheetname,int row,int column)
	{
		return wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
	}

}
