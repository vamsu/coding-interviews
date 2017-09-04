package org.vamsu.interview.solutions.arrays;

import java.util.Arrays;

/**
 * Created by vamsu on 8/27/17.
 */
public class RepalceIndex01 {
    public static int replaceIndex(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return -1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > 0 && arr[i - 1] > 0)
                arr[i] = arr[i - 1] + 1;
        }
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            count = Math.max(count, arr[i]);
            if (arr[i] > 0) {
                arr[i] = count;
            } else {
                count = 0;
            }
        }
        int replaceIndex = -1;
        int maxSoFar = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                if (i == 0) {
                    if (maxSoFar < arr[i + 1] + 1) {
                        maxSoFar = arr[i + 1] + 1;
                        replaceIndex = i;
                    }
                } else if (i == arr.length - 1) {
                    if (maxSoFar < arr[i - 1] + 1) {
                        maxSoFar = arr[i - 1] + 1;
                        replaceIndex = i;
                    }
                } else if (arr[i - 1] > 0 && arr[i + 1] > 0 && maxSoFar < arr[i - 1] + arr[i + 1] + 1) {
                    maxSoFar = arr[i - 1] + arr[i + 1] + 1;
                    replaceIndex = i;
                }
            }
        }
        return replaceIndex;
    }

    public static int replaceIndex1(int[] arr) {
        int maxCount = 0;
        int maxIndex = -1;

        int prevZeroIndex = -1;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                count++;
            else {
                count = i - prevZeroIndex;
                prevZeroIndex = i;
            }
            if (count > maxCount) {
                maxCount = count;
                maxIndex = prevZeroIndex;
            }
        }

        return maxIndex;
    }

    public static int replaceSlidingWindow(int[] arr) {
        int left = 0;
        int count = 0;

        int max_count = 0;
        int max_index = -1;
        int prev_zero_index = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                prev_zero_index = i;
                count++;
            }

            if (count == 2) {
                while (arr[left] > 0) {
                    left++;
                }
                left++;
                count = 1;
            }

            if (i - left + 1 > max_count) {
                max_count = i - left + 1;
                max_index = prev_zero_index;
            }
        }

        return max_index;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0};
        System.out.println(replaceIndex(arr));
        int[] arr1 = {0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0};
        System.out.println(replaceIndex1(arr1));
        int[] arr2 = {0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0};
        System.out.println(replaceSlidingWindow(arr2));
    }
}
