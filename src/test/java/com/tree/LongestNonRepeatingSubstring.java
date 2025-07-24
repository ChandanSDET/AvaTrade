package com.tree;

import java.util.HashSet;
import java.util.Set;

public class LongestNonRepeatingSubstring {

    public static String longestSubstring(String s){
        int right = 0, left = 0, maxLength = 0, startIndex = 0;
        Set<Character> seen = new HashSet<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            if (!seen.contains(c)) {
                seen.add(c);
                if (right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    startIndex = left; // ✅ fix here
                }
                right++;
            } else {
                seen.remove(s.charAt(left));
                left++;
            }
        }

        return s.substring(startIndex, startIndex + maxLength);
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("abcabdcbb")); // ✅ Expected: "cabd"
        System.out.println(longestSubstring("bbbbb"));     // ✅ Expected: "b"
    }
}