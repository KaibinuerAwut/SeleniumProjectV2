package com.automation.tests.Day28_write_into_excel;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;

public class writeIntoExcelFile {

    @Test
    public void writeIntoFileTest() throws Exception  {


        FileInputStream inputStream = new FileInputStream("VytrackTestUsers.xlsx");
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet("QA3-short");
        Row row = sheet.getRow(0);

        Cell cell = row.getCell(row.getLastCellNum()-1);
        System.out.println(cell.getStringCellValue());









    }


}
