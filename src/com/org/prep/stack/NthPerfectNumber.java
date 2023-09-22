package com.org.prep.stack;
import java.util.*;

public class NthPerfectNumber {
    public static void main(String args[]) {
        solve(9);
    }


    public static String solve(int A) {

        Deque<String> q = new LinkedList<>();


        q.offer("11");
        q.offer("22");
        int count = 2;

        while (count < A) {
            String x = q.poll();

            String a = x.substring(0, x.length() / 2) + "11" + x.substring(x.length() / 2 , x.length() );
            String b = x.substring(0, x.length() / 2) + "22" + x.substring(x.length() / 2 , x.length());

            q.offer(a);
            count++;
            if (count == A) return a;
            q.offer(b);
            count++;
            if (count == A) return b;


        }

        return null;
    }
}
