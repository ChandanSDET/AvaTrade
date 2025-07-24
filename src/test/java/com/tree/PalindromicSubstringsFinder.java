package com.tree;

import java.util.*;

public class PalindromicSubstringsFinder {
    public static Set<String> findPalindromicSubstrings(String s) {
        Set<String> result = new LinkedHashSet<>();
        for (int center = 0; center < s.length() -1; center++) {
            System.out.println(center);
            int left = center / 2; // Left side of current pointer
            int right = left + center % 2; // Moves right pointer correctly

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                result.add(s.substring(left, right + 1));
                left--;
                right++;
            }
            System.out.println(result);
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "abbac";
        Set<String> palindromes = findPalindromicSubstrings(input);
        System.out.println("Palindromic substrings: " + palindromes);
    }
}
