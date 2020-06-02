package com.org.learnby.recursion;

import java.util.Scanner;

public class ReplacePIvalue {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        char a[]=new char[1000];
        for(int i=0;i<10;i++){
            a[i]=sc.next(".").charAt(0);
        }
        replacePI(a,0);
        System.out.println(a);
    }

    private static void replacePI(char[] a, int i) {

    if(a[i]=='\0' || a[i+1]=='\0'){
    return;
        }

        if(a[i]=='P' && a[i+1]=='i'){
            int j=i+2;
            while(a[j]!='\0' ){
                j++;
            }
            while(j>=i+2){
                a[j+2]=a[j];
                j--;
            }
            a[i]='3';
            a[i+1]='.';
            a[i+2]='1';
            a[i+3]='4';
            replacePI(a,i+4);



        }else {
            replacePI(a,i+1);
        }


    }
}
