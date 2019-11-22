package com.org.learnby.bitmasking;

public class LuckyNumber {

    public static void main(String args[]){

        System.out.println("Lucky Number is "+(luckyNumber(47)+1));


    }

    private static int luckyNumber(int number){
        int ans=0;
        int len=String.valueOf(number).length();
        ans=(1<<len)-2;
        int pos=-1;
        while(number>0){
            pos++;
            int val=number%10;
            if(val==7){
                ans+=1<<pos;
            }
            number=number/10;

        }



        return ans;


    }
}
