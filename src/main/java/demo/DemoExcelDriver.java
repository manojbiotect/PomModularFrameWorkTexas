package demo;

import commonLips.utils.ExcelDriver;

public class DemoExcelDriver {
	public static void main(String[] args) throws Exception {
		 

		ExcelDriver excelDriver = new ExcelDriver();

		String filename = System.getProperty("user.dir") + "/testData/test.xlsx";

		String sheetname = "TestData";

		excelDriver.createWorkbook(filename);

		excelDriver.openWorkbook(filename);

		excelDriver.createSheet(sheetname);

		excelDriver.setCellData(sheetname, 0, 0, "Manoj");

		excelDriver.setCellData(sheetname, 0, 1, "Ram");

		excelDriver.setCellData(sheetname, 1, 1, "Bishal");

		excelDriver.setCellData(sheetname, 1, 0, "Alex");

		excelDriver.setCellData(sheetname, 2, 1, "Shila");

		excelDriver.setCellData(sheetname, 2, 0, "Kumud");
		
		excelDriver.setCellData(sheetname, 3, 1, "Asmara");
		
		excelDriver.setCellData(sheetname, 3, 0, "Merisa");

		excelDriver.saveFile();

		excelDriver.closeWorkbook();
	}

}
