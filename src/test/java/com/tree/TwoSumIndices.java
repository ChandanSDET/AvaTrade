package com.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumIndices {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer ,Integer> mp = new HashMap<>();

        for(int i = 0 ; i < nums.length; i++){
            if(mp.containsKey(nums[i])){
                return new int[]{mp.get(nums[i]), i};
            } else{
                mp.put(target-nums[i], i);
            }
            System.out.println(mp);
        }
        return new int[] {};
    }
    public static void main(String[] args) {
        int nums[] = {2,7,11,15};
        int target = 17;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
