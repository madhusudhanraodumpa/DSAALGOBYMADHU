package com.org.learnby.dynamicprograming.subsequences;

public class IsSubSequence {
    public static void main(String args[]) {
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {

        int s_pointer = 0;
        for (int t_pointer = 0; t_pointer < t.length(); t_pointer++) {

            if (s.charAt(s_pointer) == t.charAt(t_pointer)) s_pointer++;

            if (s.length() == s_pointer) return true;

        }
        return false;

    }
}
