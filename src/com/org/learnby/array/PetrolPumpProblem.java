package com.org.learnby.array;

public class PetrolPumpProblem {
    public static void main(String args[]){
        int[] pet={1,2,3,4,5};
        int[] dis={3,4,5,1,2};

        int sum=0,d=0;
        int start=1;
        for(int i=0;i<pet.length;i++){
            sum=sum+pet[i]-dis[i];
            if(sum<0){
                start=start+1;
                d=d+sum;
                sum=0;
            }
        }
        start=sum+d>=0?start:0;
        System.out.println(start);


    }
}
