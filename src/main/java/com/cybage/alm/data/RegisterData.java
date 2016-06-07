package com.cybage.alm.data;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RegisterData {

	public String firstName;
	public String lastName;
	public String phone;
	public String email;
	public String address;
	public String city;
	public String state;
	public String pincode;
	public String country;
	public String uName;
	public String passWord;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	public RegisterData buildRegisterData(Row row) {
		RegisterData rd = new RegisterData();
		rd.setFirstName(row.getCell(0).toString().trim());
		rd.setLastName(row.getCell(1).toString().trim());
		rd.setPhone(row.getCell(2).toString().trim());
		rd.setEmail(row.getCell(3).toString().trim());
		rd.setAddress(row.getCell(4).toString().trim());
		rd.setCity(row.getCell(5).toString().trim());
		rd.setState(row.getCell(6).toString().trim());
		rd.setPincode(row.getCell(7).toString().trim());
		rd.setCountry(row.getCell(8).toString().trim());
		rd.setuName(row.getCell(9).toString().trim());
		rd.setPassWord(row.getCell(10).toString().trim());
		return rd;
	}

	public static RegisterData[][] getRegisterData(String FilePath, String SheetName) {
		RegisterData[][] tabArray = null;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
