package pom;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelHandler extends BaseTest {
    //-------------------------- HANDLING EXCEL SHEET ------------------------------------
    public static String readExcelData(String file, String sheetName, int row, int colunm)  {

        FileInputStream fis  = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook workBook = null;
        try {
            workBook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet sheet = workBook.getSheet(sheetName);
        Row r = sheet.getRow(row);
        Cell c = r.getCell(colunm);
        String cellValue = c.getStringCellValue();
        System.out.println("Value of cell : " + cellValue);
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cellValue;
    }
    public static void writeExcelData(String file, String sheetName , int rowNumber, int cellNumber , String[] cellData) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook workBook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workBook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        Row row = sheet.getRow(0);
        Row newRow = sheet.createRow(rowCount + 1);
        for (int j = 0; j < row.getLastCellNum(); j++) {
            Cell cell = newRow.createCell(j);
            cell.setCellValue(cellData[j]);
        }
        fis.close();
        FileOutputStream fos = new FileOutputStream(file);
        workBook.write(fos);
        fos.close();

    }

}
