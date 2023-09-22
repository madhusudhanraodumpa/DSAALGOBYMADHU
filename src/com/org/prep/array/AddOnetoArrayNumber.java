package com.org.prep.array;
import java.util.*;

public class AddOnetoArrayNumber {
    public static void main(String args[]){
        Integer digit[]={9};
        plusOne1(Arrays.asList(digit));
    }


    public static List<Integer> plusOne1(List<Integer> A) {
        ArrayList<Integer> list=new ArrayList<>();

        int n=A.size();

        if(n==1){
            A.set(0,A.get(0)+1);
            return A;
        }

        for(int i=0;i<n;i++){
            if(A.get(i)==0 && list.size()==0){
                continue;
            }else{
                list.add(A.get(i));
            }
        }

        int m=list.size();

        for(int i=m-1;i>=0;i--){
            if(list.get(i)==9){
                list.set(i,0);
            }else{
                list.set(i,list.get(i)+1);
                return list;
            }
        }


        list=new ArrayList<Integer>(Collections.nCopies(m+1, 0));
        list.set(0,1);
        return list;


    }


    public  static int[] plusOne(int[] A) {

        int n=A.length;
        int[] B=new int[n-1];
        if(n==1){
            A[0]=A[0]+1;
            return A;
        }
        //  int[] digit=new int[n];
        if(A[0]==0){

            for(int i=1;i<n;i++){
                B[i-1]=A[i];
            }



        }else{
            B=new int[n];
            for(int i=0;i<n;i++){
                B[i]=A[i];
            }
        }
        n=B.length;

        for(int i=n-1;i>=0;i--){


            if(B[i]==9){
                B[i]=0;
            }
            else{

                B[i]=B[i]+1;
                return B;
            }
        }
        A=new int[n+1];
        A[0]=1;
        return A;
    }

}
