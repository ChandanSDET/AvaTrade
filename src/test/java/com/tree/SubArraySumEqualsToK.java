package com.tree;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsToK {
    public int subArraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0,1);
        for(int i = 0; i<nums.length; i++){
            sum = sum + nums[i];
            if(mp.containsKey(sum - k)){
              count++;
            }
            mp.put(sum, mp.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}
