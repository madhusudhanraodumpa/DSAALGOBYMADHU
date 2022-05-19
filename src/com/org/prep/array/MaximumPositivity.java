package com.org.prep.array;

import java.util.ArrayList;
import java.util.List;

public class MaximumPositivity {
    public static void main(String args[]){
          int[] a={7251357, -6249230, -3917080, 5577664, 3417609, -2534660, 4723211, 3827311, 3854309, -6641510};

        solve(a);
    }


    public static int[] solve(int[] A) {

            int maxOnes=Integer.MIN_VALUE;
            int n=A.length;

            int count=0;
            for(int i=0;i<n;i++){
                if(A[i]>0){
                    count=count+1;
                }
            }
            if(n==count) return A;

            int startIndex=0;
            int endIndex=0;
            int len=Integer.MIN_VALUE;

            for(int i=0;i<n;i++){
                if(A[i]<0){

                    int l=0;
                    int j=0;
                    for(j=i-1;j>=0;j--){

                        if(A[j]>0){
                            l++;
                        }else{
                            break;
                        }

                    }

                    int r=0;
                    int k=0;
                    for(k=i+1;k<n;k++){
                        if(A[k]>0){
                            r++;
                        }else{
                            break;
                        }

                    }

                    if(l>r){

                        if(len<i-1-j-1+1){
                            startIndex=j+1;
                            endIndex=i-1;
                            len=endIndex-startIndex+1;
                        }else if (len==i-1-j-1+1){

                            if(j+1<startIndex){
                                startIndex=j+1;
                                endIndex=i-1;
                            }
                        }
                    }
                    else if (r>l){

                        if(len<k-1-i-1+1){
                            startIndex=i+1;
                            endIndex=k-1;
                            len=endIndex-startIndex+1;
                        }else if(len==k-1-i-1+1){
                            if(i+1<startIndex){
                                startIndex=i+1;
                                endIndex=k-1;
                            }
                        }
                    }else if(l!=0 && l==r){
                        if(i+1<startIndex){
                            startIndex=i+1;
                            endIndex=k-1;
                        }
                        len=endIndex-startIndex+1;
                    }


                }



            }


            //  return maxOnes;


            List<Integer> list=new ArrayList<>();
            for(int k=startIndex;k<=endIndex;k++){
                list.add(A[k]);
            }

            return list.stream().mapToInt(x->x).toArray();

        }
    }

