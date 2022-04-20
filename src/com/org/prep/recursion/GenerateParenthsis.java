package com.org.prep.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthsis {
    public static void main(String args[]){
        int n=2;
        int  open =n;
        int close =n;
        String output="";
        List<String> list= new ArrayList<>();
        generateParenthsis(open,close,output,list);
        for(String s:list){
            System.out.println(s+" ");
        }
    }
    public static void generateParenthsis(int open,int close,String output,List<String> list){
        if(open==0 && close==0 ){
            list.add(output);
            return;
        }

        if(open!=0){

            String output1= output+"(";
            generateParenthsis(open-1,close,output1,list);
        }
        if(open<close){
            String output2 = output+")";
            generateParenthsis(open,close-1,output2,list);
        }



    }
}
