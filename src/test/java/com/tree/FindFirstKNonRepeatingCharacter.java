package com.tree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindFirstKNonRepeatingCharacter {

    static List<Character> findKFirstNonRepeatingChar(String s, int k){
        List<String> l = new ArrayList<>();
        Map<Character, Integer> mp  = new LinkedHashMap<Character, Integer>();
        for(int i =0 ;i<s.length(); i++){
            Character c =  s.charAt(i);
            if(!mp.containsKey(c)){
                mp.put(c, 1);
            }else{
                mp.remove(c);
            }
        }
        return mp.keySet().stream().limit(3).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String str = "geeaksforngeeks";
        int k = 3;
        List<Character> res = findKFirstNonRepeatingChar(str, k);
        System.out.println(res);  // Output: [f, o, r]
    }
}
