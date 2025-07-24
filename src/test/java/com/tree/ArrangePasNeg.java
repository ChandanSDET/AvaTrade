package com.tree;

import java.util.Arrays;

public class ArrangePasNeg {

  public static void main(String[] args) {

    int arr[] = {2,-7, 5,-3, 2, 7, -9};

    int start = 0;
    int end = arr.length-1;

    while (start <end){
      while(arr[start] < 0){
        start++;
      }
      while(arr[end] > 0){
        end--;
      }
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
    System.out.println(Arrays.toString(arr));
  }
}
