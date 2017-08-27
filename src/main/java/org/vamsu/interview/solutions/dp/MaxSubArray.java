package org.vamsu.interview.solutions.dp;

import java.util.Arrays;

/**
 * Created by vamsu on 8/22/17.
 */
public class MaxSubArray {

    static int solve(int[] a) {
        int[] solution = new int[a.length + 1];
        solution[0] = 0;

        for (int j = 1; j < solution.length; j++) {
            solution[j] = Math.max(solution[j - 1] + a[j - 1], a[j - 1]);
        }
        int result = solution[0];
        for (int j = 1; j < solution.length; j++) {
            result = Math.max(result, solution[j]);
        }

        System.out.println(Arrays.toString(solution));
        return result;
    }

    public static void main(String[] args) {
        int arrA[] = {1, 2, -3, -4, 2, 7, -2, 3, -1, -10};
        System.out.println(solve(arrA));
    }
}
