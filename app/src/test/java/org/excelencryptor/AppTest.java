package org.excelencryptor;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testGetGreeting() {
        App app = new App();
        assertEquals("Hello World!", app.getGreeting());
    }

    @Test
    void testMain() {
        App.main(new String[]{});
    }

    @Test
    void testMainWithIOException() {
        ExcelReader reader = new ExcelReader();
        assertThrows(IOException.class, () -> {
            reader.read("/invalid/path/to/file.xlsx");
        });
    }
}