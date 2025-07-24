package com.tree;

import java.util.Arrays;

public class RotationFromBeginning {
  static int[] rotateArray(int arr[], int rotation){
    for(int i = 0; i < rotation; i++){
      int temp =  arr[0];
      for(int j = 0; j < arr.length-1; j++){
        arr[j] = arr[j+1];
      }
      arr[arr.length-1] = temp;
    }
    return arr;
  }

  public static void rotateRight(int[] arr, int k) {
    int n = arr.length;
    k = k % n; // Handle cases where k is larger than the array size
    reverse(arr, 0, n - 1);
    reverse(arr, 0, k - 1);
    reverse(arr, k, n - 1);
  }

  public static void rotateLeft(int[] arr, int k) {
    int n = arr.length;
    k = k % n; // Handle cases where k is larger than the array size
    reverse(arr, 0, k - 1);
    reverse(arr, k, n - 1);
    reverse(arr, 0, n - 1);
  }

  // Helper method to reverse a portion of the array
  private static void reverse(int[] arr, int start, int end) {
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }

  public static void main(String[] args) {
    int arr[] = {1,2,3,4,5};
    int rotation = 2;
    rotateRight(arr, rotation);
    System.out.println(Arrays.toString(arr));
  }

}
