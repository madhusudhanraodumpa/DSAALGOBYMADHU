package com.org.prep.recursion;

import java.util.ArrayList;

public class GrayCode {

    public static void main(String args[]){
        ArrayList<Integer> list=grayCode(3);
        System.out.println();
    }

    public static ArrayList<Integer> grayCode(int a) {

        if(a==1){
            ArrayList<Integer> baseList=new ArrayList<>();
            baseList.add(0);
            baseList.add(1);
            return baseList;
        }


        ArrayList<Integer> list= grayCode(a-1);


        ArrayList<Integer> myList=new ArrayList<>();

        for(int i=0;i<list.size();i++){
            myList.add(list.get(i));
        }
        for(int i=list.size()-1;i>=0;i--){
            myList.add(list.get(i)+(int)Math.pow(2,a-1));
        }
        return myList;
    }
}
