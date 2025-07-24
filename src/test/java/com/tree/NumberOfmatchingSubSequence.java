package com.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NumberOfmatchingSubSequence {

        public int numMatchingSubseq(String S, String[] words) {
            Map<Character, Queue<String>> map = new HashMap<>();
            int ans = 0;

            for(int i = 0; i < S.length(); i++) {
                map.put(S.charAt(i), new LinkedList<>());
            }

            for(String word : words) {
                char startChar = word.charAt(0);
                if(map.containsKey(startChar)) {
                    map.get(startChar).offer(word);
                }
            }
            for(int i = 0; i < S.length(); i++) {
                char startChar = S.charAt(i);
                Queue<String> q = map.get(startChar);
                int size = q.size();
                for(int k = 0; k < size; k++) {
                    String str = q.poll();
                    if(str.substring(1).length() == 0) {
                        ans++;
                    } else {
                        if(map.containsKey(str.charAt(1))) {
                            map.get(str.charAt(1)).offer(str.substring(1));
                        }
                    }
                }
            }
            return ans;
        }

    public static void main(String[] args) {
        NumberOfmatchingSubSequence solution = new NumberOfmatchingSubSequence();
//        String s = "abcde";
//        String[] words = {"a", "bb", "acd", "ace"};
//        String s = "abcabcabc";
//        String[] words = {"abc", "aabbcc", "acb", "cba", "aaa", "bca"};
        String s = "dsahjpjauf";
        String[] words = {"ahjpjau", "ja", "ahbwzgqnuk", "dsnkl"};
//        String s = "aaaaa";
//        String[] words = {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa"};
//        String s = "xyz";
//        String[] words = {"xy", "xz", "yz", "xyz", "x", "y", "z", "zx"};
        System.out.println(solution.numMatchingSubseq(s, words));  // Out
    }

}
