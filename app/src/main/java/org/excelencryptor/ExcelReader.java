package org.excelencryptor;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    private final String path;
    public ExcelReader() {
        this.path = "/Users/xafixav/Downloads/datafrscrap/Igreja.xlsx";
    }

    // this read method was generated with Gemini, I am studying...
    // ... How to read, and manipulate spreadsheets with Java, Java is cool btw
    public void read(String path) throws IOException {
        if (path == null) {
            path = this.path;
        }
        String excelFilePath = path; // Replace with your correct file
        // path

        FileInputStream inputStream = new FileInputStream(excelFilePath);
        Workbook workbook = new XSSFWorkbook(inputStream); // For.xlsx files

        Sheet sheet = workbook.getSheetAt(2); // Get the first sheet (index 0)

        for (Row row: sheet) {

            for (Cell cell: row) {
//                if (cell != firstCell) {
//                    throw new IOException("error");
//                }
                System.out.println(cell);
                String cellValue = switch (cell.getCellType()) {
                    case STRING -> cell.getStringCellValue();
                    case NUMERIC -> String.valueOf(cell.getNumericCellValue());
                    // Handle other cell types as needed (e.g., BOOLEAN, FORMULA)
                    default -> ""; // Or handle other types
                };
                System.out.print(cellValue + "\t"); // Print with tab separation
            }
            System.out.println(); // New line for each row
        }

        workbook.close();
        inputStream.close();
    }
}