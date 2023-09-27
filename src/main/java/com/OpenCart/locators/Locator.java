package com.OpenCart.locators;

import java.io.IOException;

import com.OpenCart.utils.ReadConfigureProperty;
import com.OpenCart.utils.ReadExcel;

public class Locator {
	//to get the property file data
	public static String getPropertyData(String element){
		String data = ReadConfigureProperty.fileProperties(element);
		return data;
	}
	
	//to get the excel file data
	public static String getExcelData(int i, int j,int k) throws IOException {
		//i - row, j - column, k - sheet number
		String data = ReadExcel.readExcel(i, j, k);
		return data;
	}
}
