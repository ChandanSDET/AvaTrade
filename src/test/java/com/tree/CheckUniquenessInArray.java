package com.tree;

import java.util.HashSet;
import java.util.Set;

public class CheckUniquenessInArray {

  static boolean isUnique(int arr[]){
    Set<Integer> uni = new HashSet<>();
     for(int i = 0; i< arr.length; i++){
       if (!uni.add(arr[i]) == true) {
         return false;
       }
     }
    return true;
  }
  public static void main(String[] args) {
   int arr[] = {12, 5, 9 ,22, 3, 20 , 5,2, 40, 19,30, 7, 15 ,4};
   Boolean res =  isUnique(arr);
    System.out.println(res);
  }
}
