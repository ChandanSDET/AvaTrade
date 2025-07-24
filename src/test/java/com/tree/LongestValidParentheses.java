package com.tree;

import java.util.Stack;

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);  // Base for valid substring index
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();  // Pop the last open bracket index
                if (stack.isEmpty()) {
                    stack.push(i);  // Push current index as base if no open brackets
                } else {
                    int length = i - stack.peek();  // Valid substring length
                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "(()())(()";
        int result = longestValidParentheses(s);
        System.out.println("Length of longest valid parentheses substring: " + result);
    }
}
