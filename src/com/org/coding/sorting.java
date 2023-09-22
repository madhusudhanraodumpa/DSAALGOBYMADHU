package com.org.coding;

import java.util.HashMap;
import java.util.*;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.stream.*;

public class sorting {
    public static void main(String args[]){
            String supportedLogsources = "NA-North America,EU-Europe,UK-United Kingdom,SG-Singapore,AE-United Arab Emirates,IN-India";
            Map<String,String> supportedLogsourcesMap= new HashMap<>();
            StringTokenizer tokenizer = new StringTokenizer(supportedLogsources, ",");
            while (tokenizer.hasMoreElements()) {
                String token[] = tokenizer.nextToken().split("-");
                supportedLogsourcesMap.put(token[0],token[1]);
            }

        Map<String, String> sortedMap =
                supportedLogsourcesMap.entrySet().stream()
                        .sorted(Entry.comparingByValue())
                        .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));


           System.out.println(supportedLogsourcesMap);
           System.out.println(sortedMap);
        //}
    }
}
