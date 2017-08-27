package org.vamsu.interview.solutions.dp;

/**
 * Created by vamsu on 8/20/17.
 */
public class SubsetSum {

    public static boolean exists(int[] arr, int sum) {
        return exists(arr, sum, 0);
    }

    public static boolean exists(int[] arr, int sum, int index) {
        if (sum < 0 || index >= arr.length) {
            return false;
        }
        if (sum == 0) {
            return true;
        }
        boolean include = exists(arr, sum - arr[index], index + 1);
        boolean exclude = exists(arr, sum, index + 1);

        return include || exclude;
    }

    public static boolean existsDP(int[] arr, int sum) {
        if (sum < 0) {
            return false;
        }
        boolean tracker[][] = new boolean[arr.length + 1][sum + 1];
        // When arr size is 0
        for (int c = 1; c <= sum; c++) {
            tracker[0][c] = false;
        }
        // When sum is 0
        for (int r = 0; r < arr.length; r++) {
            tracker[r][0] = true;
        }

        for (int r = 1; r <= arr.length; r++) {
            for (int c = 1; c <= sum; c++) {
                if (arr[r - 1] > c) {
                    tracker[r][c] = tracker[r - 1][c];
                } else {
                    tracker[r][c] = tracker[r - 1][c] || tracker[r - 1][c - arr[r - 1]];
                }
            }
        }

        return tracker[arr.length][sum];

    }


    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 5, 10, 3};
        System.out.println(exists(arr, 17));
        System.out.println(existsDP(arr, 17));

    }
}
