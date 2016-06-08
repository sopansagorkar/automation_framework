package com.cybage.alm.data;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoginData {
	public String userName;
	public String password;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	public static LoginData buildLoginData(Row row) {
		LoginData ld = new LoginData();
		ld.setUserName(row.getCell(1).toString().trim());
		ld.setPassword(row.getCell(2).toString().trim());
		return ld;
	}

	public static LoginData[][] getLoginData(String FilePath, String SheetName) {

		LoginData[][] tabArray = null;
		ArrayList<LoginData> arrayList = new ArrayList<LoginData>();
		File file = new File(FilePath);
		try {
			FileInputStream fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
		} catch (Exception e) {
		}
		sheet = workbook.getSheet(SheetName);

		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = (Row) rowIterator.next();
			if (row.getRowNum() == 0)
				continue;
			arrayList.add(buildLoginData(row));
		}
		System.out.println(arrayList.size());
		tabArray = new LoginData[arrayList.size()][1];
		for (int i = 0; i < arrayList.size(); i++) {

			LoginData data = (LoginData) arrayList.get(i);
			tabArray[i][0] = data;
		}
		return tabArray;

	}

	public String getUserName() {
		return userName;
	}

	private void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	private void setPassword(String password) {
		this.password = password;
	}

}
