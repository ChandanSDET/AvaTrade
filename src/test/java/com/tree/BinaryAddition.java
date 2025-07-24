package com.tree;

public class  BinaryAddition {
  public static void main(String[] args) {
    String binary1 = "011011"; // Replace with your first binary number
    String binary2 = "010111"; // Replace with your second binary number

    String result = addBinary(binary1, binary2);

    System.out.println("Binary 1: " + binary1);
    System.out.println("Binary 2: " + binary2);
    System.out.println("Sum in Binary: " + result);
  }

  public static String addBinary(String binary1, String binary2) {
    StringBuffer result = new StringBuffer();
    int carry = 0;

    int i = binary1.length() - 1;
    int j = binary2.length() - 1;

    while (i >= 0 || j >= 0 || carry > 0) {
      System.out.println(binary1.charAt(i) - '0');
      int bit1 = (i >= 0) ? binary1.charAt(i) - '0' : 0;
      System.out.println(bit1);
      int bit2 = (j >= 0) ? binary2.charAt(j) - '0' : 0;
      System.out.println(bit2);
      int sum = bit1 + bit2 + carry;
      System.out.println(sum);
      result.insert(0, sum % 2);
      carry = sum / 2;

      i--;
      j--;
      System.out.println("----");
    }

    return result.toString();
  }


}




