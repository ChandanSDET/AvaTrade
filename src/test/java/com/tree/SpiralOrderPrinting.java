package com.tree;

import java.util.ArrayList;
import java.util.List;

class SpiralOrderPrinting {


  static List<Integer>  getSpiralOrder(int[][] matrix){
    int top, buttom, left ,right, dir;
    top=0;
    buttom=matrix.length-1;
    left=0;
    right=matrix[0].length-1;
    dir=0;
    int i;
    List<Integer> ans = new ArrayList<>();

    while(top<=buttom && left<=right){
      if(dir==0) {
        for(i=left;i<=right;i++) {
          ans.add(matrix[top][i]);
        }
        top++;
      }
      else if(dir == 1){
        for(i=top; i<=buttom; i++){
          ans.add(matrix[i][right]);
        }
        right--;
      }
      else if(dir == 2){
        for(i=right; i>=left; i--){
          ans.add(matrix[buttom][i]);
        }
        buttom--;
      }
      else if(dir == 3){
        for(i=buttom; i>=top; i--){
         ans.add(matrix[i][left]);
        }
        left++;
      }
      dir = (dir+1) %4;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] matrix = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
    };

    System.out.println(getSpiralOrder(matrix));
  }
}
