package org.excelencryptor.util;

    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;

    import java.io.IOException;

    import static org.junit.jupiter.api.Assertions.*;

    class ExcelReaderTest {

        private ExcelReader excelReader;
        private static final String VALID_FILE_PATH = "./src/test/resources/MockedXlsx.xlsx";
        private static final String INVALID_FILE_PATH = "./invalid/path/to/file.xlsx";

        @BeforeEach
        void setUp() {
            excelReader = new ExcelReader(VALID_FILE_PATH);
        }

        @Test
        void testReadValidFile() {
            assertDoesNotThrow(() -> excelReader.readOne(0)); // Assuming sheet index 0 exists
        }

        @Test
        void testReadInvalidFilePath() {
            ExcelReader invalidReader = new ExcelReader(INVALID_FILE_PATH);
            assertThrows(IOException.class, () -> invalidReader.readOne(0)); // Assuming sheet index 0
        }
    }