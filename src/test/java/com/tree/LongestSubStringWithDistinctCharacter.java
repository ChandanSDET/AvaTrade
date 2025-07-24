package com.tree;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithDistinctCharacter {

    public static String longestSubstring(String s){
        int right = 0, left = 0, maxLength = 0, statIndex = 0;
        Set<Character> seen = new HashSet<>();
        while (right < s.length()){
            Character c =  s.charAt(right);
            if(!seen.contains(c)){
                seen.add(c);
                if(right - left + 1 > maxLength) {
                    maxLength = right - left + 1;
                    statIndex = left;
                }
                    right++;

            }else{
                seen.remove(s.charAt(left));
                left++;
            }
        }
        return s.substring(statIndex, statIndex+maxLength);
    }

    public static void main(String[] args) {
        System.out.println(LongestSubStringWithDistinctCharacter
                .longestSubstring("abcabdcbb"));
        System.out.println(LongestSubStringWithDistinctCharacter
                .longestSubstring("bbbbb"));
    }
}
