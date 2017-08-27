package org.vamsu.interview.solutions.dp;

/**
 * Created by vamsu on 8/23/17.
 */
public class HighwayBillboard {
    static int maxRevenue(int[] sites, int[] revenue, int distance, int restriction, int index) {
        if (distance == 0 || index >= sites.length) {
            return 0;
        }
        int rev = 0;
        if (distance >= sites[index]) {
            rev = Math.max(maxRevenue(sites, revenue, distance, restriction, index + 1),
                    revenue[index] + maxRevenue(sites, revenue, (distance + restriction) - sites[index], restriction, index + 1));
        }
        return rev;
    }

    public static void main(String[] args) {
        int[] sites = {6, 7, 12, 13, 14}; //Sorted
        int[] revenue = {5, 6, 5, 3, 1};
        int distance = 20;
        int restriction = 5;

        System.out.println(maxRevenue(sites, revenue, distance, restriction, 0));
    }
}
