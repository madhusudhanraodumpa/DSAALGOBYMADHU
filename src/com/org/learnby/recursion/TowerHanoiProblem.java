package com.org.learnby.recursion;

public class TowerHanoiProblem {
    public static void main(String args[]){
        move(3,'A','C','B');
    }

    private static void move(int n, char src, char dest, char helper) {
        if(n==0) return;
        move(n-1,src,helper,dest);
        System.out.println("Shift disk: "+n+" from "+src+" to "+dest);
        move(n-1,helper,src,dest);
    }
}
