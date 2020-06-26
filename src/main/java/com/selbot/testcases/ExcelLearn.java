package com.selbot.testcases;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelLearn {
	
	@Test
	public void test() throws IOException
	{
		XSSFWorkbook wb = new XSSFWorkbook("./data/excelLearn.xlsx");
		XSSFSheet ws = wb.getSheetAt(0);
		int rowCount = ws.getLastRowNum();
		int columnCount = ws.getRow(0).getLastCellNum();
		
		Object[][] excelData = new Object[rowCount][columnCount]; 
		System.out.println(rowCount);
		System.out.println(columnCount);

		for(int i=1;i<=rowCount;i++)
		{
			XSSFRow row = ws.getRow(i);
			for(int j=0;j<columnCount;j++)
			{
				XSSFCell cell = row.getCell(j);
				excelData[i-1][j] = cell.getStringCellValue();
				System.out.println(cell.getStringCellValue());
			}
		}
		
		System.out.println(excelData.length);
		System.out.println(excelData[0].length);
	}

}
