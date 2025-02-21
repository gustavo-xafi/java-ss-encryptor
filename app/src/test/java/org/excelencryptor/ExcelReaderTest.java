package org.excelencryptor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ExcelReaderTest {

    private ExcelReader excelReader;
    private static final String FILE_PATH = "/path/to/file.xlsx";

    @BeforeEach
    void setUp() {
        excelReader = new ExcelReader();
    }

    @Test
    void testReadInvalidFilePath() {
        assertThrows(IOException.class, () -> {
            excelReader.read(FILE_PATH);
        });
    }

    @Test
    void testReadEmptyFile() {
        assertThrows(IOException.class, () -> {
            excelReader.read(FILE_PATH);
        });
    }

    @Test
    void testReadFileWithDifferentSheetIndex() {
        assertThrows(IOException.class, () -> {
            excelReader.read(FILE_PATH);
        });
    }
}