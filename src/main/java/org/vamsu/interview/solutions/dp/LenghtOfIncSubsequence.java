package org.vamsu.interview.solutions.dp;

/**
 * Created by vamsu on 8/20/17.
 */
public class LenghtOfIncSubsequence {

    public static int lis(int[] arr) {
        return lis(arr, 0, arr.length, Integer.MIN_VALUE);
    }

    public static int lis(int[] arr, int i, int n, int prev) {
        if (i == n) return 0;
        int exclude = lis(arr, i + 1, n, prev);
        int include = 0;
        if (arr[i] > prev) {
            include = 1 + lis(arr, i + 1, n, arr[i]);
        }
        return Math.max(exclude, include);
    }

    public static int lisDP(int[] arr) {
        int[] lis = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, 1 + lis[j]);
                }
            }
            lis[i] = Math.max(1, max);
        }
        int max = lis[0];
        for (int i = 1; i < lis.length; i++) {
            max = Math.max(lis[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 12, 7, 0, 23, 11, 52, 31, 61, 69, 70, 2};
        System.out.println(lis(arr));
        System.out.println(lisDP(arr));
    }
}
