package com.tree;

import java.util.HashMap;
import java.util.Map;

public class FindPairOfNumberWhoseSumIsK {

  public static void main(String[] args) {
    Map<Integer, Integer> pairs = new HashMap<>();
    int arr[] = {2, 5, 6, 7, 3, 4, 1, 3};
    // int count = 0;
    for (int i = 0; i < arr.length; i++) {
      if(pairs.containsKey(arr[i]))
        System.out.println(arr[i] +", "+ pairs.get(arr[i]));
      else
        pairs.put(6-arr[i], arr[i]);
  }
  }
}
