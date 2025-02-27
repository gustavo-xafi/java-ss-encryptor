package org.excelencryptor.model;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class SpreadSheet {
    private final String path;
    private FileInputStream inputStream;
    private XSSFWorkbook workbook;
    private Sheet sheet;

    public SpreadSheet(String path) {
        this.path = path;
    }

    private void openWorkbook() throws IOException {
        this.workbook = new XSSFWorkbook(this.inputStream);
    }

    private void closeWorkbook() throws IOException {
        this.workbook.close();
    }

    private void openStream() throws IOException {
        this.inputStream = new FileInputStream(this.path);
    }

    private void closeStream() throws IOException {
        this.inputStream.close();
    }

    public void setSheet(int index) throws IOException {
        try {
            this.sheet = this.workbook.getSheetAt(index);
        } catch (IllegalArgumentException e) {
            throw new IOException("Sheet index out of bounds");
        }
    }

    public Sheet getSheet() {
        return this.sheet;
    }

    public void endUse() throws IOException {
        this.closeWorkbook();
        this.closeStream();
    }

    public void startUse() throws IOException {
        this.openStream();
        this.openWorkbook();
    }
}
