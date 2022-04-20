package com.org.prep.recursion;

public class Permutationwithspaces {

    public static void main(String args[]){

        String input="abc";
        String output="";
        printPermutatiomWithSpaces(input.substring(1,input.length()),input.substring(0,1));
    }

    public static void printPermutatiomWithSpaces(String input,String output){

        if(input.equalsIgnoreCase("") || input.length()==0){
            System.out.println(output+" ");
            return;
        }

        String output1=output+"-"+input.substring(0,1);
        String output2=output+input.substring(0,1);
        input = input.substring(1,input.length());
        printPermutatiomWithSpaces(input,output1);
        printPermutatiomWithSpaces(input,output2);
        return;



    }
}
