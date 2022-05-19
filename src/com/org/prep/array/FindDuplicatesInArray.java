package com.org.prep.array;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicatesInArray {
public static void main(String args[]){
    int a[]={4,3,2,7,8,2,3,1};
    findDuplicates(a);
}


    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++) {
            int pos = Math.abs(nums[i]);
            if(nums[pos] < 0) {
                result.add(Math.abs(nums[i]));
            } else {
                nums[pos] *= -1;
            }
        }
        return result;
    }
}
