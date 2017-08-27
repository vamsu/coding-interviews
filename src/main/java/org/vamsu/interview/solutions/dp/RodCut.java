package org.vamsu.interview.solutions.dp;

/**
 * Created by vamsu on 8/20/17.
 */
public class RodCut {

    static int maxRevenue(int[] prices, int n) {
        if (n == 0) {
            return 0;
        }
        int maxValue = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int cost = prices[i - 1] + maxRevenue(prices, n - i);
            maxValue = Math.max(cost, maxValue);
        }
        return maxValue;
    }

    static int maxRevenueDP(int[] prices, int n) {
        if (n == 0) {
            return 0;
        }
        int[] tracker = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                tracker[i] = Math.max(tracker[i], prices[j - 1] + tracker[i - j]);
            }
        }
        return tracker[n];
    }

    public static void main(String[] args) {
        int prices[] = {1, 5, 8, 9};
        System.out.println(maxRevenue(prices, 4));
        System.out.println(maxRevenueDP(prices, 4));
    }
}
