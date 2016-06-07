package com.cybage.alm.utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.cybage.alm.data.LoginData;
import com.cybage.alm.data.RegisterData;

public class DataProviders {

	public int result;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	@DataProvider(name = "loginData")
	public Object[][] loginDataProvider() {
		Object[][] data = getLoginData(
				"D:\\Mars Workspace\\automation_framework_ALMQA\\src\\test\\resources\\loginData.xlsx", "Sheet1");

		return data;
	}

	@DataProvider(name = "registerData")
	public Object[][] registerDataProvider() {
		Object[][] data = getRegisterData(
				"D:\\Mars Workspace\\automation_framework_ALMQA\\src\\test\\resources\\registerData.xlsx", "Sheet1");
		return data;
	}

	public Object[][] getLoginData(String FilePath, String SheetName) {

		Object[][] tabArray = null;

		try {

			FileInputStream ExcelFile = new FileInputStream(FilePath);

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			int startRow = 1;

			int startCol = 0;

			int ci, cj;

			int totalRows = ExcelWSheet.getLastRowNum();

			int totalCols = 2;

			tabArray = new Object[totalRows][totalCols];

			ci = 0;
			LoginData loginData;
			for (int i = startRow; i <= totalRows; i++, ci++) {

				cj = 0;
				loginData = new LoginData();

				for (int j = startCol; j < totalCols; j++, cj++) {

					/*
					 * tabArray[ci][cj] = getCellData(i, j);
					 * 
					 * System.out.println(tabArray[ci][cj]);
					 */
					if (j == 0) {
						loginData.setUserName(getCellData(i, j));
						tabArray[ci][cj] = new Integer(i);
					} else {
						loginData.setPassowrd(getCellData(i, j));
						tabArray[ci][cj] = loginData;

					}

				}

			}
		} catch (Exception e) {

			System.out.println(e);
		}
		return tabArray;

	}

	public Object[][] getRegisterData(String FilePath, String SheetName) {
		Object[][] tabArray = null;

		try {

			FileInputStream ExcelFile = new FileInputStream(FilePath);

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			int startRow = 1;

			int startCol = 0;

			int ci, cj;

			int totalRows = ExcelWSheet.getLastRowNum();

			int totalCols = 11;

			tabArray = new String[totalRows][totalCols];

			ci = 0;
			RegisterData registerData;
			for (int i = startRow; i <= totalRows; i++, ci++) {

				cj = 0;
				registerData = new RegisterData();

				for (int j = startCol; j < totalCols; j++, cj++) {

					/*
					 * tabArray[ci][cj] = getCellData(i, j);
					 * 
					 * System.out.println(tabArray[ci][cj]);
					 */
					if (j == 0) {
						registerData.setFirstName((getCellData(i, j)));
						registerData.setLastName((getCellData(i, j)));
						registerData.setPhone((getCellData(i, j)));
						registerData.setuName((getCellData(i, j)));
						registerData.setAddress((getCellData(i, j)));
						registerData.setCity((getCellData(i, j)));
						registerData.setState((getCellData(i, j)));
						registerData.setPincode((getCellData(i, j)));
						registerData.setEmail((getCellData(i, j)));
						registerData.setPassWord((getCellData(i, j)));
						tabArray[ci][cj] = new Integer(i);
					} else {
						registerData.setFirstName((getCellData(i, j)));
						registerData.setLastName((getCellData(i, j)));
						registerData.setPhone((getCellData(i, j)));
						registerData.setuName((getCellData(i, j)));
						registerData.setAddress((getCellData(i, j)));
						registerData.setCity((getCellData(i, j)));
						registerData.setState((getCellData(i, j)));
						registerData.setPincode((getCellData(i, j)));
						registerData.setEmail((getCellData(i, j)));
						registerData.setPassWord((getCellData(i, j)));
						tabArray[ci][cj] = registerData;

					}

				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tabArray;

	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			int dataType = Cell.getCellType();

			if (dataType == 3) {

				return "";

			} else {

				String CellData = Cell.getStringCellValue();

				return CellData;

			}
		} catch (Exception e) {

			System.out.println(e.getMessage());

			throw (e);

		}

	}

}
