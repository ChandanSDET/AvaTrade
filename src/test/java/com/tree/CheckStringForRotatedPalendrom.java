package com.tree;

public class CheckStringForRotatedPalendrom {
    static boolean isRotatedPalindrome(String s){
        String dub = s+s;
        int n = s.length();
        for(int i =0;i<n; i++){
            String rotation = dub.substring(i, i+n);
            if(isRotation(rotation)){
                return true;
            }
        }
        return false;
    }

    private static boolean isRotation(String rotation) {
        int n = rotation.length();
        for(int i=0; i<n;i++){
            if(rotation.charAt(i) != rotation.charAt(n- 1 - i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isRotatedPalindrome("aab"));//true
        System.out.println(isRotatedPalindrome("madam"));  // true
        System.out.println(isRotatedPalindrome("abc"));   // false
        System.out.println(isRotatedPalindrome("aaa"));   // true
        System.out.println(isRotatedPalindrome("baab"));  // true
    }
}
