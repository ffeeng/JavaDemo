package com.poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;


public class PoiDemo {

    public static void main(String[] args) throws Exception {
        //读写Excel
        String[][] data = {{"a","b"},{"c","d"}};
        writeExcel(data);
        readExcel();
        //读写word
        writeWord();
        readWord();
    }

    //写word  InputStream->XWPFDocument ->XWPFParagraph->XWPFRun
    private static void readWord() throws Exception {

        String path = "D:\\IdeaProjects\\demo\\out\\production\\resources\\static\\a.word";
        InputStream is = new FileInputStream(path);
        XWPFDocument doc = new XWPFDocument(is);
        System.out.println(doc.getParagraphs().get(0).getRuns().get(0).text());
        is.close();
    }

    //写word  XWPFDocument ->XWPFParagraph->XWPFRun->OutputStream
    private static void writeWord() throws Exception {
        XWPFDocument doc = new XWPFDocument();
        XWPFParagraph p = doc.createParagraph();
        XWPFRun run = p.createRun();
        run.setText("hello");
        String path = "D:\\IdeaProjects\\demo\\out\\production\\resources\\static\\a.word";
        File file = new File(path);
        FileOutputStream fos = new FileOutputStream(file);
        doc.write(fos);

    }

    //写文件过程 HSSFWorkbook ->Sheets->Sheet->Row->Cell->File
    private static void writeExcel(String[][] data) throws Exception {
        String path = "D:\\IdeaProjects\\demo\\out\\production\\resources\\static\\a.xls";
        HSSFWorkbook sheets = new HSSFWorkbook();
        HSSFSheet sheet = sheets.createSheet("table");
        for(int i=0;i<data.length;i++){
            HSSFRow row = sheet.createRow(i);
            for(int j=0;j<data[i].length;j++){
                HSSFCell cell = row.createCell(j);
                cell.setCellValue(data[i][j]);
            }
        }
        File file = new File(path);
        sheets.write(file);


    }
    //读文件过程 File->HSSFWorkbook ->Sheets->Sheet->Row->Cell
    public static void readExcel() throws Exception {
        String path = "D:\\IdeaProjects\\demo\\out\\production\\resources\\static\\a.xls";
        InputStream is = new FileInputStream(path);
        HSSFWorkbook sheets = new HSSFWorkbook(is);
        final int numberOfSheets = sheets.getNumberOfSheets();
        HSSFSheet sheet = sheets.getSheetAt(0);
        String sheetName = sheet.getSheetName();
        System.out.println("sheetName: "+sheetName);

        for(Row row: sheet){
            for(Cell cell: row){
                CellType type = cell.getCellTypeEnum();
                if(type==CellType.NUMERIC){
                    System.out.print("  "+cell.getNumericCellValue());
                }else if(type==CellType.STRING){
                    System.out.print("  "+cell.getStringCellValue());
                }else{
                    System.out.println(type);
                }
            }
            System.out.println();
        }
    }

}
