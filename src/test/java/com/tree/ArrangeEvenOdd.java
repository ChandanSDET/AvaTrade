package com.tree;

import java.util.Arrays;

public class ArrangeEvenOdd {
  public static void main(String[] args) {
    int arr[] = {2, 3, 5, 8, 9, 6};
    int start = 0;
    int end = arr.length-1;

    while(start < end){

      while(arr[start] %2 == 0){
        start++;
      }
      while(arr[end] %2 != 0){
        end --;
      }
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end]  = temp;
      start++;
      end --;
    }
    System.out.println(Arrays.toString(arr));
  }
}
