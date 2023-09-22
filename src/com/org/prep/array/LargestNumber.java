package com.org.prep.array;

import sun.security.util.ArrayUtil;

import java.util.*;

public class LargestNumber {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(3, 30, 34, 5, 9));
        System.out.println(largestNumber(list));
        largestNumber1(list);
    }


    public static String largestNumber(final List<Integer> A) {


        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int rem1 = a % 10;
                int rem2 = b % 10;
                if (rem1 > rem2) return 1;
                else return -1;
            }
        });
        StringBuilder sb = new StringBuilder();

        for (Integer i : A) {
            sb.append(i.intValue() + "");
        }

        return sb.toString();

    }


    // DO NOT MODIFY THE LIST .  IT IS READ ONLY

    public static String largestNumber1(final List<Integer> A) {

        Collections.sort(A, new Comparator<Integer>() {

            @Override

            public int compare(Integer a, Integer b) {

                String first = String.valueOf(a) + String.valueOf(b);

                String second = String.valueOf(b) + String.valueOf(a);

                return first.compareTo(second);

            }

        });

        StringBuilder sb = new StringBuilder();

        for (Integer i : A) {

            sb.append(i.intValue() + "");

        }

        if (A.get(0) == 0)

            return "0";

        return sb.toString();

    }
}

