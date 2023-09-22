package com.org.prep.dp;

public class PerfectSqures {
    public static void main(String[] args){
            PerfectSqures p = new PerfectSqures();
            int n=20;
            int a= (int) Math.sqrt(n);
            if(a*a==n){
                System.out.println(true);
            }
           System.out.println(p.perfectSquares1(12));
    }
    public int perfectSquares(int n){
        if(n==0) return 0;

        int min=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            min=Math.min(min,perfectSquares(n-i*i));

        }
        return min!=Integer.MAX_VALUE?min+1:0;

    }

    public int perfectSquares1(int n){
        int x=n;
        int t=(int)Math.sqrt(n);
        if(t*t==n) return 1;

        while(x%4==0){
            x=x/4;
        }
        if(x%8==7) return 4;

        for(int i=1;i*i<=n;i++){

            int base=(int)Math.sqrt((n-(i*i)));

            if(base*base==(n-(i*i))){
                return 2;
            }
        }

        return 3;

    }
}
