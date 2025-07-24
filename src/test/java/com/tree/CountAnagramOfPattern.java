package com.tree;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CountAnagramOfPattern {
    public static int countAnagram(String str, String ptn){
        int n = str.length();
        int m = ptn.length();
        int ptn_arr[] = new int[26];
        int win_arr[] =  new int[26];
        int count = 0;
        for(int i = 0 ; i < m; i++){
            System.out.println(ptn.charAt(i) - 'a');
            ptn_arr[ptn.charAt(i) - 'a']++;
            win_arr[str.charAt(i) - 'a']++;
        }
        System.out.println(Arrays.toString(ptn_arr));
        System.out.println(Arrays.toString(win_arr));
        if(Arrays.equals(ptn_arr, win_arr)){
            count++;
        }
        System.out.println(count);
        for(int i = m; i <n; i++){
            win_arr[str.charAt(i) - 'a']++;
            win_arr[str.charAt(i-m) - 'a']--;
            if(Arrays.equals(ptn_arr, win_arr)){
                count++;
            }
        }
        //System.out.println(Arrays.toString(ptn_arr));
        //System.out.println(Arrays.toString(win_arr));
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countAnagram("xxorfxdofr","for"));
        int x = 'f' - 'a';
        System.out.println(x);
    }
}
