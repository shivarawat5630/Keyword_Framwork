package utils;

import org.apache.poi.xssf.usermodel.*;
import java.io.FileInputStream;

public class ExcelUtils {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public static void loadExcel(String path, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getCellData(int row, int col) {
        try {
            if (sheet.getRow(row) == null) {
                return "";
            }

            if (sheet.getRow(row).getCell(col) == null) {
                return "";
            }

            return sheet.getRow(row).getCell(col).toString();

        } catch (Exception e) {
            return "";
        }
    }

    public static int getRowCount() {
        return sheet.getLastRowNum();
    }
}