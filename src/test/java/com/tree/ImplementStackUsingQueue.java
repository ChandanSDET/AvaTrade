package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

  static Queue<Integer> q1 = new LinkedList<>();
  static Queue<Integer> q2 = new LinkedList<>();

  static void push(int x){

    q2.add(x);

    while(!q1.isEmpty()){
      q2.add(q1.peek());
      q1.remove();
    }

    Queue<Integer> q =  q1;
    q1 = q2;
    q2 = q;
  }

  static int pop(){
    int x =  q1.peek();
    q1.remove();
    return x;
  }

  public static void main(String[] args) {
    push(1);
    push(2);
    push(3);

    System.out.println(pop());
    System.out.println(pop());
    System.out.println(pop());
  }
}
