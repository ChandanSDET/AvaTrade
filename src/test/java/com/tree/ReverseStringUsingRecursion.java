package com.tree;

class ReverseStringUsingRecursion {

  public static String reverseString(String str){

    if(str.length() == 0){
        return str;
    }
 else{
    return reverseString(str.substring(1))+str.charAt(0);
    }
  }
  public static void main(String[] args) {
    String resultantSting1 = reverseString("JAVATPOINT");
    System.out.println(resultantSting1);
  }
}
