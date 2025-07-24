package com.tree;

// How to check if a string is a subsequence of another string
public class Subsequence_Check1 {

    static boolean checkSubSequence(String s1, String s2){
        int ptr1 = 0, ptr2 = 0;

        while(ptr1 < s1.length() && ptr2 < s2.length()){
            //System.out.println(s1.charAt(ptr1)+ " "+s2.charAt(ptr2));
            if(s1.charAt(ptr1) == s2.charAt(ptr2)){
                ptr1++;
                ptr2++;
            }else{
                ptr1++;
            }
        }
        // System.out.println(ptr2);
        return  ptr2 == s2.length();
    }

    public static void main(String[] args) {
        System.out.println(checkSubSequence("inside code", "ieod"));
    }
}
