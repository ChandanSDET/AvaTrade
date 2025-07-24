package com.tree;

public class BinarySearch {

  static int searchNum(int arr[], int low, int high, int target) {
    if (low < high) {
      int mid = (low + high) / 2;
      if (arr[mid] == target) {
        return mid;
      } else if (target > arr[mid]) {
        return searchNum(arr, mid+1, high, target);
      } else if (target < arr[mid]) {
        return searchNum(arr, low, mid-1, target);
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int arr[] = {2,3,5,6,7,8,9};
    int index = searchNum(arr, 0, arr.length-1, 3);
    System.out.println("Element is found at index: "+ index);
  }
}
