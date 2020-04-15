package com.automation.tests.Day28_write_into_excel;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class writeIntoExcelFile {

    @Test
    public void writeIntoFileTest() throws Exception  {


        FileInputStream inputStream = new FileInputStream("VytrackTestUsers.xlsx");
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet("QA3-short");
        Row row = sheet.getRow(0);

        Cell cell = row.getCell(row.getLastCellNum()-1);
        System.out.println(cell.getStringCellValue());

        System.out.println("Before: "+cell.getStringCellValue());
        cell.setCellValue("Failed");//I am changing from n/a to passed
        System.out.println("After: "+cell.getStringCellValue());

        //I create if I want to write something into the file
        //don't forget to close excel file if you opened it
        FileOutputStream outputStream = new FileOutputStream("VytrackTestUsers.xlsx");
        workbook.write(outputStream); // write changes
        workbook.close(); // when everything done


    }


}
