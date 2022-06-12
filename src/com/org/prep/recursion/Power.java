package com.org.prep.recursion;

public class Power {

    public static void main(String args[]){

        System.out.println(pow(-1,1,20));
    }

    public static  int pow(int A, int B, int C) {

        if(A==0) return 0;

        if(B==0) return 1;
        if (A<0){
            A=(C+A)%C;
        }

        long he=pow(A,B/2,C);
        long ha= (he%C*he%C)%C;

        if(B%2==0){
            return (int)ha;
        }else{

            return (int)(ha%C*A%C)%C;
        }




    }
}
