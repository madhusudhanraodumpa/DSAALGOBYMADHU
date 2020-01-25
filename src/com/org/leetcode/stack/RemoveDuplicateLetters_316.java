package com.org.leetcode.stack;

import java.util.*;

public class RemoveDuplicateLetters_316 {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Stack<Character> st = new Stack<>();
        Set<Character> visted = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            if (visted.contains(s.charAt(i))) {
                continue;
            }

            while (!st.isEmpty() && st.peek() > s.charAt(i) && map.get(st.peek()) > 0) {
                Character c = st.pop();
                visted.remove(c);
            }
            st.push(s.charAt(i));
            visted.add(s.charAt(i));


        }
        StringBuilder builder = new StringBuilder();
        while (!st.isEmpty()) {
            builder.append(st.pop());
        }
        return builder.reverse().toString();
    }

    public static void main(String args[]) {
        RemoveDuplicateLetters_316 r = new RemoveDuplicateLetters_316();
        System.out.println(r.removeDuplicateLetters("bcabc"));
    }


}
