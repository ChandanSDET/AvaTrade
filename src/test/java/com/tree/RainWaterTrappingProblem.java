package com.tree;

import java.util.Arrays;

public class RainWaterTrappingProblem {

  static int getTrappedUnitOfWater(int arr[] , int n){

    int left[] = new int[n];
    int right[] = new int[n];
    int trappedWater = 0;
    left[0] = arr[0];
    for(int i = 1; i<n;i++){
      left[i] = Math.max(arr[i], left[i-1]);
    }
    System.out.println(Arrays.toString(left));
    right[n-1] = arr[n-1];
    for(int i = n - 2; i >=0; i--){
      right[i] = Math.max(arr[i], right[i+1]);
    }
    System.out.println(Arrays.toString(right));
    for(int i = 0; i<arr.length; i++){
      trappedWater = trappedWater+(Math.min(left[i], right[i]) - arr[i]);
    }
    return trappedWater;
  }

  public static void main(String[] args) {
    int arr[]   = {3, 0, 2, 0, 4};
    System.out.println(getTrappedUnitOfWater(arr, arr.length));
  }
}
