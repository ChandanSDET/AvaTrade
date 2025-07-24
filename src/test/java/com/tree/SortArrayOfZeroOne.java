package com.tree;

import java.util.Arrays;

public class SortArrayOfZeroOne {

  public static void main(String[] args) {
    int arr[] = { 0, 1, 1, 0, 0, 0, 0, 1};
    int j = -1;
    for(int i =0; i<arr.length;i++){
      if(arr[i] < 1){
        j++;
        int temp =  arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
      }
    }
    System.out.println(Arrays.toString(arr));
  }
}
