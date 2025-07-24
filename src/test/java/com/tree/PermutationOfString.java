package com.tree;

public class PermutationOfString {

  private static void permuteString(String str, String ans){

    if(str.length() == 0){
      System.out.println(ans+ " ");
      return;
    }

    for(int i = 0 ; i <str.length(); i++) {
      // System.out.println("1st:"+str.substring(0, i));
      // System.out.println("2nd:" +str.substring(i+1));
      String ros = str.substring(0, i) + str.substring(i+1);
      //System.out.println("-->"+ros);
      permuteString(ros , ans+str.charAt(i));
    }
  }

  public static void main(String[] args) {
    permuteString("ab", "");
  }
}
