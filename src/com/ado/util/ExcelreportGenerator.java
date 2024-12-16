package com.ado.util;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelreportGenerator {
	
	 public static void generateExcelReport(List<List<String>> data, String filename) {
	        try (Workbook workbook = new XSSFWorkbook()) {
	            Sheet sheet = workbook.createSheet("Report");

	            // Write headers
	            Row headerRow = sheet.createRow(0);
	            String[] headers = {"Column 1", "Column 2", "Column 3"};
	            for (int i = 0; i < headers.length; i++) {
	                Cell cell = headerRow.createCell(i);
	                cell.setCellValue(headers[i]);
	            }

	            // Write data
	            int rowNum = 1;
	            for (List<String> rowData : data) {
	                Row row = sheet.createRow(rowNum++);
	                int cellNum = 0;
	                for (String cellData : rowData) {
	                    row.createCell(cellNum++).setCellValue(cellData);
	                }
	            }

	            // Write to file
	            try (FileOutputStream fileOut = new FileOutputStream(filename)) {
	                workbook.write(fileOut);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }


}
