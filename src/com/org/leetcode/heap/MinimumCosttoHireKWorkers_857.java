package com.org.leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;


//This solution i have not resolved due to i have not understand this problem.Later i have to re vesit this problem and solve it.

public class MinimumCosttoHireKWorkers_857 {
        public static void main(String args[]){
            MinimumCosttoHireKWorkers_857 m=new MinimumCosttoHireKWorkers_857();

            int[] quality = {3,1,10,10,1};
            int[] wage ={4,8,2,2,7};
            int K = 3;
            System.out.print(m.mincostToHireWorkers(quality,wage,3));
        }

        public double mincostToHireWorkers(int[] quality, int[] wage, int K) {

            int N = quality.length;
            double ans = 1e9;

            for (int captain = 0; captain < N; ++captain) {
                // Must pay at least wage[captain] / quality[captain] per qual
                double factor = (double) wage[captain] / quality[captain];
                double prices[] = new double[N];
                int t = 0;
                for (int worker = 0; worker < N; ++worker) {
                    double price = factor * quality[worker];
                    if (price < wage[worker]) continue;
                    prices[t++] = price;
                }

                if (t < K) continue;
                Arrays.sort(prices, 0, t);
                double cand = 0;
                for (int i = 0; i < K; ++i)
                    cand += prices[i];
                ans = Math.min(ans, cand);
            }

            return ans;
        }

    public double mincostToHireWorkers1(int[] quality, int[] wage, int K) {

        int N = quality.length;
        Worker[] workers = new Worker[N];
        for (int i = 0; i < N; ++i)
            workers[i] = new Worker(quality[i], wage[i]);
        Arrays.sort(workers);

        double ans = 1e9;
        int sumq = 0;
        PriorityQueue<Integer> pool = new PriorityQueue();
        for (Worker worker: workers) {
            pool.offer(-worker.quality);
            sumq += worker.quality;
            if (pool.size() > K)
                sumq += pool.poll();
            if (pool.size() == K)
                ans = Math.min(ans, sumq * worker.ratio());
        }

        return ans;
    }

}
class Worker implements Comparable<Worker> {
    public int quality, wage;
    public Worker(int q, int w) {
        quality = q;
        wage = w;
    }

    public double ratio() {
        return (double) wage / quality;
    }

    public int compareTo(Worker other) {
        return Double.compare(ratio(), other.ratio());
    }
}
