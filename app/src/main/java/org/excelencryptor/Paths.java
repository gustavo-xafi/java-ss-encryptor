package org.excelencryptor;

public enum Paths {
    VALID_FILE_PATH("./src/test/resources/MockedXlsx.xlsx"),
    INVALID_FILE_PATH("./invalid/path/to/file.xlsx");

    private final String path;

    Paths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
