package org.vamsu.interview.solutions.arrays;

import java.util.*;

/**
 * Created by vamsu on 8/27/17.
 */
public class SubArraySum {
    public static int[] subArraySum(int[] arr, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        int currentSum = 0, i = 0;
        map.put(currentSum, i);
        for (i = 1; i <= arr.length; i++) {
            currentSum += arr[i - 1];
            int lookup = currentSum - sum;
            Integer index = map.get(lookup);
            if (index == null) {
                map.put(currentSum, i);
            } else {
                return Arrays.copyOfRange(arr, index, i);
            }
        }
        return null;
    }

    public static void printAllSubArraySum(int[] arr, int sum) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int currentSum = 0;
        Set<Integer> initial = new HashSet<>();
        initial.add(0);
        map.put(0, initial);
        for (int i = 1; i <= arr.length; i++) {
            currentSum += arr[i - 1];
            int lookup = currentSum - sum;
            Set<Integer> indexes = map.get(lookup);
            if (indexes == null) {
                indexes = new HashSet<>();
                indexes.add(i);
                map.put(currentSum, indexes);
            } else {
                for (Integer index : indexes) {
                    System.out.println(Arrays.toString(Arrays.copyOfRange(arr, index, i)));
                }
                indexes.add(i);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2, 0};
        System.out.println(Arrays.toString(subArraySum(arr, 0)));
        System.out.println(Arrays.toString(subArraySum(arr, 5)));
        printAllSubArraySum(arr, 0);
    }
}
