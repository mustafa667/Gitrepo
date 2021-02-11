package com.pom.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_utility {
	

	static Workbook book;
	static Sheet sheet;

	public static String TESTDATA_path = "D:/selenium programs/pom/src/main/java/excel_data/Testdata.xlsx";

	public static Object[][] getTestdata(String Sheet_name) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(Sheet_name);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			
				data[i][0] = sheet.getRow(i+1).getCell(0).toString();
			
		}
		return data;
	}
	

}
