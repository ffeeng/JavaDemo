package com.poi;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RestController
public class PoiController {

    @RequestMapping("readExcel")
    public String readExcel() throws Exception {

        String path = "E:\\ideaWorkspace\\demo\\out\\production\\resources\\static\\a.xls";

        InputStream is = new FileInputStream(path);
        HSSFWorkbook sheets = new HSSFWorkbook(is);
        final int numberOfSheets = sheets.getNumberOfSheets();
        HSSFSheet sheet = sheets.getSheetAt(0);
        String sheetName = sheet.getSheetName();
        System.out.println("sheetName: "+sheetName);

        for(Row row: sheet){
            for(Cell cell: row){
                System.out.println(cell.getStringCellValue());
            }
        }
        return "";
    }

}
