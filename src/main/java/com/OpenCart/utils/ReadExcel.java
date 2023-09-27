package com.OpenCart.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	/*
	 * Setting the file path of excel In workbook accessing sheet no. returning
	 * value from given row and column
	 */
	public static String readExcel(int row, int column,int sheetNum) throws IOException {
		String testData = null;
		try {
			String filePath = System.getProperty("user.dir") + "//src//main//resources//Excel//Data.xlsx";
			System.out.println(filePath);
			FileInputStream file = new FileInputStream(filePath);
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet ws = wb.getSheetAt(sheetNum);
			testData = String.valueOf(ws.getRow(row).getCell(column));
			wb.close();
		} catch (Exception e) {
			System.out.println("Error :"+e);
		}
		return testData;
	}
}
