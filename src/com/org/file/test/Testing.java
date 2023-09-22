package com.org.file.test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Testing {
public static void main(String args[]){

    List<String> list = Arrays.asList("MAdhu","raju","pramod");
    try {
        //FileOutputStream writeData = new FileOutputStream("C://Test//LinkProTenants.txt");
        File file = new File("C://Test//LinkProTenants.txt");
        file.getParentFile().mkdirs();

      /*  try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(list);
            oos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

    } catch (Exception e){
        e.printStackTrace();
    }

        List<String> result = null;
    File file = new File("C://Test//LinkProTenants.txt");
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (List<String>) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    for(String s : result) {
            System.out.println(s);
        }
    }

}

