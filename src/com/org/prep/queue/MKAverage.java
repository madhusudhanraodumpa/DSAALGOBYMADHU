package com.org.prep.queue;
import java.util.*;
class MKAverage {
    int m;
    int k;
    Queue<Integer> q;
    TreeMap<Integer, Integer> map;
    int totalSum;

    public static void main(String[] args) {
        MKAverage obj = new MKAverage(3, 1);
        obj.addElement(3);        // current elements are [3]
        obj.addElement(1);        // current elements are [3,1]
        obj.calculateMKAverage(); // return -1, because m = 3 and only 2 elements exist.
        obj.addElement(10);       // current elements are [3,1,10]
        obj.calculateMKAverage(); // The last 3 elements are [3,1,10].
        // After removing smallest and largest 1 element the container will be [3].
        // The average of [3] equals 3/1 = 3, return 3
        obj.addElement(5);        // current elements are [3,1,10,5]
        obj.addElement(5);        // current elements are [3,1,10,5,5]
        obj.addElement(5);        // current elements are [3,1,10,5,5,5]
        obj.calculateMKAverage(); // The last 3 elements are [5,5,5].
        // After removing smallest and largest 1 element the container will be [5].
        // The average of [5] equals 5/1 = 5, return 5
    }
    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        q = new LinkedList<>();
        map = new TreeMap<>();
        totalSum = 0;
    }


    public void addElement(int num) {
        q.add(num);
        totalSum += num;
        map.put(num, map.getOrDefault(num, 0) + 1);

        if(q.size() > m) {
            int popped = q.poll();
            totalSum -= popped;
            map.put(popped, map.get(popped) - 1);
            if (map.get(popped) == 0) {
                map.remove(popped);
            }
        }
    }

    public int calculateMKAverage() {
        if (q.size() < m) {
            return -1;
        }

        int sum = totalSum;

        int toDelete = k;
        int currKey = map.firstKey();

        while (toDelete > 0) {
            int delete = Math.min(toDelete, map.get(currKey));
            sum -= currKey * delete;
            toDelete -= delete;

            if (map.higherKey(currKey) == null){
                break;
            }

            currKey = map.higherKey(currKey);
        }

        toDelete = k;
        currKey = map.lastKey();

        while (toDelete > 0) {
            int delete = Math.min(toDelete, map.get(currKey));
            sum -= currKey * delete;
            toDelete -= delete;

            if (map.lowerKey(currKey) == null){
                break;
            }

            currKey = map.lowerKey(currKey);
        }

        return sum / (m - 2 * k);
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */
