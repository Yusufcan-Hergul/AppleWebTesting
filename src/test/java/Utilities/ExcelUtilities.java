package Utilities;

import com.aventstack.extentreports.gherkin.model.Scenario;
import com.google.protobuf.compiler.PluginProtos;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelUtilities {

    public static ArrayList<ArrayList <String >> getListData(String path, String sheetName, int columnCount){
        ArrayList<ArrayList <String >> tablo= new ArrayList<>();

        Workbook workBook= null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            workBook= WorkbookFactory.create(inputStream);
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        Sheet sayfa= workBook.getSheet(sheetName);

        for (int i = 0; i < sayfa.getPhysicalNumberOfRows(); i++){

            ArrayList<String> satirData= new ArrayList<>();
            for (int j = 0; j < columnCount; j++) {
                satirData.add( sayfa.getRow(i).getCell(j).toString());

            }
            tablo.add(satirData);
        }
        return tablo;
    }

    public static void writeExcel(String path, Scenario scenario, String browserName, String time) {

        File f =new File(path);

        if (!f.exists()) {
            XSSFWorkbook workbook= new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Page01");
            Row newRow = sheet.createRow(0);

            Cell newCell = newRow.createCell(0);





        }
    }
}
