package com.tree;

import java.util.Arrays;

public class RotateFromEnd {

  static int[] rotate(int arr[], int rotation){
    for(int i = 0; i<rotation;i++){
      int temp = arr[arr.length-1];
      for(int j = arr.length-1 ; j > 0; j--){
        arr[j] = arr[j-1];
      }
      arr[0] = temp;
    }
    return arr;
  }

  public static void main(String[] args) {
    int arr[] = {2, 3, 4, 7, 8, 5};
    int rotation = 2;
    int result[] = rotate(arr, rotation);
    System.out.println(Arrays.toString(result));
  }
}
