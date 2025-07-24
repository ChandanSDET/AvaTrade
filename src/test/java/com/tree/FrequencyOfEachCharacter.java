package com.tree;

import java.util.HashMap;
import java.util.Map;

public class FrequencyOfEachCharacter {
  public static void main(String[] args) {
    String str = "chandan";
    Map<Character, Integer> mp = new HashMap<>();
    for(Character c: str.toCharArray()){
      if(mp.containsKey(c)){
        mp.put(c,mp.get(c)+1);
      }else{
        mp.put(c,1);
      }
    }
    System.out.println(mp);
  }
}
