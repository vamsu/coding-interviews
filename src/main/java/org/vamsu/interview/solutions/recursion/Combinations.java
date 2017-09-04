package org.vamsu.interview.solutions.recursion;

import org.vamsu.interview.solutions.utils.PrintUtils;

import java.util.Arrays;

/**
 * Created by vamsu on 9/3/17.
 */
public class Combinations {

    public static void print(int n, int[] arr, int index) {
        if (index >= n) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = index + 1;
                print(n, arr, index + 1);
                arr[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[] arr = new int[n];
        print(n, arr, 0);
    }
}
