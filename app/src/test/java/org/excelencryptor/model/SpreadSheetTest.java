package org.excelencryptor.model;

import org.apache.poi.ss.usermodel.Sheet;
import org.excelencryptor.Paths;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.excelencryptor.Paths.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SpreadSheetTest {

    private static final String VALID_FILE_PATH = Paths.VALID_FILE_PATH.getPath();
    private static final String INVALID_FILE_PATH = Paths.INVALID_FILE_PATH.getPath();
    private SpreadSheet spreadSheet;

    @BeforeEach
    void setUp() {
        spreadSheet = new SpreadSheet(VALID_FILE_PATH);
    }

    @Test
    void testStartUseWithValidPath() {
        assertDoesNotThrow(() -> {
            spreadSheet.startUse();
            spreadSheet.endUse();
        });
    }

    @Test
    void testStartUseWithInvalidPath() {
        SpreadSheet invalidSpreadSheet = new SpreadSheet(INVALID_FILE_PATH);
        assertThrows(IOException.class, invalidSpreadSheet::startUse);
    }

    @Test
    void testSetAndGetSheet() throws IOException {
        spreadSheet.startUse();
        spreadSheet.setSheet(0); // Assuming sheet index 0 exists
        Sheet sheet = spreadSheet.getSheet();
        assertNotNull(sheet);
        spreadSheet.endUse();
    }

    @Test
    void testEndUse() {
        assertDoesNotThrow(() -> {
            spreadSheet.startUse();
            spreadSheet.endUse();
        });
    }
}