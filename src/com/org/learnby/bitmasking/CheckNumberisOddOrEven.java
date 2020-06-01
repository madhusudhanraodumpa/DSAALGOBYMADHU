package com.org.learnby.bitmasking;

public class CheckNumberisOddOrEven {
    public static void main(String args[]){
        System.out.println("Number is odd "+isOdd(4));
        System.out.println("Get the ith bit is = "+getBit(8,2));
        System.out.println("Set the ith bit is ="+setBit(5,1));
        System.out.println("Clear the ith bit is ="+clearBit(7,2));
        System.out.println("Update the ith bit is ="+updateBit(5,1,1));
        System.out.println("Clear all the ith bit is ="+clearIthBit(7,2));
        System.out.println(clearRangeBiTHtojTH(31,1,3));
        System.out.println(replaceMbitsByN(15,2,1,3));



    }

    private static int replaceMbitsByN(int n, int m, int i, int j) {
        int clear_bits=clearRangeBiTHtojTH(n,i,j);
        int b=m<<i;
        return  clear_bits | b;
    }

    private static int clearRangeBiTHtojTH(int n, int i, int j) {
        int a=(-1) <<j+1;
        int b=(1<<i)-1;
        int mask= a | b;
        int ans= n & mask;
        return ans;
    }

    private static int clearIthBit(int n, int i){
        int mask=(-1<<i);
        return (n & mask);
    }
    private static int updateBit(int n, int i,int v){
        int mask=~(1<<i);
        int cleabr_bit= n & mask;
        return cleabr_bit | (v<<i);
    }

    private static int clearBit(int n, int i){
        int mask=~(1<<i);
        return n & mask;
    }
    private static int getBit(int n, int i) {
        int mask= (1<<i);
        return (n & mask)>0 ? 1: 0;
    }

    private static int setBit(int n, int i){
        int mask= (1<<i);
        return n|mask;
    }

    public static boolean isOdd(int i){
        return (i&1) == 0 ? false:true ;
    }
}
