package com.tree;

import java.util.Arrays;
import java.util.Stack;

class FloodFillWithStack {
  public static void main(String[] args) {
    int[][] image = {
            {1, 1, 1, 1, 1},
            {1, 1, 1, 0, 0},
            {1, 0, 0, 1, 1},
            {1, 0, 1, 1, 1}
    };

    int sr = 1; // Starting row
    int sc = 2; // Starting column
    int newColor = 2; // New color to fill

    floodFill(image, sr, sc, newColor);

    // Print the updated image
    for (int[] row : image) {
      for (int pixel : row) {
        System.out.print(pixel + " ");
      }
      System.out.println();
    }
  }

  public static void floodFill(int[][] image, int sr, int sc, int newColor) {
    int rows = image.length;
    int cols = image[0].length;
    int originalColor = image[sr][sc];

    if (originalColor == newColor) {
      return; // No need to flood fill if the new color is the same as the original color
    }

    Stack<int[]> stack = new Stack<>();
    stack.push(new int[]{sr, sc});
    // System.out.println(stack);
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // Right, Left, Down, Up

    while (!stack.isEmpty()) {
      int[] current = stack.pop();
      System.out.println(Arrays.toString(current));
      int row = current[0];
      int col = current[1];

      image[row][col] = newColor;

      for (int[] dir : directions) {
        int newRow = row + dir[0];
        int newCol = col + dir[1];

        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && image[newRow][newCol] == originalColor) {
          stack.push(new int[]{newRow, newCol});
        }
      }
    }
  }
}
