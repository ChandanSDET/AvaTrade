package com.tree;

public class CheckSubSequence {
    public static boolean checkSubSeq(String str1, String str2){
        int ptr1 = 0; int ptr2 = 0;

        while(ptr1 < str1.length() && ptr2 < str2.length()){
            if(str1.charAt(ptr1) == str2.charAt(ptr2)){
                ptr1++;
                ptr2++;
            }else{
                ptr1++;
            }
        }
        return ptr2 == str2.length();
    }
    public static void main(String[] args) {
        System.out.println(checkSubSeq("abcd", "db"));
    }
}
