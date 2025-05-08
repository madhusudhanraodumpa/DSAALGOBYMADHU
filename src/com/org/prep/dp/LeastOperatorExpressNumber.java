package com.org.prep.dp;

import java.util.*;

public class LeastOperatorExpressNumber {
    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        System.out.println(leastOpsExpressTarget(3,19,map));
    }

    public static int leastOpsExpressTarget(int x,int target,Map<Integer,Integer> map) {
        if (target == 1)
            return x == 1 ? 0 : 1;
        if (map.containsKey(target))
            return map.get(target);
        int count=0;
        int product=x;
        while(target>product) {
            count=count+1;
            product=product*x;
        }
        if(product==target) return count;

        //greater the target value;

        int cand1=Integer.MAX_VALUE;
        if(product==target) {
            cand1=count;
        } else if (product-target<target) {
            cand1=leastOpsExpressTarget(x,(int)product-target,map)+1+count;
        }
        int cand2=Integer.MAX_VALUE;
        product=product/x;
        cand2=leastOpsExpressTarget(x,(int)target-product,map)+count;
        map.put(target, Math.min(cand1,cand2));
        return map.get(target);






    }

    static Map<Integer, Integer> memo = new HashMap<>();
    public static int leastOpsExpressTarget(int x, int target) {
        if (target == 1)
            return x == 1 ? 0 : 1;
        if (memo.containsKey(target))
            return memo.get(target);
        long product = x;
        int count = 0;
        while (product < target) {
            count++;
            product *= x;

        }

        // candidate1 : in the form : x*x*...*x - (......) = target
        int cand1 = Integer.MAX_VALUE;
        if (product == target)
            cand1 = count;
        else if (product - target < target)
            cand1 = count + leastOpsExpressTarget(x, (int)(product - target)) + 1;

        // candidate2 : in the form : x*x*...*x + (......) = target
        int cand2 = Integer.MAX_VALUE;
        product /= x;
        cand2 = leastOpsExpressTarget(x, (int)(target - product)) + (count == 0 ? 2 : count);
        int res = Math.min(cand1, cand2);
        memo.put(target, res);
        return res;
    }
}
