package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Utilities {


    public String readTestData(int vRow, int vColumn) {
        String value = null;
        Workbook wb = null;
        try {

            FileInputStream fis = new FileInputStream("src/test/TestData/Testdata.xlsx");
            wb = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(vRow);
        Cell cell = row.getCell(vColumn);
        value = cell.getStringCellValue();
        return value;
    }


    public Properties setupProp() throws IOException {
        FileReader reader = new FileReader("src/main/resources/browser.properties");
        Properties prop = new Properties();
        prop.load(reader);
        return prop;
    }
}
