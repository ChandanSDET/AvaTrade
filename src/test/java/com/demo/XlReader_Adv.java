package com.demo;

public class XlReader_Adv {
  static Excel_Util eu;

  static String getDataFromExcel(String expectedTestId, String columnName) {
    eu = new Excel_Util("/Users/chandan/IdeaProjects/Ava-trade/data.xlsx", "Sheet1");

    for (Integer row = 1; row <= eu.getRowCount(); row++) {
      String testId = eu.getCellData("TC ID.", row);
      if (testId.equals(expectedTestId)) {
        return eu.getCellData(columnName, row);
      }
    }
    return null;
  }

  public static void main(String[] args) {
    System.out.println(getDataFromExcel("10004", "TestDesc."));
    System.out.println(getDataFromExcel("10004", "Client"));

    System.out.println(getDataFromExcel("10001", "TestDesc."));
    System.out.println(getDataFromExcel("10001", "Client"));


    System.out.println(getDataFromExcel("10002", "TestDesc."));
    System.out.println(getDataFromExcel("10002", "Client"));
  }
}
