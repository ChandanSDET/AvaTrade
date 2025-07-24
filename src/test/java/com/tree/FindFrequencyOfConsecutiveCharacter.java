package com.tree;

/**
 *         Input = [1,2,2,2,2,3,4,5,5,3]
 *         output = [1-1,2-4,3-1,4-1,5-2,3-1]
 */

  public class FindFrequencyOfConsecutiveCharacter {

  public static void main(String[] args) {
    int arr[] = {1,2,2,2,2,4,3,3,3};
    int counter = 1;
    for(int i=0; i<arr.length-1; i++){
      if(arr[i] != arr[i+1]){
        System.out.println(arr[i] +" - " +counter);
        counter = 1;
      }else{
        counter++;
      }
    }
    System.out.println(arr[arr.length-1]+" - " +counter);
  }
}
