package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class QueueOfferMethod {

  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();

    // Enqueue (add) elements to the queue using the offer method
    queue.add(4);
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.offer(5);


    for (Integer item: queue) {
      System.out.println(item);
    }
    // Peek at the front element of the queue
    System.out.println("Front of the queue: " + queue.peek()); // Output: 4

    // Dequeue (remove) elements from the queue
    int dequeuedItem = queue.poll();
    System.out.println("Dequeued item: " + dequeuedItem); // Output: 4

    // Peek at the front element of the queue after dequeuing
    System.out.println("Front of the queue after dequeue: " + queue.peek()); // Output: 1
  }
}

