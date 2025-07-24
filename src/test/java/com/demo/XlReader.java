package com.demo;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class XlReader {
  static Map<Integer, String> testDescriptionMap;
  static Map<Integer, String> clientMap;
  static void readExcl() throws IOException {
    FileInputStream file = new FileInputStream(
            "/Users/chandan/IdeaProjects/Ava-trade/data.xlsx");
    XSSFWorkbook wb = new XSSFWorkbook(file);
    XSSFSheet sh = wb.getSheet("Sheet1");

     testDescriptionMap = new HashMap<Integer, String>();
     clientMap = new HashMap<Integer, String>();

    for (int row = 1; row <= sh.getLastRowNum(); row++) {
      Integer testId = (int)sh.getRow(row)
              .getCell(0)
              .getNumericCellValue();

      String testDescription = sh.getRow(row)
              .getCell(1)
              .getStringCellValue();

      String client = sh.getRow(row)
              .getCell(2)
              .getStringCellValue();

      testDescriptionMap.put(testId, testDescription);
      clientMap.put(testId, client);
    }
    wb.close();
    file.close();
  }

  static String getCellValue(Integer caseId, String columnName) throws IOException {
    readExcl();
    switch(columnName){
      case "TestDesc.":
        return testDescriptionMap.get(caseId);
      case "Client":
         return clientMap.get(caseId);
      default:
        return new Exception("Please check the column name").toString();
    }
  }

  public static void main(String[] args) throws IOException {
    System.out.println(getCellValue(10001, "TestDesc."));
    System.out.println(getCellValue(10052, "TestDesc."));
    System.out.println(getCellValue(10052, "Client"));
  }
}
