package com.org.prep.bits;

public class SumBitWiseANDOfAllSubarrays {


    public static void main(String args[]){

        int a[]={7,1,1,5};
        System.out.println(bitWiseANDSum1(a));
        System.out.println(findAndSum(a,a.length));


    }

    public static int bitWiseANDSum1(int a[]){

        int n=a.length;

        int sum=0;



        for(int i=0;i<31;i++){
            int count=0;
            for(int j=0;j<n;j++){

                if(((a[j]>>i)&1)==1){
                    count++;
                }

            }

            count=count*(count+1)/2;
            sum=sum+count*(1<<i);


        }

        return sum;

    }

    public static int bitWiseANDSum(int a[]){

        int n=a.length;

        int sum=0;

        for (int i=0;i<n;i++){
            sum=sum+a[i];
        }

        for(int i=0;i<31;i++){
            int count=0;
            for(int j=0;j<n;j++){

                if(((a[j]>>i)&1)==1){
                    count++;
                }

            }
            if(count!=0 && count>=2){
                sum=sum+((count/2)*(1<<i));
            }
        }

        return sum;

    }

    static int findAndSum(int []arr, int n)
    {
        // variable to store
        // the final sum
        int sum = 0;

        // multiplier
        int mul = 1;

        for (int i = 0; i < 30; i++)
        {
            // variable to check if
            // counting is on
            boolean count_on = false;

            // variable to store the
            // length of the subarrays
            int l = 0;

            // loop to find the contiguous
            // segments
            for (int j = 0; j < n; j++)
            {
                if ((arr[j] & (1 << i)) > 0)
                    if (count_on)
                        l++;
                    else
                    {
                        count_on = true;
                        l++;
                    }

                else if (count_on)
                {
                    sum += ((mul * l * (l + 1)) / 2);
                    count_on = false;
                    l = 0;
                }
            }

            if (count_on)
            {
                sum += ((mul * l * (l + 1)) / 2);
                count_on = false;
                l = 0;
            }

            // updating the multiplier
            mul *= 2;
        }

        // returning the sum
        return sum;
    }
}
