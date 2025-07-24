package com.tree;

public class RotatedPalendrom {

    public static boolean isRotatedPalindrom(String s){
        String dup = s + s;
        int n = s.length();
        for(int i = 0; i<s.length(); i++){
            String rota = dup.substring(i, n+i);
            if(rotation(rota)){
                return true;
            }
        }
        return false;
    }

    private static boolean rotation(String rota) {
        int n = rota.length();
        for(int i = 0; i<n; i++){
            if(rota.charAt(i) != rota.charAt(n-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isRotatedPalindrom("abc"));
    }
}
