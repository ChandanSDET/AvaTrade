package com.tree;

import java.util.PriorityQueue;

public class KthLargestElement {
  public static void main(String[] args) {
    int[] array = {31, 27, 11, 53, 62, 49}; // 11,27,31,49,53,62
    int k = 2;

    int kthLargest = findKthLargest(array, k);
    System.out.println("The " + k + "-th largest element in the array is: " + kthLargest);
  }

  public static int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    for (int num : nums) {
      minHeap.add(num);

      if (minHeap.size() > k) {
        minHeap.poll(); // Remove the smallest element if heap size exceeds k
      }
    }

    return minHeap.peek(); // The root of the heap is the k-th largest element
  }
}
