package org.excelencryptor;

import org.excelencryptor.util.ExcelReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    private static final String VALID_FILE_PATH = Paths.VALID_FILE_PATH.getPath();
    private static final String INVALID_FILE_PATH = Paths.INVALID_FILE_PATH.getPath();

    @Test
    void testMain() {
        App.main(new String[]{});
    }

    @Test
    void testMainWithIOException() {
        ExcelReader reader = new ExcelReader(VALID_FILE_PATH);
        assertThrows(IOException.class, () -> reader.readOne(2));
    }

    @Test
    void testMainWithValidPath() {
        ExcelReader reader = new ExcelReader(VALID_FILE_PATH);
        assertDoesNotThrow(() -> reader.readOne(0));
    }
}