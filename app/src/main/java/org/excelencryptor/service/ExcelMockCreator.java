package org.excelencryptor.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelMockCreator {

    public static void createFalseXlsx() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        String filePath = "./app/src/test/resources/MockedXlsx.xlsx";
        Sheet sheet = workbook.createSheet("Sheet1");

        // Create a row and put some cells in it.
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Dummy Data");

        // Write the output to a file
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        }

        // Closing the workbook
        workbook.close();
    }
}