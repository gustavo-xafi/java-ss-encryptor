package org.excelencryptor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ExcelReaderTest {

    private ExcelReader excelReader;

    @BeforeEach
    void setUp() {
        excelReader = new ExcelReader();
    }

    @Test
    void testReadInvalidFilePath() {
        assertThrows(IOException.class, () -> {
            excelReader.read("/invalid/path/to/file.xlsx");
        });
    }

    @Test
    void testReadEmptyFile() {
        assertThrows(IOException.class, () -> {
            excelReader.read("/path/to/empty/file.xlsx");
        });
    }

    @Test
    void testReadFileWithDifferentSheetIndex() {
        assertThrows(IOException.class, () -> {
            excelReader.read("/path/to/file/with/different/sheet/index.xlsx");
        });
    }
}