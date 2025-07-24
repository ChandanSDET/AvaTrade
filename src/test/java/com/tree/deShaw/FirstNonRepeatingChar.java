package com.tree.deShaw;

import java.util.*;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String str = "aabcbdebcd";
        Map<Character, Integer> mp = new LinkedHashMap<>();
        for(int i = 0; i<str.length(); i++){
                mp.put(str.charAt(i), mp.getOrDefault(str.charAt(i), 0)+1);
        }

        for(Map.Entry<Character,Integer> entry: mp.entrySet()){
            if(entry.getValue() == 1){
                System.out.println("The first non-repeating character:"+ entry.getKey());
                break;
            }
        }
    }
}
