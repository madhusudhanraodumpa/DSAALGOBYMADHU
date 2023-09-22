package com.org.coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Test {
    public static void main(String args[]) {



        HashMap<String, Integer> stocks = new LinkedHashMap<>(16, 0.75f, true);


        stocks.put("Apple", 123);

        stocks.put("BMW", 54);

        stocks.put("Google", 87);

        stocks.put("Microsoft", 232);

        stocks.put("Oracle", 76);
       // Arrays.binarySearch();


        stocks.get("Google");

        stocks.get("BMW");



        System.out.println(stocks);

    }
}
