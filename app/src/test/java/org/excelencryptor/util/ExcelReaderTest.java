package org.excelencryptor.util;

import org.excelencryptor.model.SpreadSheet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ExcelReaderTest {

    private ExcelReader excelReader;
    private static final String VALID_FILE_PATH = "/Users/xafixav/Downloads/datafrscrap/Igreja.xlsx";
    private static final String INVALID_FILE_PATH = "/invalid/path/to/file.xlsx";

    @BeforeEach
    void setUp() {
        excelReader = new ExcelReader(VALID_FILE_PATH);
    }

    @Test
    void testReadValidFile() {
        assertDoesNotThrow(() -> {
            excelReader.read();
        });
    }

    @Test
    void testReadInvalidFilePath() {
        ExcelReader invalidReader = new ExcelReader(INVALID_FILE_PATH);
        assertThrows(IOException.class, invalidReader::read);
    }

    @Test
    void testReadFileWithDifferentSheetIndex() {
        SpreadSheet spreadSheet = new SpreadSheet(VALID_FILE_PATH);
        assertDoesNotThrow(() -> {
            spreadSheet.startUse();
            spreadSheet.setSheet(0); // Assuming sheet index 0 exists
            spreadSheet.endUse();
        });
    }
}