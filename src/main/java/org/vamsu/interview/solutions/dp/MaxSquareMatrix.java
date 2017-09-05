package org.vamsu.interview.solutions.dp;

import org.vamsu.interview.solutions.utils.PrintUtils;

import java.util.Arrays;

/**
 * Created by vamsu on 8/20/17.
 */
public class MaxSquareMatrix {

    public static int maxSquareMatrix(int[][] arr) {
        int[][] tracker = new int[arr.length][arr[0].length];

        for (int r = 0; r < arr.length; r++) {
            tracker[r][0] = arr[r][0];
        }
        for (int c = 0; c < arr[0].length; c++) {
            tracker[0][c] = arr[0][c];
        }
        int maxSoFar = 0;
        for (int r = 1; r < arr.length; r++) {
            for (int c = 1; c < arr[0].length; c++) {
                if (arr[r][c] == 1) {
                    tracker[r][c] = 1 + Math.min(tracker[r - 1][c - 1],
                            Math.min(tracker[r - 1][c], tracker[r][c - 1]));
                    maxSoFar = Math.max(maxSoFar, tracker[r][c]);
                } else {
                    tracker[r][c] = 0;
                }
            }
        }
        PrintUtils.prettyPrint("Tracker", tracker);
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0},
                {0, 1, 1, 1, 1, 0},
                {0, 0, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1}};
        System.out.println(maxSquareMatrix(arr));

    }
}
