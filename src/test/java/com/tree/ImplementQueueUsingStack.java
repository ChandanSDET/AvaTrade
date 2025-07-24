package com.tree;

import java.util.Stack;

public class ImplementQueueUsingStack {

  static Stack<Integer> stack1 =  new Stack<>();
  static Stack<Integer> stack2 =  new Stack<>();

  static void enqueue(int x){

    while(!stack1.isEmpty()){
      stack2.push(stack1.pop());
    }

    stack1.push(x);

    while (!stack2.isEmpty()){
      stack1.push(stack2.pop());
    }
  }

  static int dequeue(){
    if(stack1.isEmpty()){
      return -1;
    }
    int res  = stack1.peek();
    stack1.pop();
    return res;
  }

  public static void main(String[] args) {

    enqueue(1);
    enqueue(2);
    enqueue(3);

    System.out.println(dequeue());
    System.out.println(dequeue());
    System.out.println(dequeue());
  }

}
