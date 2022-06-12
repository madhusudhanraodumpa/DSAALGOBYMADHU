package com.org.prep.array;

public class MinFlips {
    public static void main(String args[]){
        System.out.println(minFlips("10111"));
    }

    public static int minFlips(String target) {

        int n=target.length();
        int totalFlips=0;
        int currentFlip=0;
        for(int i=0;i<n;i++){

            if(currentFlip%2==0 && target.charAt(i)=='1'){
                totalFlips++;
                currentFlip++;
            }
            if(currentFlip%2==1 && target.charAt(i)=='0'){
                totalFlips++;
                currentFlip++;
            }


        }

        return totalFlips;
    }
}
