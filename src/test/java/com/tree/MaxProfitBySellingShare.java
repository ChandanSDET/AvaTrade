package com.tree;

public class MaxProfitBySellingShare {

  static int maxProfit(int arr[]){
    int maxProfit = 0;
    int minPrice = arr[0];
    for(int i = 0; i<arr.length; i++){
      minPrice = Math.min(minPrice, arr[i]);
      int profit  = arr[i] - minPrice;
      maxProfit = Math.max(profit, maxProfit);
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    int arr[] = {7,6,4,3,1};
    int maxProfit = maxProfit(arr);
    System.out.println(maxProfit);
  }
}
