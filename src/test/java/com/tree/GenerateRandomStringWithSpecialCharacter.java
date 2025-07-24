package com.tree;

import java.util.Random;

public class GenerateRandomStringWithSpecialCharacter {

  public static void main(String[] args) {
    final String source = "abc@#%^defghijklmnopq@#$%^rstuvwxyz@#%^&*!";
    StringBuilder sb = new StringBuilder(6);
    for (int i = 0; i < 6; i++)
      sb.append(source.charAt(new Random().nextInt(source.length())));
    System.out.println(sb.toString());
  }
}
