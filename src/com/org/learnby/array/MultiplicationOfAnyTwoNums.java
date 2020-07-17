package com.org.learnby.array;

public class MultiplicationOfAnyTwoNums {
    public static void main(String rags[]){

    }
    public static int getMaxProduct(int []a){
        if(a.length==0 || a.length==1) return -1;
        if(a.length==1) return a[0]*a[1];
        int firstMax=a[0]>a[1]?a[0]:a[1];
        int secondMax= a[0]>a[1]?a[1]:a[0];
        int firstMin= a[0]>a[1]?a[1]:a[0];
        int secondMin= a[0]>a[1]?a[0]:a[1];

        for(int i=0;i<a.length;i++){
            if(a[i]<firstMin){
                secondMin=firstMin;
                firstMin=a[i];
            }else if(a[i]<secondMin){
                secondMin=a[i];
            }
            if(a[i]>firstMax){
                secondMax=firstMax;
                firstMax=a[i];
            }else if(a[i]>secondMax){
                secondMax=a[i];
            }
        }
        return Math.max(firstMax*secondMax,firstMin*secondMin);

    }
}
