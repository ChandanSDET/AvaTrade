package com.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class Excel_Util {

  public String path;
  public FileInputStream fis = null;
  public FileOutputStream fileOut = null;
  private XSSFWorkbook workbook = null;
  private XSSFSheet sheet = null;
  private XSSFRow row = null;
  private XSSFCell cell = null;
  private String sheetName;

  public Excel_Util(String path, String sheetName) {
    this.sheetName =sheetName;
    this.path = path;
    try {
      fis = new FileInputStream(path);
      workbook = new XSSFWorkbook(fis);
      sheet = workbook.getSheetAt(0);
      fis.close();
    } catch (Exception e) {
    }
  }

  // returns the row count in a sheet
  public int getRowCount() {
    int index = workbook.getSheetIndex(sheetName);
    if (index == -1)
      return 0;
    else {
      sheet = workbook.getSheetAt(index);
      int number = sheet.getLastRowNum() + 1;
      return number;
    }

  }

  // returns the data from a cell
  public String getCellData(String colName, int rowNum) {
    try {
      if (rowNum <= 0)
        return "";

      int index = workbook.getSheetIndex(sheetName);
      int col_Num = -1;
      if (index == -1)
        return "";

      sheet = workbook.getSheetAt(index);
      row = sheet.getRow(0);
      for (int i = 0; i < row.getLastCellNum(); i++) {
        if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
          col_Num = i;
      }
      if (col_Num == -1)
        return "";

      sheet = workbook.getSheetAt(index);
      row = sheet.getRow(rowNum - 1);
      if (row == null)
        return "";
      cell = row.getCell(col_Num);

      if (cell == null)
        return "";
      if (cell.getCellType() == CellType.STRING) {
        return cell.getStringCellValue();
      }
      else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
        String cellText = String.valueOf(cell.getNumericCellValue()).replace(".0", "");
        return cellText;
      } else if (cell.getCellType() == CellType.BLANK) {
        return "";
      }
      else {
        return String.valueOf(cell.getBooleanCellValue());
      }
    } catch (Exception e) {
      return "row " + rowNum + " or column " + colName + " does not exist in xls";
    }
  }


  public int getColumnCount() {
    sheet = workbook.getSheet(sheetName);
    row = sheet.getRow(0);

    if (row == null)
      return -1;

    return row.getLastCellNum();

  }

}