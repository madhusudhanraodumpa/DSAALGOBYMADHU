package com.org.prep.array;

public class MaxSumSubmatrix {

    public static void main(String[] args){
        int[][] matrix = { {2,2,-1}};

       // calculatePrefixSumMatrix(matrix);


        int[][] a=calculateColumnPrefixSumMatrix(matrix);

        System.out.println(maxSumSubMatrix(a,3));
    }



    public static int maxSumSubMatrix1(int[][] a){
        int n=a.length;
        int m=a[0].length;
        int maxSum=Integer.MIN_VALUE;

        for(int a1=0;a1<n;a1++){
            for(int b1=0;b1<m;b1++){
                //TL is fixed. a1 and b1.

                for(int a2=a1;a2<n;a2++){
                    for(int b2=b1;b2<m;b2++){
                        //BR is fixed. a2 and b2.
                        int sum=a[a2][b2];

                        if(b1!=0){
                            sum=sum-a[a2][b1-1];
                        }
                        if(a1!=0){
                            sum=sum-a[a1-1][b2];
                        }
                        if(a1!=0 && b1!=0){
                            sum=sum+a[a1-1][b1-1];
                        }
                        if(maxSum<sum){
                            maxSum=sum;
                            System.out.println(a1+" "+b1+" "+a2+" "+b2);
                        }
                       // maxSum=Math.max(maxSum,sum);

                    }
                }

            }
        }

        return maxSum;
    }


    public static int[][] calculateColumnPrefixSumMatrix(int[][] a){
        int n=a.length;
        int m=a[0].length;
        int[][] x=new int[n][m];

        /*for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<m;j++){
                sum=sum+a[i][j];
                a[i][j]=sum;
            }
        }*/

        for(int j=0;j<m;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                sum=sum+a[i][j];
                x[i][j]=sum;
            }
        }

        return x;


    }

    public static void calculatePrefixSumMatrix(int[][] a){
        int n=a.length;
        int m=a[0].length;

        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<m;j++){
                sum=sum+a[i][j];
                a[i][j]=sum;
            }
        }

        for(int j=0;j<m;j++){
            int sum=0;
            for(int i=0;i<n;i++){
                sum=sum+a[i][j];
                a[i][j]=sum;
            }
        }




    }

    //using kadans 2D algo.int m
    public static int maxSum(int a[]){

        int n=a.length;

        int sum=0;
        int maxSum=Integer.MIN_VALUE;

        for (int i=0;i<n;i++){
            sum=sum+a[i];
            maxSum=Math.max(sum,maxSum);
            if(sum<0){
                sum=0;
            }
        }
        return maxSum;

    }
    static int findMaxSubarraySum(int arr[],
                                  int n, int sum)
    {
        // To store current sum and
        // max sum of subarrays
        int curr_sum = arr[0], max_sum = 0, start = 0;

        // To find max_sum less than sum
        for (int i = 1; i < n; i++) {

            // Update max_sum if it becomes
            // greater than curr_sum
            if (curr_sum <= sum)
                max_sum = Math.max(max_sum, curr_sum);

            // If curr_sum becomes greater than
            // sum subtract starting elements of array
            while (curr_sum + arr[i] > sum && start < i) {
                curr_sum -= arr[start];
                start++;
            }

            // Add elements to curr_sum
            curr_sum += arr[i];
        }

        // Adding an extra check for last subarray
        if (curr_sum <= sum)
            max_sum = Math.max(max_sum, curr_sum);

        return max_sum;
    }
    public static int maxSumSubMatrix(int[][] a,int val){


        int n=a.length;
        int m=a[0].length;
        int maxSum=Integer.MIN_VALUE;
        for(int rowStart=0;rowStart<n;rowStart++){
            for (int rowEnd=rowStart;rowEnd<n;rowEnd++){

                    int x[]=new int[m];
                    if(rowStart==0){
                        x=a[rowEnd];
                    }else{
                        for(int k=0;k<m;k++){
                           x[k]= a[rowEnd][k]-a[rowStart-1][k];
                        }
                    }
                int sum=findMaxSubarraySum(x,m,val);

                if(sum>maxSum && val>=sum){
                    maxSum=sum;
                }

            }
        }
    return maxSum;
    }


}
