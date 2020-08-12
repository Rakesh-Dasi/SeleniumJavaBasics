package com.utility;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static org.apache.poi.ss.usermodel.Cell Cell;
	@SuppressWarnings("unused")
	private static XSSFRow Row;
	// private static XSSFRow Row;

	public static void setExcelFile(String Path) throws Exception {
		try {
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
		} catch (Exception e) {

		}
	}

	public static String getCellData(int RowNum, int ColNum, String SheetName) throws Exception {
		try {
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {

			return "";
		}
	}
	
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			ExcelWSheet = ExcelWBook.getSheet(Constant.Sheet_Name);
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {

			return "";
		}
	}

	public static int getRowCount(String SheetName) {
		int iNumber = 0;
		try {
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			iNumber = ExcelWSheet.getLastRowNum() + 1;
		} catch (Exception e) {

		}
		return iNumber;
	}

	public static int getRowContains(String sTestCaseName, int colNum, String SheetName) throws Exception {
		int iRowNum = 0;
		try {
			// ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int rowCount = ExcelUtils.getRowCount(SheetName);
			for (; iRowNum < rowCount; iRowNum++) {
				if (ExcelUtils.getCellData(iRowNum, colNum, SheetName).equalsIgnoreCase(sTestCaseName)) {
					break;
				}
			}
		} catch (Exception e) {

		}
		return iRowNum;
	}

}
