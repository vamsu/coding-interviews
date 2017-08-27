package org.vamsu.interview.solutions.arrays;

import org.vamsu.interview.solutions.utils.PrintUtils;

import java.util.HashMap;
import java.util.Map;

public class TwoSumSolution {
    public static void main(String[] args) {
        TwoSumSolution twoSumSolution = new TwoSumSolution();
        int[] twoSumResult = twoSumSolution.solve(new int[]{2, 7, 11, 15}, 9);
        PrintUtils.prettyPrint("TwoSumSolution Result", twoSumResult);

        twoSumResult = twoSumSolution.solve(new int[]{3, 2, 4}, 6);
        PrintUtils.prettyPrint("TwoSumSolution Result", twoSumResult);
    }

    public int[] solve(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
