package com.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	static File directory = new File("");
	static String relPath = directory.getAbsolutePath();
	public static String excelFilePath = relPath + "./DataSheet.xlsx";

	static FileInputStream fis;
	static Workbook workbook;
	static Sheet sheet;

	public static Map<String, Map<String, String>> data() throws IOException {
		loadSheet();
		try {
			int lastRow = sheet.getLastRowNum();
			Map<String, Map<String, String>> testDataMap = new HashedMap<String, Map<String, String>>();
			int tcIdNum = getIDColNumber();
			for (int i = 1; i <= lastRow; i++) {
				Row row = sheet.getRow(i);
				if (!(row == null)) {
					Cell keyCell = row.getCell(tcIdNum);
					if (!(keyCell == null)) {
						String key = keyCell.getStringCellValue().trim();
						testDataMap.put(key, getMapForRow(i));
					}
				}
			}
			return testDataMap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getData(String tc_ID, String ColName) {
		Map<String, Map<String, String>> excelFileMap = null;
		try {
			excelFileMap = data();
		} catch (Exception e) {
		}
		Map<String, String> tData = excelFileMap.get(tc_ID);
		return tData.get(ColName);
	}

	private static void loadSheet() throws IOException {
		try {
			fis = new FileInputStream(excelFilePath);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static int getIDColNumber() throws IOException {
		try {
			Row r = sheet.getRow(0);
			int lastCol = r.getLastCellNum();
			Row headRow = sheet.getRow(0);
			for (int i = 0; i <= lastCol; i++) {
				Cell headRowValueCell = headRow.getCell(i);
				String val = headRowValueCell.getStringCellValue().trim();
				val = val.toLowerCase();
				if (val.contains("tc_id")) {
					return i;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static Map<String, String> getMapForRow(int rowNo) throws IOException {

		try {
			Row r = sheet.getRow(0);
			int lastCol = r.getLastCellNum();
			Row headRow = sheet.getRow(0);
			Map<String, String> rowMap = new HashedMap<String, String>();
			for (int i = 0; i <= lastCol; i++) {
				Cell headRowValueCell = headRow.getCell(i);
				Row row = sheet.getRow(rowNo);
				Cell valueCell = row.getCell(i);

				String key, value;
				try {
					value = valueCell.getStringCellValue().trim();
					key = headRowValueCell.getStringCellValue().trim();
				} catch (Exception e) {
					value = "null";
					key = "null";
				}
				rowMap.put(key, value);
			}
			return rowMap;
		} catch (Exception e) {
			System.out.println("Map could not be created for row : " + rowNo);
		}
		return null;
	}

	public static List<String> listExecutableOfTestClasses() {
		int tcIDnum = 0, exeCol = 0;
		try {
			loadSheet();
			tcIDnum = getIDColNumber();
			exeCol = getExecuteColNumber();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<String> tcClasses = new ArrayList<>();
		sheet = workbook.getSheetAt(0);
		int lastRow = sheet.getLastRowNum();

		String value, execute;
		try {
			for (int i = 1; i <= lastRow; i++) {
				Row row = sheet.getRow(i);
				if (!(row == null)) {
					Cell exe = row.getCell(exeCol);
					if (!(exe == null)) {
						execute = exe.getStringCellValue().trim();
						if (execute.equalsIgnoreCase("y")) {
							Cell valueCell = row.getCell(tcIDnum);
							value = valueCell.getStringCellValue().trim();
							tcClasses.add(value);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tcClasses;
	}

	private static int getExecuteColNumber() throws IOException {
		try {
			Row r = sheet.getRow(0);
			int lastCol = r.getLastCellNum();
			Row headRow = sheet.getRow(0);
			for (int i = 0; i <= lastCol; i++) {
				Cell headRowValueCell = headRow.getCell(i);
				String val = headRowValueCell.getStringCellValue().trim();
				val = val.toLowerCase();
				if (val.contains("execute")) {
					return i;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
