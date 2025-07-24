package com.bhas.complex.payload;

import java.util.HashMap;
import java.util.Map;

class GFG {


  public static void
  countDuplicateCharacters(String str)
  {
    Map<Character, Integer> map
            = new HashMap<Character, Integer>();

    char[] charArray = str.toCharArray();

    for (char c : charArray) {
      if (map.containsKey(c)) {
        map.put(c, map.get(c) + 1);
      }
      else {
        map.put(c, 1);
      }
    }

    for (Map.Entry<Character, Integer> entry :
            map.entrySet()) {

      if (entry.getValue() > 1) {
        System.out.println(entry.getKey());
      }
    }
  }


  public static void
  main(String args[]) {
    String str = "Pranab Kumar Behera";
    countDuplicateCharacters(str);
    int i, j, row = 6;
    for (i = 0; i < row; i++) {
      for (j = 0; j <= i; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }
}