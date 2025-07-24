package com.tree;

public class PalindromeString {
  public static void main(String[] args) {
    String str = "mom";
    int j = str.length() - 1;
    for(int i = 0; i < str.length(); i++){
      if(str.charAt(i) != str.charAt(j-i)){
        System.out.println("It is not a palindrome");
        break;
      }
    }
    System.out.println("String is palindrome");
  }
}
