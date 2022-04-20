package com.org.learnby.recursion;

public class TowerHanoiProblem {
    public static int count =0;
    public static void main(String args[]){
        move(17,'A','C','B');
        System.out.println(count);

    }

    private static void move(int n, char src, char dest, char helper) {
        count++;
        if(n==1) {
            System.out.println("Shift disk: "+n+" from "+src+" to "+dest);
            return;
        }
        move(n-1,src,helper,dest);
        System.out.println("Shift disk: "+n+" from "+src+" to "+dest);
        move(n-1,helper,dest,src);
    }
}
