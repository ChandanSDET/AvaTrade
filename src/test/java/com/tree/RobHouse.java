package com.tree;

public class RobHouse {
  public static int rob(int[] nums) {
    int sum = 0;
    for(int i = 0; i<nums.length; i=i+2){
      sum = sum + nums[i];
    }
    return sum;
  }

  public static void main(String[] args) {
    int nums[] =  {2,7,9,3,1};
    int res = rob(nums);
    System.out.println(res);
  }
}
