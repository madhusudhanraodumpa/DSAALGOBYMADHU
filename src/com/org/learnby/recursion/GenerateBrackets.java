package com.org.learnby.recursion;

public class GenerateBrackets {
    public static void main(String args[]) {
        int n = 3;
        char[] out = new char[2 * n];
        printBrackets(out,n,0,0,0);
    }

    private static void printBrackets(char[] out, int n, int idx, int open, int close) {
        if(idx==2*n){
            System.out.println(out);
            return;
        }

        if(open<n){
            out[idx]='(';
            printBrackets(out,n,idx+1,open+1,close);
        }
        if(close<open){
            out[idx]=')';
            printBrackets(out,n,idx+1,open,close+1);
        }
        return;
    }

}
