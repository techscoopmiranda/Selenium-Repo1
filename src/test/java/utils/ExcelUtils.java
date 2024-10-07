package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;

public class ExcelUtils {
    private Workbook workbook;

    public ExcelUtils(String excelPath) {
        try {
            FileInputStream fis = new FileInputStream(new File(excelPath));
            workbook = WorkbookFactory.create(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getCellData(int sheetIndex, int rowNum, int colNum) {
        Sheet sheet = workbook.getSheetAt(sheetIndex);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);
        DataFormatter formatter = new DataFormatter();
        String val = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
        return val;//cell.getStringCellValue();
    }

    public int getRowCount(int sheetIndex) {
        return workbook.getSheetAt(sheetIndex).getPhysicalNumberOfRows();
    }
}
