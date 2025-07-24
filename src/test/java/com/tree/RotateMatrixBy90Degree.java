package com.tree;

public class RotateMatrixBy90Degree {

  /**
   * {{1,2,3},
   * {4,5,6},
   * {7,8,9}}
   *
   * {{7, 4, 1}
   * {8, 5, 2},
   * {9, 6, 3}}
   *
   * [(2,0), (1,0),(0,0)
   * (2,1), (1,1), (0,1)
   * (2,2), (1,2),(0,2)]
   *
   * Anti Clock Wise
   * [
   * (0,2),(1,2),(2,2),
   * (0,1),(1,1),(2,1),
   * (0,0),(1,0),(1,0)
   *]
   */

  static void rotateMatrixBy90DegreeClockWise(int[][] matrix){

    for(int i = 0; i<=2; i++){
      for(int j= 2; j>=0; j--){
        System.out.print(matrix[j][i] + " ");
      }
      System.out.println();
    }

  }


  static void rotateMatrixBy90DegreeAntiClockWise(int[][] matrix){

    for(int i = 2; i>=0; i--){
      for(int j= 0; j<=2; j++){
        System.out.print(matrix[j][i] + " ");
      }
      System.out.println();
    }

  }

  public static void main(String[] args) {
    int[][] matrix = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
    };
    rotateMatrixBy90DegreeClockWise(matrix);
    System.out.println();
    rotateMatrixBy90DegreeAntiClockWise(matrix);
  }

}
