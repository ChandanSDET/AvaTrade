package com.tree;

import java.util.HashSet;
import java.util.Set;

public class palindromicSubString {
    static Set<String> palindromicSubStr(String s) {
        Set<String> st = new HashSet<>();
        String dub = s + s;
        for (int c = 0; c < s.length(); c++) {
            int left = c / 2;
            int right = left + (c % 2);

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                st.add(s.substring(left, right + 1));
                left++;
                right++;
            }
        }

        return st;
    }

    public static void main(String[] args) {
        System.out.println(palindromicSubStr("abc"));
    }
}
