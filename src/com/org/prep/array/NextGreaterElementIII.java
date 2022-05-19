package com.org.prep.array;

public class NextGreaterElementIII {

    public static void main(String rags[]){
            System.out.println(nextGreaterElement(65145632));
    }

    public static int nextGreaterElement(int n) {
        String str=n+"";
        char[] ch=str.toCharArray();
        int i=ch.length-2;
        while (i!=-1 && ch[i]>=ch[i+1]){
            i--;
        }
        if(i==-1) return -1;

        //swap the element

        int k=ch.length-1;
        while (ch[i]>=ch[k]){
            k--;
        }
        char temp=ch[k];
        ch[k]=ch[i];
        ch[i]=temp;

        String res="";
        for(int j=0;j<=i;j++){
            res+=ch[j];
        }
        for(int j=ch.length-1;j>i;j--){
            res+=ch[j];
        }
        return Integer.parseInt(res);
    }
}
