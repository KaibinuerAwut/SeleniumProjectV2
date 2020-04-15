package com.automation.officeHourPractice;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;

public class UnderstandingExcelConnection {

    @Test
    public void readingExcelFile() throws Exception{


    //which file we are calling upon.     location of file

    String filePath = "/Users/qalbi/Downloads/Countries.xlsx";

    // we must load our excel file as java file(bytecode)
        FileInputStream byteCodeOfExcelFile = new FileInputStream(filePath);
    //load our workbook as a file
    Workbook workbook = WorkbookFactory.create(byteCodeOfExcelFile);
    // the sheet that we are working on
    Sheet workSheet = workbook.getSheet("Countries");

        Cell cell;
        cell = workSheet.getRow(0).getCell(1);
        System.out.println(cell.toString());

        Cell cell2;
        cell2 = workSheet.getRow(0).getCell(2);
        System.out.println(cell2.toString());




}




}
