package com.tree;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {
    static int lengthOfLongestSubstringWithoutRepeatingChar(String s){
        int max = 0, left = 0 , right = 0;
        Set<Character> se = new HashSet<>();
        while(right < s.length()){
            Character c = s.charAt(right);
            if(!se.contains(c)){
                se.add(c);
                max = Math.max(max, right-left+1);
                right ++;
            } else{
                se.remove(s.charAt(left));
                left ++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating sol = new LongestSubstringWithoutRepeating();
        // System.out.println(sol.lengthOfLongestSubstringWithoutRepeatingChar("abcabcbb")); // "abc"
        System.out.println(sol.lengthOfLongestSubstringWithoutRepeatingChar("bbbbb"));    // "b"
        // System.out.println(sol.longestSubstring("pwwkew"));
    }
}
