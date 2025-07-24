package com.tree;

import java.util.Stack;

/**
 * Remove duplicates no. which are consecutive.
 *         Like
 *         Input = [1,2,2,3,4,5,5,3]
 *         output = [1,3,4,3]
 */

public class RemoveConsecutiveNumbers {

  public static void main(String[] args) {
    int num[] = {1,2,2,5,5,3,4,5,5,3,8,8,5};
    Stack<Integer> st = new Stack<>();
    for(int i = 0; i < num.length; i++){
      if(st.empty() || st.peek() != num[i]){
        st.push(num[i]);
      } else {
           st.pop();
      }
    }
    System.out.println(st);
  }
}
