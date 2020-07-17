package com.org.learnby.dynamicprograming.subsequences;

import com.sun.deploy.util.SyncAccess;

public class StringSubsequences {
    public static void main(String args[]){
        String a[]=findSubsequences("xyz");

        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
        int[] b={1,2,3,4};
        int count=0;
        String s="";
        for(int i=0;i<b.length;i++){
            s+=b[i];
        }
        String c[]=findSubsequences(s);
        for(int i=0;i<c.length;i++){
            System.out.println(c[i]);
            count++;
        }
        System.out.println(count);
    }
    public static String[] findSubsequences(String str){
        if(str.length()==0){
            String ans[]={""};
            return ans;
        }

        String smallAns[]=findSubsequences(str.substring(1));
        String ans[]=new String[2*smallAns.length];

        int k=0;
        for(int i=0;i<smallAns.length;i++){
            ans[k]=smallAns[i];
            k++;
        }
        for(int i=0;i<smallAns.length;i++){
            ans[k]=str.charAt(0)+smallAns[i];
            k++;
        }

    return ans;
    }

    public static int[] findIntegerSubsequences(int[] a,int start,int end){
        if(start>end){
            int[] ans={0};
            return ans;
        }

        int smallAns[]=findIntegerSubsequences(a,start+1,end);
        int ans[]=new int[2*smallAns.length];

        int k=0;
        for(int i=0;i<smallAns.length;i++){
            System.out.println(smallAns[i]);
            k++;
        }
        for(int i=0;i<smallAns.length;i++){
            System.out.println(a[0]+" "+smallAns[i]);
            k++;
        }

        return ans;
    }
}
