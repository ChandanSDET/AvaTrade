package com.tree;

import java.sql.SQLOutput;

class CheckNumberIsPowerOfTwo {
  public static void main(String[] args) {
    int num = 8;

    if((num & num-1) == 0){
      System.out.println("Given number is power of 2");
    }else{
      System.out.println("Given number is not power of 2");
    }
  }
}
