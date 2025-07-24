package com.tree;

import java.util.Arrays;

public class ReverseArray {

  public static void main(String[] args) {

    int arr[] = {2, 5, 3, 6, 9};
    int j = arr.length - 1;
    for(int i = 0; i<arr.length/2; i++){
      int temp = arr[i];
      arr[i] = arr[j-i];
      arr[j-i] = temp;
    }
    System.out.println(Arrays.toString(arr));
  }

}
