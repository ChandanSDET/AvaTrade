package com.tree;

public class LongestSumContiguousSubArray {

  static int maxSumSubArray(int a[])
  {
    int maximum_sum = 0;
    int current_sum = 0;
    for(int i=0; i< a.length; i++)
    {
      current_sum = current_sum + a[i];

      if(current_sum > maximum_sum)
      {
        maximum_sum = current_sum;
      }
      if(current_sum < 0)
      {
        current_sum = 0;
      }
    }
    return maximum_sum;
  }

  public static void main(String[] args) {
    int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
    int max_sum = maxSumSubArray(a);
    System.out.printf("Maximum sum of the contiguous array is : %d", max_sum);
  }
}
