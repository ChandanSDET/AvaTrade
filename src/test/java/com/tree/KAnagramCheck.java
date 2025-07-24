package com.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import java.util.*;

public class KAnagramCheck {
    public static boolean areKAnagrams(String s1, String s2, int k) {
        if (s1.length() != s2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Count character frequencies
        for (char c : s1.toCharArray()) freq1[c - 'a']++;
        for (char c : s2.toCharArray()) freq2[c - 'a']++;

        int changesNeeded = 0;

        // Count extra characters in s1 not matched in s2
        for (int i = 0; i < 26; i++) {
            if (freq1[i] > freq2[i]) {
                changesNeeded += freq1[i] - freq2[i];
            }
        }

        return changesNeeded <= k;
    }

    public static void main(String[] args) {
        System.out.println(areKAnagrams("anagram", "grammar", 3)); // true
        System.out.println(areKAnagrams("anagram", "grammar", 2)); // false
        System.out.println(areKAnagrams("apple", "pleap", 0));     // true
        System.out.println(areKAnagrams("apple", "peach", 2));     // false
    }
}
