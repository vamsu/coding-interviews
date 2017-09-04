package org.vamsu.interview.solutions.arrays;

/**
 * Created by vamsu on 8/27/17.
 */
public class Majority {
    public static int findMajority(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        int majority = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (majority == arr[i]) {
                count++;
            } else {
                if (count == 0) majority = arr[i];
                count--;
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 3, 4, 2, 1, 1};
        System.out.println("Find Majority: " + findMajority(arr));
    }
}
