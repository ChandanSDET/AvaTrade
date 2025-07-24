package com.tree;

import java.util.HashSet;
import java.util.Set;

public class PalendromicSubStrings {
    public static Set<String> getPalendroicSubStrings(String s){
        Set<String> st = new HashSet<>();

        for(int c = 0; c<2*s.length()-1; c++){
            int l = c/2;
            int r = l + (c%2);
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                st.add(s.substring(l, r +1));
                l--;
                r++;
            }
        }
        return st;
    }

    public static void main(String[] args) {
        System.out.println(getPalendroicSubStrings("aaaa"));
        System.out.println('c'-'a');
    }
}
