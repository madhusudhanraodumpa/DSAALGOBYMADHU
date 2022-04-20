package com.org.prep.recursion;

public class PrintNBinary {
    public static void main(String args[]){

        printNBinarys(5,0,0,"");
    }
    public static void printNBinarys(int n,int zeros,int ones,String output){
        if(n==0){
            System.out.println(output);
            return;
        }

        String output1= output+"1";
        printNBinarys(n-1,zeros,ones+1,output1);
        if(zeros<ones){
            String output2= output+"0";
            printNBinarys(n-1,zeros+1,ones,output2);
        }

    }
}
