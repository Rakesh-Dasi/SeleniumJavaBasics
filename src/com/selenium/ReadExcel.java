package com.selenium;

import com.utility.Constant;
import com.utility.ExcelUtils;

public class ReadExcel {

	public static void main(String[] args) throws Exception {
		
		ExcelUtils.setExcelFile(Constant.Path_TestData);
		String userName = ExcelUtils.getCellData(1, Constant.Col_UserName, Constant.Sheet_Name);
		String password = ExcelUtils.getCellData(1, Constant.Col_Password, Constant.Sheet_Name);		
		System.out.println("Data from excel is : " + userName + "  Password is : "  + password);
		
		//Java Application 
		
		

	}

}
