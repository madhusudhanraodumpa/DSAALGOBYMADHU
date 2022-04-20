package com.org.prep.recursion;

public class PrintAllSubsets {
    public static void main(String args[]){

        String input="abc";
        String output="";
        printAllSubsets(input,output);
    }
    public static void printAllSubsets(String input,String output){

        if(input.equalsIgnoreCase("") || input.length()==0){
            System.out.println(output+" ");
            return;
        }

        String output1=output;
        String output2=output+input.substring(0,1);
        input = input.substring(1,input.length());
        printAllSubsets(input,output1);
        printAllSubsets(input,output2);
        return;



    }
}
