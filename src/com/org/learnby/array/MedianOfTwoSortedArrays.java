package com.org.learnby.array;

public class MedianOfTwoSortedArrays {
    public static void main(String args[]){
        int a[]={1,12,15,26,38};
        int b[]={2,13,17,30,45};
        System.out.println(findMedian(a,b));
    }
    public static double findMedian(int input1[],int input2[]){
       //return findMedianUtil(a,b,0,a.length-1,0,b.length-1);
        //if input1 length is greater than switch them so that input1 is smaller than input2.
        if (input1.length > input2.length) {
            return findMedian(input2, input1);
        }
        int x = input1.length;
        int y = input2.length;

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : input1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : input1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : input2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : input2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }

        }
        return -1;
    }
    public static double findMedianUtil(int a[],int b[],int start_a,int end_a,int start_b,int end_b){
        if(end_a-start_a==1 && end_b-start_b==1){
            return (1.0*(Math.max(start_a,start_b)+Math.min(end_a,end_b)))/2;
        }
        int m1_index=(start_a+end_a)/2;
        int m2_index=(start_b+end_b)/2;

        int m1=a[m1_index];
        int m2=b[m2_index];
        if(m1==m2) return m1;
        if(m1<m2){
            start_a=m1_index;
            end_b=m2_index;
        }else {
            start_b=m2_index;
            end_a=m1_index;
        }
        return findMedianUtil(a,b,start_a,end_a,start_b,end_b);

    }
}
