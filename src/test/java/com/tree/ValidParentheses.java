package com.tree;

import java.util.Stack;

public class ValidParentheses {
  static boolean validParentheses(String parentheses){
    Stack<Character> st = new Stack<>();
    for(Character c : parentheses.toCharArray()){
      if(c == '{'){
        st.push('}');
      } else if (c == '['){
        st.push(']');
      } else if (c == '('){
        st.push(')');
      }else if(st.empty() || st.pop() != c){
       return false;
      }
    }
    return st.isEmpty();
  }
  public static void main(String[] args) {
    String parentheses = "{{}[]()}";
   if(validParentheses(parentheses)){
     System.out.println("Valid one");
   }else{
     System.out.println("Invalid one");
   }
  }
}
