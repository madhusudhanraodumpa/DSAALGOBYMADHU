package com.org.learnby.stack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class GameOfTwoStacks {
/*
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int noOfTestCases=sc.nextInt();

        for(int i=0;i<noOfTestCases;i++){
            int sizeofStack1=sc.nextInt();
            int sizeofStack2=sc.nextInt();
            int sum=sc.nextInt();
            Stack<Integer> st1=new Stack<>();
            Stack<Integer> st2=new Stack<>();
            while(sizeofStack1>0){
                st1.push(sc.nextInt());
                sizeofStack1--;
            }
            while(sizeofStack2>0){
                st2.push(sc.nextInt());
                sizeofStack2--;
            }
            int runningSum=0;
            int moves=0;
            boolean falg=true;
            while((!st1.isEmpty() && !st2.isEmpty()) && falg){
                if(runningSum+st1.peek()<sum){
                    runningSum=runningSum+ st1.pop();
                    moves++;
                    continue;
                }else if(runningSum+st2.peek()<sum){
                    runningSum=runningSum+ st2.pop();
                    moves++;
                    continue;
                }else{
                    falg=false;
                }

            }
        System.out.println(moves);

        }

    }*/


    /*
     * Complete the twoStacks function below.
     */
   /* static int twoStacks(int x, int[] a, int[] b) {
       long runningSum = 0;
        int moves = 0;
        boolean falg = true;
        long size1 = a.length - 1;
        long size2 = b.length - 1;
        int i = 0, j = 0;
        int flagtesting=0;
        while ((i <= size1 && j <= size2) && falg) {

            if ( a[i]<b[j]&& runningSum + a[i] <= x) {
                runningSum = runningSum + a[i];
                i++;
                moves++;
                flagtesting++;
                continue;
            } else if (a[i]>b[j] && runningSum + b[j] <= x) {
                runningSum = runningSum + b[j];
                j++;
                moves++;
                flagtesting++;
                continue;
            }else if (a[i]==b[j]){
                if(i+1<=size1 && j+1<=size2 && a[i+1]>b[j+1]&&runningSum + b[j] <= x) {
                    runningSum = runningSum + b[j];
                    j++;
                    moves++;
                    flagtesting++;
                    continue;
                }else if(i+1<=size1 && j+1<=size2 &&  a[i+1]<b[j+1]&& runningSum + a[i] <= x) {
                    runningSum = runningSum + a[i];
                    i++;
                    moves++;
                    flagtesting++;
                    continue;
                } else {
                    runningSum = runningSum + a[i];
                    i++;
                    moves++;
                    flagtesting++;
                    continue;
                }
            } else {
                falg = false;
            }

        }
        return moves;

    }*/

    static int twoStacks(int x, int[] a, int[] b) {
        int runningsum=0;
        int moves=0;
        int firstArrayIndex=-1;
        for(int i=0;i<a.length;i++){
            if(x>=runningsum+a[i]){
                runningsum=runningsum+a[i];
                moves++;
                firstArrayIndex++;
            }else{
                break;
            }
        }
        int firstArrayMoves=moves,ans=firstArrayMoves;
        for(int j=0;j<b.length;){
            if(x>=runningsum+b[j]){
                runningsum=runningsum+b[j];
                ans=Math.max(ans,firstArrayMoves+j+1);
                j++;
            }else{
                if(firstArrayIndex>=0) {
                    runningsum = runningsum - a[firstArrayIndex--];
                    firstArrayMoves--;
                }else{
                    break;
                }
            }
        }
        return ans;
    }

        private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] nmx = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmx[0].trim());

            int m = Integer.parseInt(nmx[1].trim());

            int x = Integer.parseInt(nmx[2].trim());

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];

            String[] bItems = scanner.nextLine().split(" ");

            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int result = twoStacks(x, a, b);
            System.out.println(result);
            // bufferedWriter.write(String.valueOf(result));
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();
    }
}
