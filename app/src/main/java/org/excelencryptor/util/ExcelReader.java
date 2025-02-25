package org.excelencryptor.util;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.excelencryptor.model.SpreadSheet;

public class ExcelReader {
    private String path;
    private final SpreadSheet spreadSheet;

    public ExcelReader(String path) {
        this.spreadSheet = new SpreadSheet(path);
    }

    public void read() throws IOException {
        spreadSheet.startUse();
        spreadSheet.setSheet(2);

        for (Row row: spreadSheet.getSheet()) {

            for (Cell cell: row) {
//                if (cell != firstCell) {
//                    throw new IOException("error");
//                }
//                System.out.println(cell);
                String cellValue = switch (cell.getCellType()) {
                    case STRING -> cell.getStringCellValue();
                    case NUMERIC -> String.valueOf(cell.getNumericCellValue());
                    // Handle other cell types as needed (e.g., BOOLEAN, FORMULA)
                    default -> ""; // Or handle other types
                };
//                System.out.print(cellValue + "\t"); // Print with tab separation
            }
//            System.out.println(); // New line for each row
        }

        spreadSheet.endUse();
    }
}