package com.tree.deShaw;

import java.util.LinkedHashSet;
import java.util.Set;

public class LengthOfLongestDistinctSubArray {
    public static void main(String[] args) {
        // int arr[] = {2,6,4,5,6,7,2,5,6};
        int arr[] = {2,2,2,3,4,4};
        Set<Integer> seen = new LinkedHashSet<>();
        int right = 0, left = 0 , max = 0, curr = 0;
        while(right < arr.length){
            if(!seen.contains(arr[right])){
                seen.add(arr[right]);
                if(right - left +1 > max){
                    max = right - left +1;
                    curr = left;
                }
                right++;
            }else{
                seen.remove(arr[left]);
                left++;
            }
        }
        for(int i = curr; i <curr+max; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
