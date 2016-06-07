package com.cybage.alm.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
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
		LoginData loginData = new LoginData();
		ArrayList<LoginData> arrayList = new ArrayList<LoginData>();
		File file = new File(FilePath);
		try {
			FileInputStream fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
		}
		sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = (Row) rowIterator.next();
			if (row.getRowNum() == 0)
				continue;
			arrayList.add(loginData.buildLoginData(row));
		}
		System.out.println(arrayList.size());
		tabArray = new LoginData[arrayList.size()][1];
		for (int i = 0; i < arrayList.size(); i++) {

			LoginData data = (LoginData) arrayList.get(i);
			tabArray[i][0] = data;
		}
		return tabArray;

	}

	public Object[][] getRegisterData(String FilePath, String SheetName) {
		Object[][] tabArray = null;
		RegisterData registerData = new RegisterData();
		ArrayList<RegisterData> arrayList = new ArrayList<RegisterData>();
		File file = new File(FilePath);
		try {
			FileInputStream fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
		}
		sheet = workbook.getSheetAt(0);

		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = (Row) rowIterator.next();
			if (row.getRowNum() == 0)
				continue;
			arrayList.add(registerData.buildRegisterData(row));
		}
		System.out.println(arrayList.size());
		tabArray = new RegisterData[arrayList.size()][1];
		for (int i = 0; i < arrayList.size(); i++) {

			RegisterData data = (RegisterData) arrayList.get(i);
			tabArray[i][0] = data;
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
