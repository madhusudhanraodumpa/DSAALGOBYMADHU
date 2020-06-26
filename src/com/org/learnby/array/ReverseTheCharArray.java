package com.org.learnby.array;

public class ReverseTheCharArray {
    public static void main(String args[]) {

        String s = "I LOVE INDIA";
        char ch[] = s.toCharArray();
        int l = 0;
        int r = ch.length - 1;
        while (l < r) {
            swap(ch, l, r);
            l++;
            r--;
        }
        l = 0;
        r = 0;
        while (l < ch.length - 1) {

            if (ch[r] == ' ') {
                int k = r - 1;
                while (l < k) {
                    swap(ch, l, k);
                    l++;
                    k--;
                }
                l = r + 1;
            }
            r++;
        }
        System.out.println(new String(ch));

    }

    private static void swap(char[] ch, int l, int r) {
        char tmp = ch[l];
        ch[l] = ch[r];
        ch[r] = tmp;
    }

}
