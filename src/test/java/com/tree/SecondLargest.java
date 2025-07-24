package com.tree;

public class SecondLargest {

  public static void main(String[] args) {
    int arr[] = {2,5,6,8,4,3};
    int max_1 = Integer.MIN_VALUE;
    int max_2 = Integer.MIN_VALUE;
    for(int i = 0; i<arr.length; i++){
      if(arr[i] > max_1){
        max_2 = max_1;
        max_1 = arr[i];
      } else if(arr[i] != max_1 && arr[i] > max_2) {
        max_2 = arr[i];
      }
    }
    System.out.println(max_2);
  }
}
